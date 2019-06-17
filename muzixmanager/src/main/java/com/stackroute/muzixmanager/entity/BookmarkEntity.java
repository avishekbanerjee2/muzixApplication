/**
 * 
 */
package com.stackroute.muzixmanager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ubuntu
 *
 */
@Entity
@Table(name = "bookmark")
public class BookmarkEntity {
	
	@Id
	@Column(name="bookmark_id")
	@GeneratedValue
	private Long bookmarkId;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "muzix_id")
	private MuzixEntity muzix;


	public Long getBookmarkId() {
		return bookmarkId;
	}


	public void setBookmarkId(Long bookmarkId) {
		this.bookmarkId = bookmarkId;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	


	public MuzixEntity getMuzix() {
		return muzix;
	}


	public void setMuzix(MuzixEntity muzix) {
		this.muzix = muzix;
	}
	
	
	
	


	
	

}
