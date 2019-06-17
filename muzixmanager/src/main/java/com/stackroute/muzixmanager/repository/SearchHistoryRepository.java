/**
 * 
 */
package com.stackroute.muzixmanager.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixmanager.entity.SearchHistoryEntity;

/**
 * @author ubuntu
 *
 */
@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistoryEntity, Long>{
	
	@Query(value = "select em from SearchHistoryEntity em where em.userId = :userId order by em.searchHistoryId desc")
	public List<SearchHistoryEntity> getSearchHistory(String userId) ;

}
