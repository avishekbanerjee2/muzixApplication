package com.stackroute.muzixmanager.dto;

import java.io.Serializable;
import java.util.List;




public class Playlist implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long playlistId;

	private String playlistName;

	private List<Muzix> muzixs;

	private Long userId;

	public Long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}


	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public List<Muzix> getMuzixs() {
		return muzixs;
	}

	public void setMuzixs(List<Muzix> muzixs) {
		this.muzixs = muzixs;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	

	
	
}
