package com.stackroute.muzixmanager.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.muzixmanager.components.BookmarkComponet;
import com.stackroute.muzixmanager.components.MuzixComponent;
import com.stackroute.muzixmanager.components.PlaylistComponent;
import com.stackroute.muzixmanager.components.SearchHistoryComponent;
import com.stackroute.muzixmanager.components.UserComponet;
import com.stackroute.muzixmanager.dto.Bookmark;
import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.dto.Playlist;
import com.stackroute.muzixmanager.dto.SearchHistory;
import com.stackroute.muzixmanager.dto.User;
import com.stackroute.muzixmanager.entity.MuzixEntity;

import com.stackroute.muzixmanager.service.MuzixService;


import io.jsonwebtoken.Jwts;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/muzixService")
public class MuzixServiceController {
@Autowired
	private MuzixService muzixService;
	@Autowired
	private PlaylistComponent playlistComponent;
	@Autowired
	private UserComponet userComponet;
	@Autowired
	private BookmarkComponet bookmarkComponet;
	@Autowired
	private MuzixComponent muzixComponet;
	@Autowired
	private SearchHistoryComponent searchHistoryComponent;

	

	
	@GetMapping(path = "/getPlaylistByUser")
	public ResponseEntity<?> getPlaylistByUser(HttpServletRequest req,HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<Playlist> playList = null;
		try {
			HttpServletRequest request = (HttpServletRequest)req;
			String authHeader = request.getHeader("authorization");
			String token = authHeader.substring(7);
			String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
			System.out.println("User Id Value******"+userId);
			playList = userComponet.getPlayList(userId);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<List<Playlist>>(playList, HttpStatus.OK);
		return responseEntity;
	} 
	

	@GetMapping(path = "/bookmark")
	public ResponseEntity<?> getBookmarkByUser(HttpServletRequest req,HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<Bookmark> bookmarks = null;
		try {
			HttpServletRequest request = (HttpServletRequest)req;
			String authHeader = request.getHeader("authorization");
			String token = authHeader.substring(7);
			String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
			System.out.println("User Id Value******"+userId);
			bookmarks = userComponet.getBookmarksByUserId(userId);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<List<Bookmark>>(bookmarks, HttpStatus.OK);
		return responseEntity;
	} 
	
	
	
	@PostMapping("/createbookmark")
	public ResponseEntity<?> createBookmark(@RequestBody final Muzix muzix, HttpServletRequest req,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		try {
			HttpServletRequest request = (HttpServletRequest)req;
			String authHeader = request.getHeader("authorization");
			String token = authHeader.substring(7);
			String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
			System.out.println("User Id Value******"+userId);
			boolean result=bookmarkComponet.createBookMark(muzix, userId);
			if(result) {
				responseEntity = new ResponseEntity<Muzix>(muzix, HttpStatus.CREATED);
			}else {
				responseEntity = new ResponseEntity<Muzix>(muzix, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	
	
	
	@PostMapping("/saveMuzix")
	public ResponseEntity<?> saveMuzix(@RequestBody final Muzix muzix, HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		try {
			muzixComponet.saveMuzix(muzix);
			responseEntity = new ResponseEntity<Muzix>(muzix, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	

	@PostMapping("/saveMuzixs")
	public ResponseEntity<?> saveMuzixs(@RequestBody final List<Muzix> muzixs, HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		try {
			muzixComponet.saveMuzixs(muzixs);
			responseEntity = new ResponseEntity<List<Muzix>>(muzixs, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}


	@GetMapping(path = "/muzix/{muzixId}")
	public ResponseEntity<?> fetchMuzixById(@PathVariable("muzixId") final int muzixId) {
		ResponseEntity<?> responseEntity;
		Muzix thisMuzix = null;
		try {
			thisMuzix = muzixComponet.getMuzixByMusixId(muzixId);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<Muzix>(thisMuzix, HttpStatus.OK);
		return responseEntity;
	} 

	@PostMapping("/muzix")
	public ResponseEntity<?> saveNewMuzix(@RequestBody final Muzix muzix, HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		String authHeader = request.getHeader("authorization");
		String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		try {
			muzix.setMbid(String.valueOf(muzix.getMbid()));			
			MuzixEntity muzixEntity=new MuzixEntity();
			muzixEntity.setMbid(String.valueOf(muzix.getMbid()));
			muzixService.saveMuzix(muzixEntity);
			responseEntity = new ResponseEntity<Muzix>(muzix, HttpStatus.CREATED);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	

	@DeleteMapping(value = "/muzix/bookmark/{bookmarkId}")
	public ResponseEntity<?> deleteMuzixById(@PathVariable("bookmarkId") final long bookmarkId) {
		ResponseEntity<?> responseEntity;
		try {
			bookmarkComponet.deleteBookmark(bookmarkId);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<String>("movie deleted successfully", HttpStatus.OK);
		return responseEntity;
	}
	


	

	@PostMapping("/createPlaylist")
	public ResponseEntity<?> createPlaylist(@RequestBody final Playlist playlist, HttpServletRequest req,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		try {
			HttpServletRequest request = (HttpServletRequest)req;
			String authHeader = request.getHeader("authorization");
			String token = authHeader.substring(7);
			String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
			System.out.println("User Id Value******"+userId);
			playlistComponent.createPlayList(playlist,userId);
			responseEntity = new ResponseEntity<Playlist>(playlist, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	

	@PostMapping("/updatePlaylist")
	public ResponseEntity<?> updatePlaylist(@RequestBody final Playlist playlist, HttpServletRequest req,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		try {
			System.out.println("playlist.getPlaylistId():"+playlist.getPlaylistId());
			HttpServletRequest request = (HttpServletRequest)req;
			String authHeader = request.getHeader("authorization");
			String token = authHeader.substring(7);
			String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
			System.out.println("User Id Value******"+userId);
			playlistComponent.update(playlist,userId);
			responseEntity = new ResponseEntity<Playlist>(playlist, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	

	
	@DeleteMapping(value ="/muzix/deletePlaylist/{playlistId}/{muzixId}")
	public ResponseEntity<?> createPlaylist(@PathVariable("playlistId")final long playlistId,@PathVariable("muzixId") final long muzixId, HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		try {
			playlistComponent.deletePlaylist(playlistId,muzixId);
			responseEntity = new ResponseEntity<Long>(playlistId, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@GetMapping(path = "/suggested")
	public ResponseEntity<?> searchByUserId(HttpServletRequest req,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		SearchHistory searchHistory = null;
		try {
			HttpServletRequest request = (HttpServletRequest)req;
			String authHeader = request.getHeader("authorization");
			String token = authHeader.substring(7);
			String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
			System.out.println("User Id Value******"+userId);
			
			searchHistory = searchHistoryComponent.getLastSearchHistory(userId);
			System.out.println("####################");
			System.out.println(searchHistory);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<SearchHistory>(searchHistory, HttpStatus.OK);
		return responseEntity;
	} 

	@PostMapping("/saveSearchHistory")
	public ResponseEntity<?> saveSearchHistory(@RequestBody final SearchHistory searchHistory, HttpServletRequest req,
			HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		try {
			System.out.println("##########################");
			HttpServletRequest request = (HttpServletRequest)req;
			String authHeader = request.getHeader("authorization");
			String token = authHeader.substring(7);
			String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
			System.out.println("User Id Value******"+userId);
			searchHistoryComponent.saveSearchHistory(searchHistory,userId);
			responseEntity = new ResponseEntity<SearchHistory>(searchHistory, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	
}
