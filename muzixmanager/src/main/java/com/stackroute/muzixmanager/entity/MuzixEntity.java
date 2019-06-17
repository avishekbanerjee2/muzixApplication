package com.stackroute.muzixmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "muzix")
public class MuzixEntity {

	@Id
	@Column(name = "muzix_id")
	@GeneratedValue
	private int muzixId;

	@Column(name = "mbid")
	private String mbid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "artist")
	private String artist;
	
	@Column(name = "url")
	private String url;
	
	@Column(name="image_url")
	private String imageUrl;
	

	@ManyToMany(mappedBy = "muzixs",cascade = CascadeType.ALL)
	private List<PlaylistEntity> playlistEntity;
	
	@OneToMany(mappedBy = "muzix",cascade = CascadeType.ALL)
	private List<BookmarkEntity> bookmarkEntity;

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

	

	public List<PlaylistEntity> getPlaylistEntity() {
		return playlistEntity;
	}

	public void setPlaylistEntity(List<PlaylistEntity> playlistEntity) {
		this.playlistEntity = playlistEntity;
	}

	public List<BookmarkEntity> getBookmarkEntity() {
		return bookmarkEntity;
	}

	public void setBookmarkEntity(List<BookmarkEntity> bookmarkEntity) {
		this.bookmarkEntity = bookmarkEntity;
	}
	

}
