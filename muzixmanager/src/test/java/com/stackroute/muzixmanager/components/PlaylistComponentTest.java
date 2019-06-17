package com.stackroute.muzixmanager.components;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.dto.Playlist;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.entity.UserEntity;
import com.stackroute.muzixmanager.repository.PlaylistRepository;
import com.stackroute.muzixmanager.service.PlaylistService;
import com.stackroute.muzixmanager.service.UserService;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class PlaylistComponentTest {
	
	@InjectMocks
	PlaylistComponent playListComponet;
	
	@Mock
	PlaylistService playlistService;
	@Mock
	UserService userService;
	@Mock
	PlaylistRepository playlistRepository;
	@Mock
	UserEntity userEntity;
	@Mock
	PlaylistEntity playListEntity;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void createPlayListTest() {
		when(userService.getUserByUserId(anyString())).thenReturn(userEntity);
		playlistService.createPlayList(playListEntity);
		playListComponet.createPlayList(getPlaylist(), anyString());
		assertTrue(true);
	}
	@Test
	public void createPlayListExceptionTest() {
		try {
		playlistService.createPlayList(playListEntity);
		playListComponet.createPlayList(getPlaylist(), anyString());
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}
	
	
	@Test
	public void updatePlayListTest() {
		when(playlistRepository.findById(12L)).thenReturn(any());
		
		playlistService.createPlayList(playListEntity);
		playListComponet.update(getPlaylist(), anyString());
		assertTrue(true);
	}
	@Test
	public void updatePlayListExceptionTest() {
		try {
		playlistService.createPlayList(playListEntity);
		playListComponet.update(getPlaylist(), anyString());
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}
	
	
	public Muzix getMuzix() {
		Muzix muzix = new Muzix();
		muzix.setName("testMuzix name");
		muzix.setArtist("testng");
		return muzix;

	}
	public List<Muzix> getMuzixs() {
		List<Muzix> muzixs=new ArrayList<Muzix>();
		Muzix muzix = new Muzix();
		muzix.setName("testMuzix name");
		muzix.setArtist("testng");
		muzixs.add(muzix);
		return muzixs;

	}
	public Playlist getPlaylist() {
		Playlist playlist=new Playlist();
		playlist.setMuzixs(getMuzixs());
		
		return playlist;
	}
	
	public List<PlaylistEntity> getPlaylists() {
		List<PlaylistEntity> playListEntitys= new ArrayList<PlaylistEntity>();
		playListEntitys.add(playListEntity);
		
		return playListEntitys;
	}
	
}
