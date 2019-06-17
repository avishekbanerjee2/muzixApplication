/**
 * 
 */
package com.stackroute.muzixmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.entity.UserEntity;
import com.stackroute.muzixmanager.repository.UserRepository;

/**
 * @author ubuntu
 *
 */
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	
	
	
	
	public List<PlaylistEntity> getPlaylists(String userId){
		try {
			Optional<UserEntity> userEntity=	userRepository.findById(userId);
			if(userEntity.isPresent()) {
				UserEntity user=userEntity.get();
				return user.getPlaylistEntities();
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<BookmarkEntity> getBookmarks(String userId){
		try {
			Optional<UserEntity> userEntity=	userRepository.findById(userId);
			if(userEntity.isPresent()) {
				UserEntity user=userEntity.get();
				return user.getBookmarkEntities();
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public UserEntity getUserByUserId(String userID) {
		try {
	Optional<UserEntity> userEntity=	userRepository.findById(userID)	;
	
	if(userEntity.isPresent()) {
		UserEntity user=userEntity.get();
		System.out.println("User Entitty: "+user);
		return user;
		}
		else {
		return null;
		}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
}
