package model;

public class Album {

	private long albumId;
	private String title;
	private Artist artist;
	
	public Album(long albumId, String title, Artist artist) {
		this.albumId = albumId;
		this.title = title;
		this.artist = artist;
	}
	
	public Album(String title, Artist artist) {
		this.title = title;
		this.artist = artist;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", title=" + title + ", artist=" + artist + "]";
	}
	
}
