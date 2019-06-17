package com.stackroute.muzixmanager.dto;

import java.io.Serializable;

public class SearchHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long searchHistoryId;

	private String userId;
	
	private String searchData;
	
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

	@Override
	public String toString() {
		return "SearchHistory [searchHistoryId=" + searchHistoryId + ", userId=" + userId + ", searchData=" + searchData
				+ ", artistName=" + artistName + "]";
	}
	
	
	
}
