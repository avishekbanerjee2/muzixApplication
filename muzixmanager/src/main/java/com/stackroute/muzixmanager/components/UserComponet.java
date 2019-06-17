/**
 * 
 */
package com.stackroute.muzixmanager.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.muzixmanager.dto.Bookmark;
import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.dto.Playlist;
import com.stackroute.muzixmanager.dto.User;
import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.entity.UserEntity;
import com.stackroute.muzixmanager.service.UserService;

/**
 * @author ubuntu
 *
 */
@Component
public class UserComponet {
	@Autowired
	UserService userService;
	
	
	
	
	
	
	public List<Playlist> getPlayList(String userId){	
	List<PlaylistEntity> playListEntities=	userService.getPlaylists(userId);
	List<Playlist> playLists=new ArrayList<Playlist>();
	for (PlaylistEntity playlistEntity : playListEntities) {
		Playlist playlist=new Playlist();
		List<Muzix> muzixs=new ArrayList<Muzix>();
		for (MuzixEntity playlist2 : playlistEntity.getMuzixs()) {
			Muzix muzix=new Muzix();
			muzix.setArtist(playlist2.getArtist());
			muzix.setImageUrl(playlist2.getImageUrl());
			muzix.setMbid(playlist2.getMbid());
			muzix.setMuzixId(playlist2.getMuzixId());
			muzix.setName(playlist2.getName());
			muzix.setUrl(playlist2.getUrl());
			muzixs.add(muzix);
		}
		playlist.setMuzixs(muzixs);
		playlist.setPlaylistId(playlistEntity.getPlaylistId());
		playlist.setPlaylistName(playlistEntity.getPlaylistName());
		playLists.add(playlist);
		
	}
	return playLists;	
	}
	
	public List<Bookmark> getBookmarksByUserId(String userId){
		List<BookmarkEntity> bookmarkEntityes=userService.getBookmarks(userId);
		List<Bookmark> bookmarks=new ArrayList<Bookmark>();
		for (BookmarkEntity bookmarkEntity : bookmarkEntityes) {
			Bookmark bookmark=new Bookmark();
			
			bookmark.setBookmarkId(bookmarkEntity.getBookmarkId());
			Muzix muzix=new Muzix();
			muzix.setArtist(bookmarkEntity.getMuzix().getArtist());
			muzix.setImageUrl(bookmarkEntity.getMuzix().getImageUrl());
			muzix.setMbid(bookmarkEntity.getMuzix().getMbid());
			muzix.setMuzixId(bookmarkEntity.getMuzix().getMuzixId());
			muzix.setName(bookmarkEntity.getMuzix().getName());
			muzix.setUrl(bookmarkEntity.getMuzix().getUrl());
			bookmark.setMuzix(muzix);
			bookmarks.add(bookmark);
		}
		return bookmarks;
	}

}
