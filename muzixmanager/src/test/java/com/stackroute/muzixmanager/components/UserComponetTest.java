package com.stackroute.muzixmanager.components;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.muzixmanager.dto.Bookmark;
import com.stackroute.muzixmanager.dto.Playlist;
import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.service.UserService;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
public class UserComponetTest {
	@Mock
	UserService userService;
	@InjectMocks
	UserComponet userComponet;
	@Mock
	BookmarkEntity bookmark;
	@Mock
	PlaylistEntity playlist;
	@Mock
	MuzixEntity umzix;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public void getPlayListTest() {
		when(userService.getPlaylists(anyString())).thenReturn(getPlaylist());
		List<Playlist> result=userComponet.getPlayList(anyString());
		assertTrue(true);
		
		
	}
	
	public List<BookmarkEntity> getBookmarks(){
		List<BookmarkEntity> bookmarks=new ArrayList<BookmarkEntity>();
		bookmark.setMuzix(umzix);
		bookmarks.add(bookmark);
		return bookmarks;
	}
	
	public List<PlaylistEntity> getPlaylist(){
		List<PlaylistEntity> playLists=new ArrayList<PlaylistEntity>();
		
		playLists.add(playlist);
		return playLists;
	}
	
}
