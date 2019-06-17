/**
 * 
 */
package com.stackroute.muzixmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.muzixmanager.entity.SearchHistoryEntity;
import com.stackroute.muzixmanager.repository.SearchHistoryRepository;

/**
 * @author ubuntu
 *
 */
@Service
public class SearchHistoryService {
	@Autowired
	SearchHistoryRepository searchHistoryRepository;
	
	public boolean saveSearchHistory(SearchHistoryEntity searchHistoryEntity) {
		try {
			searchHistoryRepository.save(searchHistoryEntity);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public SearchHistoryEntity getSearchHistory(String userId) {
		
		try {
			List<SearchHistoryEntity> searchHistoryEntity=searchHistoryRepository.getSearchHistory(userId);
			if(searchHistoryEntity!=null) {
				return searchHistoryEntity.get(0);	
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}
	
	
	

}
