package com.stackroute.muzixmanager.dto;

import java.io.Serializable;

public class Muzix implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int muzixId;

	private String mbid;

	private String name;

	private String artist;

	private String url;
	

	private String imageUrl;
	/**
	private List<PlaylistEntity> playlistEntity;
	
	private List<BookmarkEntity> bookmarkEntity; **/

	public int getMuzixId() {
		return muzixId;
	}

	public void setMuzixId(int muzixId) {
		this.muzixId = muzixId;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Muzix [muzixId=" + muzixId + ", mbid=" + mbid + ", name=" + name + ", artist=" + artist + ", url=" + url
				+ ", imageUrl=" + imageUrl + "]";
	}

	
}
