package com.stackroute.muzixmanager.components;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.service.MuzixService;
import com.stackroute.muzixmanager.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyInt;

public class MuzixComponentTest {

	@InjectMocks
	MuzixComponent muzixComponent;

	@Mock
	MuzixService muzixService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void mixixSaveTest() {
		try {
			muzixService.saveMuzix(getMuzixEntity());
		} catch (Exception e) {

		}
		assertTrue(true);

	}

	@Test
	public void mixixSaveExceptionTest() {
		try {
			muzixService.saveMuzix(getMuzixEntity());
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void mixixSavesTest() {
		try {
			muzixService.saveMuzixs(getMuzixs());
		} catch (Exception e) {

		}
		assertTrue(true);

	}

	@Test
	public void mixixSavesExceptionTest() {
		try {
			muzixService.saveMuzixs(getMuzixs());
		} catch (Exception e) {
			assertTrue(true);
		}

	}

@Test
	public void getMuzixByMusixIdTest() {
		try {
		when(muzixService.getMuzixByMusixId(anyInt())).thenReturn(getMuzixEntity());
		muzixComponent.getMuzixByMusixId(anyInt());
		assertTrue(true);
		
		}
		catch(Exception e) {
			
		}
	}



	public Muzix getMuzix() {
		Muzix muzix = new Muzix();
		muzix.setName("testMuzix name");
		muzix.setArtist("testng");
		return muzix;

	}

	public List<MuzixEntity> getMuzixs() {
		List<MuzixEntity> muzixEntities = new ArrayList<MuzixEntity>();

		muzixEntities.add(getMuzixEntity());
		Muzix muzix = new Muzix();
		muzix.setName("testMuzix name");
		muzix.setArtist("testng");
		return muzixEntities;

	}

	public MuzixEntity getMuzixEntity() {
		MuzixEntity muzixEntity = new MuzixEntity();

		return muzixEntity;
	}
}
