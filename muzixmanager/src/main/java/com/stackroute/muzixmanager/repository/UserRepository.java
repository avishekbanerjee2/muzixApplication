/**
 * 
 */
package com.stackroute.muzixmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixmanager.entity.UserEntity;

/**
 * @author ubuntu
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	@Query(value = "select em from UserEntity em where em.userId=:userName ")
	public UserEntity getUserByUserName(@Param(value = "userName")String userName);

}
