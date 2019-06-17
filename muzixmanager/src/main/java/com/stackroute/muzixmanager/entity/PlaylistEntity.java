/**
 * 
 */
package com.stackroute.muzixmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ubuntu
 *
 */
@Entity
@Table(name="playlist")
public class PlaylistEntity {


	@Id
	@Column(name="playlist_id")
	@GeneratedValue
	private Long playlistId;

	
	
	@Column(name="playlist_name")
	private String playlistName;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="muzix_playlist_map",joinColumns = @JoinColumn(name="playlist_id",referencedColumnName = "playlist_id"),inverseJoinColumns = @JoinColumn(name="muzix_id",referencedColumnName = "muzix_id"))
	private List<MuzixEntity> muzixs;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

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

	public List<MuzixEntity> getMuzixs() {
		return muzixs;
	}

	public void setMuzixs(List<MuzixEntity> muzixs) {
		this.muzixs = muzixs;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	
	
	
	
	
}
