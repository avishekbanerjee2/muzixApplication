/**
 * 
 */
package com.stackroute.muzixmanager.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.muzixmanager.dto.SearchHistory;
import com.stackroute.muzixmanager.entity.SearchHistoryEntity;
import com.stackroute.muzixmanager.service.SearchHistoryService;

/**
 * @author ubuntu
 *
 */
@Component
public class SearchHistoryComponent {
	@Autowired
	SearchHistoryService searchHistoryService;
	
	public boolean saveSearchHistory(SearchHistory searchHistory,String userId) {
		try {
			System.out.println("searchHistory================="+searchHistory);
			SearchHistoryEntity searchHistoryEntity=new SearchHistoryEntity();
			searchHistoryEntity.setSearchData(searchHistory.getSearchData());
			searchHistoryEntity.setUserId(userId);
			searchHistoryEntity.setArtistName(searchHistory.getArtistName());
			searchHistoryService.saveSearchHistory(searchHistoryEntity);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	
	}
	
	public SearchHistory getLastSearchHistory(String userId) {
		
		try {
			SearchHistoryEntity searchHistoryEntity=searchHistoryService.getSearchHistory(userId);
			SearchHistory searchHistory=new SearchHistory();
			searchHistory.setSearchData(searchHistoryEntity.getSearchData());
			searchHistory.setSearchHistoryId(searchHistoryEntity.getSearchHistoryId());
			searchHistory.setUserId(searchHistoryEntity.getUserId());
			searchHistory.setArtistName(searchHistoryEntity.getArtistName());
			return searchHistory;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}
	

}
