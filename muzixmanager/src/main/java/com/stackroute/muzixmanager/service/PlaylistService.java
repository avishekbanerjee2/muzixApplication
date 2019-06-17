/**
 * 
 */
package com.stackroute.muzixmanager.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.repository.PlaylistRepository;

/**
 * @author ubuntu
 *
 */
@Service
public class PlaylistService {
	@Autowired
	PlaylistRepository playlistRepository;
	
	public void createPlayList(PlaylistEntity playlist) {
		try {
		playlistRepository.save(playlist);
		}catch(Exception e) {
			e.printStackTrace();	
		}
	}
	


	public List<PlaylistEntity> getPlaylistByUserId(Long userId) throws Exception{
		try {
			
			System.out.println("UserId: "+userId);
			return playlistRepository.getPlaylistsByUserId(userId);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		}	
	}
	
	
	/*public boolean deletePlayList(Long playlistId,Long muzixId) {
		try {
			Optional<PlaylistEntity> playlist=playlistRepository.findById(playlistId);
			if(playlist.isPresent()) {
				PlaylistEntity playlistEntity= playlist.get();
				playlistRepository.delete(playlistEntity);
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}*/


	public boolean deleteMuzixFromPlayList(Long playlistId, long muzixId) {
		try {
			Optional<PlaylistEntity> playlist=playlistRepository.findById(playlistId);
			if(playlist.isPresent()) {
				PlaylistEntity playlistEntity= playlist.get();
				
				List<MuzixEntity> muzixEntityList  =new ArrayList<MuzixEntity>();				
				
				List<MuzixEntity> muzixEntityList1 = playlistEntity.getMuzixs();
				muzixEntityList.addAll(muzixEntityList1);

				Iterator<MuzixEntity> i1  = muzixEntityList1.iterator();
				while (i1.hasNext()){
				   MuzixEntity muzixEntity = i1.next();
				   if(muzixEntity.getMuzixId() == muzixId){
					   i1.remove();
						
					}
				   
				}
				/*for(MuzixEntity muzixEntity : muzixEntityList){
					if(muzixEntity.getMuzixId() == muzixId){
						muzixEntityList.remove(muzixEntity);
						
					}
				}*/
				playlistEntity.setMuzixs(muzixEntityList1);
				
				playlistRepository.save(playlistEntity);
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
	

}
