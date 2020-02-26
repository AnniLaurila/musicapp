package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artist;

public class JDBCArtistDao implements ArtistDao {

	private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");
	
	@Override
    public List<Artist> getAllArtists() {
		
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        List<Artist> allArtists = new ArrayList<>();

        try {
            connection = connect();
            statement = connection.prepareStatement("select * from artist order by artistid asc");
            result = statement.executeQuery();

            while (result.next()) {
                Artist artist = new Artist(result.getLong("artistid"), result.getString("name"));
                allArtists.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(result, statement, connection);
        }
        return allArtists;
    }
	
	@Override
	public Artist getArtist(long artistId) {
		
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        Artist artist = null;
        
        try {
            connection = connect();
            statement = connection.prepareStatement("select * from artist where artistid = ?");
            statement.setLong(1, artistId);
            result = statement.executeQuery();
            
            if (result.next()) {
                artist = new Artist(result.getLong("artistid"), result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(result, statement, connection);
        }
        return artist;
	}
	
	@Override
	public boolean addArtist(Artist newArtist) {
		
		Connection connection = null;
        PreparedStatement statement = null;
        boolean success = false;
        
        try {
        	connection = connect();
        	statement = connection.prepareStatement("insert into artist (name) values (?)",
        			Statement.RETURN_GENERATED_KEYS);
        	statement.setString(1, newArtist.getName());

             if (statement.executeUpdate() == 1) {
                 long generatedKey = statement.getGeneratedKeys().getLong(1);
                 newArtist.setArtistId(generatedKey);
             }
             
             success = true;
             
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             closeResources(statement, connection);
         }
        
         return success;
        			
	}

	
	@Override
	public boolean removeArtist(Artist artist) {
		return false;
	}
	
    protected Connection connect() throws SQLException {
        if (JDBC_URL == null) {
            throw new RuntimeException("JDBC_DATABASE_URL environment variable not found");
        } else {
            return DriverManager.getConnection(JDBC_URL);
        }
    }
    
    private static void closeResources(AutoCloseable... sqlResources) {
        for (AutoCloseable a : sqlResources) {
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
}

