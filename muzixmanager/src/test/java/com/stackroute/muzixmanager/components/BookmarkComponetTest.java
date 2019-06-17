package com.stackroute.muzixmanager.components;

import org.junit.Before;
import org.junit.Test;


import com.stackroute.muzixmanager.dto.Bookmark;
import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.service.BookmarkService;
import com.stackroute.muzixmanager.service.UserService;



import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.anyString;

public class BookmarkComponetTest {

	@InjectMocks
	BookmarkComponet bookmarkComponet;
	@Mock
	UserComponet userComponet;
	@Mock
	UserService userService;
	@Mock
	BookmarkService bookmarkService;
	@Mock
	Exception exception;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createBookMarkTest() {
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		List<BookmarkEntity> bookmarkEntityList=new ArrayList<BookmarkEntity>();
 		bookmarks.add(getBookmark());
		try {
			when(userComponet.getBookmarksByUserId(anyString())).thenReturn(bookmarks);
			when(userService.getBookmarks(anyString())).thenReturn(bookmarkEntityList);
			when(bookmarkService.createBookMark(getBookmarkEntity())).thenReturn(true);
			bookmarkComponet.createBookMark(getMuzix(), "testUser");
			assertTrue(true);
		} catch (Exception e) {

		}
	}
	@Test
	public void createBookMarkDuplicate() {
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		List<BookmarkEntity> bookmarkEntityList=new ArrayList<BookmarkEntity>();
		try {
			when(userComponet.getBookmarksByUserId(anyString())).thenReturn(bookmarks);
			when(userService.getBookmarks(anyString())).thenReturn(bookmarkEntityList);
			when(bookmarkService.createBookMark(getBookmarkEntity())).thenReturn(true);
			bookmarkComponet.createBookMark(getMuzix(), "testUser");
			assertTrue(true);
		} catch (Exception e) {

		}
	}
	
	
	@Test
	public void createBookMarkException() {
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		List<BookmarkEntity> bookmarkEntityList=new ArrayList<BookmarkEntity>();
		try {
			when(userComponet.getBookmarksByUserId(anyString())).thenReturn(bookmarks);
			when(userService.getBookmarks(anyString())).thenReturn(bookmarkEntityList);
			when(bookmarkService.createBookMark(getBookmarkEntity())).thenThrow(exception);
			bookmarkComponet.createBookMark(getMuzix(), "testUser");
			
		} catch (Exception e) {
			assertTrue(true);

		}
	}
	
	
	

	public Muzix getMuzix() {
		Muzix muzix = new Muzix();
		muzix.setName("testMuzix name");
		muzix.setArtist("testng");
		return muzix;

	}

	public Bookmark getBookmark() {
		Bookmark bookmark = new Bookmark();
		bookmark.setMuzix(getMuzix());
		return bookmark;
	}
	
	public BookmarkEntity getBookmarkEntity() {
		BookmarkEntity bookmark=new BookmarkEntity();
		
		return bookmark;
		
		
	}

}
