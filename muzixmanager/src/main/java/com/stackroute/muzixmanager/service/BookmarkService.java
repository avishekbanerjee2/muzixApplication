/**
 * 
 */
package com.stackroute.muzixmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.repository.BookmarkRepository;

/**
 * @author ubuntu
 *
 */
@Service
public class BookmarkService {
	@Autowired
	BookmarkRepository bookmarkRepository;

	
	
	
	public boolean createBookMark(BookmarkEntity bookmarkEntity) {
		try {
			bookmarkRepository.save(bookmarkEntity);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public boolean deleteBookmark(Long bookmarkId) {
		try {
			Optional<BookmarkEntity> bookmarkList=bookmarkRepository.findById(bookmarkId);
			if(bookmarkList.isPresent()) {
				BookmarkEntity bookmark= bookmarkList.get();
				bookmarkRepository.delete(bookmark);
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
	public List<BookmarkEntity> getBookmarksByUserId(Long userId){
		try {
		return bookmarkRepository.getBookmarkByUserId(userId);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}
	
	
}
