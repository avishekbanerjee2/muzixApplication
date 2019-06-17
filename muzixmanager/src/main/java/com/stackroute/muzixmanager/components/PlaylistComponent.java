package com.stackroute.muzixmanager.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.dto.Playlist;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.repository.PlaylistRepository;
import com.stackroute.muzixmanager.service.PlaylistService;
import com.stackroute.muzixmanager.service.UserService;

@Component
public class PlaylistComponent {
	
	@Autowired
	PlaylistService playlistService;
	@Autowired
	UserService userService;
	@Autowired
	PlaylistRepository playlistRepository;
	
	public boolean createPlayList(Playlist playlist,String userId) {
		try {	
			PlaylistEntity playlistEntity=new PlaylistEntity();			
			List<MuzixEntity> muzixs=new ArrayList<MuzixEntity>();
			
			for (Muzix muzixdata : playlist.getMuzixs()) {
				MuzixEntity muzix=new MuzixEntity();
				muzix.setArtist(muzixdata.getArtist());
				muzix.setImageUrl(muzixdata.getImageUrl());
				muzix.setMbid(muzixdata.getMbid());
				muzix.setMuzixId(muzixdata.getMuzixId());
				muzix.setName(muzixdata.getName());
				muzix.setUrl(muzixdata.getUrl());
				muzixs.add(muzix);
			}
			playlistEntity.setMuzixs(muzixs);
			playlistEntity.setPlaylistName(playlist.getPlaylistName());
			playlistEntity.setUserEntity(userService.getUserByUserId(userId));
			playlistService.createPlayList(playlistEntity);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(Playlist playlist,String userId) {
		try {	
			Optional<PlaylistEntity> playListData=playlistRepository.findById(playlist.getPlaylistId());
			if(playListData.isPresent()) {
				PlaylistEntity playlistEntity=playListData.get();	
				List<MuzixEntity> muzixs=playlistEntity.getMuzixs();
				
				for (Muzix muzixdata : playlist.getMuzixs()) {
					MuzixEntity muzix=new MuzixEntity();
					muzix.setArtist(muzixdata.getArtist());
					muzix.setImageUrl(muzixdata.getImageUrl());
					muzix.setMbid(muzixdata.getMbid());
					muzix.setMuzixId(muzixdata.getMuzixId());
					muzix.setName(muzixdata.getName());
					muzix.setUrl(muzixdata.getUrl());
					muzixs.add(muzix);
				}
			
				playlistEntity.setMuzixs(muzixs);
			
				playlistService.createPlayList(playlistEntity);
				return true;
			}else
			{
				return false;
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	

	
	
	public boolean deletePlaylist(long playlistId,long muzixId) {
	try {
		return playlistService.deleteMuzixFromPlayList(playlistId,muzixId);
	}catch(Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	
	
/**	public List<Playlist> getPlaylistsByUserId(Long userId) throws Exception{
		try {
			System.out.println(userId);
			List<PlaylistEntity> playlistEntities=playlistService.getPlaylistByUserId(userId);
			List<Playlist> playlists=new ArrayList<Playlist>();
			for (PlaylistEntity playlistEntity : playlistEntities) {
				Playlist playlist=new Playlist();
				playlist.setMuzixs(playlistEntity.getMuzixs());
				playlist.setPlaylistName(playlistEntity.getPlaylistName());
				playlist.setUserEntity(playlistEntity.getUserEntity());
		
				playlists.add(playlist);
			}
			return playlists;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
**/
}
