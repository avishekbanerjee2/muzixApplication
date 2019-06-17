/**
 * 
 */
package com.stackroute.muzixmanager.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

/**
 * @author ubuntu
 *
 */
@Entity
@Table(name="user")
public class UserEntity {
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", created=" + created + ", playlistEntities=" + playlistEntities + ", bookmarkEntities="
				+ bookmarkEntities + "]";
	}

	@Id
	private String userId;

	private String firstName;

	private String lastName;

	private String password;

	@CreationTimestamp
	private Date created;
	
	
	@OneToMany(mappedBy = "userEntity")
	private List<PlaylistEntity> playlistEntities;
	
	@OneToMany(mappedBy = "userEntity")
	private List<BookmarkEntity> bookmarkEntities;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PlaylistEntity> getPlaylistEntities() {
		return playlistEntities;
	}

	public void setPlaylistEntities(List<PlaylistEntity> playlistEntities) {
		this.playlistEntities = playlistEntities;
	}

	public List<BookmarkEntity> getBookmarkEntities() {
		return bookmarkEntities;
	}

	public void setBookmarkEntities(List<BookmarkEntity> bookmarkEntities) {
		this.bookmarkEntities = bookmarkEntities;
	}
	
	
	
	

}
