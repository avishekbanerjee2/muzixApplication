/**
 * 
 */
package com.stackroute.muzixmanager.dto;

import java.io.Serializable;



/**
 * @author ubuntu
 *
 */
public class Bookmark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long bookmarkId;

	private Long userId;
	
	private Muzix muzix;

	public Long getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(Long bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	

	public Muzix getMuzix() {
		return muzix;
	}

	public void setMuzix(Muzix muzix) {
		this.muzix = muzix;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Bookmark [bookmarkId=" + bookmarkId + ", userId=" + userId + ", muzix=" + muzix + "]";
	}

	
	

	
	
}
