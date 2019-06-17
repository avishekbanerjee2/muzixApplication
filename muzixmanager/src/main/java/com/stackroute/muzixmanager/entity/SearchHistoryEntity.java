/**
 * 
 */
package com.stackroute.muzixmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ubuntu
 *
 */
@Entity
@Table(name="search_history")
public class SearchHistoryEntity {
	
	@Id
	@Column(name="search_history_id")
	@GeneratedValue
	private Long searchHistoryId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name="search_data")
	private String searchData;
	
	@Column(name="artist")
	private String artistName;
	
	public Long getSearchHistoryId() {
		return searchHistoryId;
	}
	public void setSearchHistoryId(Long searchHistoryId) {
		this.searchHistoryId = searchHistoryId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSearchData() {
		return searchData;
	}
	public void setSearchData(String searchData) {
		this.searchData = searchData;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	
	

}
