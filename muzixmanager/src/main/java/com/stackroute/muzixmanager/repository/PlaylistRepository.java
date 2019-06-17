/**
 * 
 */
package com.stackroute.muzixmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixmanager.entity.PlaylistEntity;

/**
 * @author ubuntu
 *
 */
@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {

	@Query(value = "select em from PlaylistEntity em where em.userEntity.userId = :userId")
	public List<PlaylistEntity> getPlaylistsByUserId(@Param(value = "userId")Long userId);
	
}
