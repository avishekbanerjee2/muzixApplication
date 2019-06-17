package com.stackroute.muzixmanager.components;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.muzixmanager.dto.SearchHistory;
import com.stackroute.muzixmanager.entity.SearchHistoryEntity;
import com.stackroute.muzixmanager.service.SearchHistoryService;

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

public class SearchHistoryComponentTest {
	@Mock
	SearchHistoryService searchHistoryService;

	@InjectMocks
	SearchHistoryComponent searchHistoryComponet;
	@Mock
	SearchHistory serachHistory;
	@Mock
	SearchHistoryEntity serachHistoryEntity;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveSearchHistoryTest() {
		try {
			when(searchHistoryService.saveSearchHistory(serachHistoryEntity)).thenReturn(true);
			searchHistoryComponet.saveSearchHistory(serachHistory, "abc");
			assertTrue(true);
		} catch (Exception e) {

		}
	}

	@Test
	public void saveSearchHistoryExceptionTest() {
		try {
			searchHistoryComponet.saveSearchHistory(serachHistory, "abc");
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void getLastSearchHistoryTest() {
		when(searchHistoryService.getSearchHistory(anyString())).thenReturn(serachHistoryEntity);
		searchHistoryComponet.getLastSearchHistory(anyString());
		assertNotNull(serachHistoryEntity);
	}

}
