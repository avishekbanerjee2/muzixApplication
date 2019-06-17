/**
 * 
 */
package com.stackroute.muzixmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixmanager.entity.BookmarkEntity;


/**
 * @author ubuntu
 *
 */
@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Long>{
	@Query(value = "select em from BookmarkEntity em where em.userEntity.userId = :userId")
	public List<BookmarkEntity> getBookmarkByUserId(@Param(value = "userId")Long userId);
}
