package database;

import java.util.List;

import model.Artist;

public interface ArtistDao {

	public List<Artist> getAllArtists();
	
	public Artist getArtist(long artistId);
	
	public boolean addArtist(Artist newArtist);
	
	public boolean removeArtist(Artist artist);
}
