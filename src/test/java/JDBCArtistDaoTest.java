import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.Database;
import database.JDBCArtistDao;
import model.Artist;

//VM-argumentteihin lisättävä testikannan url
//-DJDBC_DATABASE_URL=jdbc:sqlite:C:\\OmatOhjelmat\\sqliteman\\Sqliteman-1.2.2\\Chinook_SqliteTest.sqlite


class JDBCArtistDaoTest {

	private static final String JDBC_URL = System.getProperty("JDBC_DATABASE_URL");
    private JDBCArtistDao dao = new JDBCArtistDao();
    Connection connection = null;


	
    @BeforeEach
    public void setUp() throws Exception {
    	connection = Database.connect(JDBC_URL);
        connection.prepareStatement("delete from artist").executeUpdate();
        connection.prepareStatement("insert into artist (name) values ('Artisti 1')").executeUpdate();
        connection.prepareStatement("insert into artist (name) values ('Artisti 2')").executeUpdate();
    }

	@Test
	public void testGetAllArtists() {
		List<Artist> artistit = new ArrayList<Artist>();
		artistit.addAll(dao.getAllArtists());
		assertEquals(2, artistit.size());
	}
	
	@Test
	public void testGetArtist() {
		Artist artisti = dao.getArtist(1);
		assertEquals("Artisti 1", artisti.getName());
	}
	
	@Test 
	public void testAddArtist() {
		Artist artisti = new Artist("Artisti 3");
		dao.addArtist(artisti);
		assertEquals(3, artisti.getArtistId());
	}
	

	@AfterEach
	public void tearDown() {
		Database.closeResources(connection);
	}
	
}
