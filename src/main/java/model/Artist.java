package model;

public class Artist {

	private long artistId;
	private String name;
	
	public Artist(long artistId, String name) {
		this.artistId = artistId;
		this.name = name;
	}
	
	public Artist(String name) {
		this.name = name;
	}

	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", name=" + name + "]";
	}	
}
