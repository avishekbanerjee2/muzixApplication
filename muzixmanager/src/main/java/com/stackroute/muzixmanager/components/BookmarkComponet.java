/**
 * 
 */
package com.stackroute.muzixmanager.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.muzixmanager.dto.Bookmark;
import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.service.BookmarkService;
import com.stackroute.muzixmanager.service.UserService;

/**
 * @author ubuntu
 *
 */
@Component
public class BookmarkComponet {
	
	@Autowired
	BookmarkService bookmarkService;
	@Autowired
	UserService userService;
	@Autowired
	UserComponet userComponet;
	

	public boolean createBookMark(Muzix muzix,String userId) {
		try {
			
			if(checkDuplicateBookmark(muzix,userId)) {
				return false;
			}
			
			BookmarkEntity bookmarkEntity=new BookmarkEntity();
			System.out.println("User Id"+userId+"Muzix: "+muzix.toString());
			MuzixEntity muzixEntity=new MuzixEntity();
			muzixEntity.setArtist(muzix.getArtist());
			muzixEntity.setImageUrl(muzix.getImageUrl());
			muzixEntity.setMbid(muzix.getMbid());
			muzixEntity.setName(muzix.getName());
			muzixEntity.setUrl(muzix.getUrl());
			bookmarkEntity.setMuzix(muzixEntity);
			bookmarkEntity.setUserEntity(userService.getUserByUserId(userId));
			bookmarkService.createBookMark(bookmarkEntity);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	private boolean checkDuplicateBookmark(Muzix muzix,String userId) {
		List<Bookmark> bookmarks=userComponet.getBookmarksByUserId(userId);
		for (Bookmark bookmark : bookmarks) {
			if(muzix.getArtist().equalsIgnoreCase(bookmark.getMuzix().getArtist()) && muzix.getName().equalsIgnoreCase(bookmark.getMuzix().getName())) {
			return true;
			}
			
			
		}
		
		
		return false;
		
	}
	
	
	public boolean deleteBookmark(Long boolmarkId) {
		try {
			bookmarkService.deleteBookmark(boolmarkId);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
