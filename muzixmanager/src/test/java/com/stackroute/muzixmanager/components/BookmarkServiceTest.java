/**
 * 
 */
package com.stackroute.muzixmanager.components;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.repository.BookmarkRepository;
import com.stackroute.muzixmanager.service.BookmarkService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.mockito.Mockito.anyLong;
/**
 * @author ubuntu
 *
 */
public class BookmarkServiceTest {
	
	@InjectMocks
	BookmarkService bookmarkService;
	@Mock
	BookmarkRepository bookmarkRepository;
	@Mock
	BookmarkEntity bookmarkEntity;
	@Mock
	Exception exception;
	
	

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void  createBookMarkTest() {
		boolean isBookmarkCreated=true;
		try {
			when(bookmarkService.createBookMark(bookmarkEntity)).thenReturn(isBookmarkCreated);
			assertEquals(true, isBookmarkCreated);
		} catch (Exception e) {
			assertTrue(false);
		}
		
	}
	@Test
	public void  createBookMarkExceptionTest() {
		try {
		when(bookmarkService.createBookMark(bookmarkEntity)).thenThrow(exception);
		assertTrue(false);
		}catch(Exception e) {
			assertTrue("Exception expected", true);
		}
		
	}
	
	
	
	@Test
	public void  deleteBookmarkTest() {
		try {
			boolean abc=bookmarkService.deleteBookmark(1L);
		} catch (Exception e) {
			assertTrue(false);
		}
		
	}
	@Test
	public void  deleteBookmarkExceptionTest() {
		try {
		when(bookmarkService.createBookMark(bookmarkEntity)).thenThrow(exception);
		assertTrue(false);
		}catch(Exception e) {
			assertTrue("Exception expected", true);
		}
		
	}

}
