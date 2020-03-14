package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Artist;

public class JDBCAlbumDao implements AlbumDao {
	
	private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");
	private final JDBCArtistDao artistDao = new JDBCArtistDao();
	
	public List<Album> getAlbumsByArtist(long artistId) {
		
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        List<Album> allAlbums = new ArrayList<Album>();
        
        try {
            connection = Database.connect(JDBC_URL);
            statement = connection.prepareStatement("select albumid, title, artistid from album where artistid = ?");
            statement.setLong(1, artistId);
            result = statement.executeQuery();
            
            while (result.next()) {
            	Artist artist = artistDao.getArtist(result.getLong("artistid"));
                Album album = new Album(result.getLong("albumid"), result.getString("title"), artist);
                allAlbums.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	Database.closeResources(result, statement, connection);
        }
        
		return allAlbums;
	}
	
}
