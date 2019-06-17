package com.stackroute.muzixmanager.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.service.MuzixService;

@Component
public class MuzixComponent {
	
	@Autowired
	MuzixService muzixService;
	
	
public void saveMuzix(Muzix muzix) {
	try {
		
		MuzixEntity muzixEntity=new MuzixEntity();
		muzixEntity.setArtist(muzix.getArtist());
		muzixEntity.setImageUrl(muzix.getImageUrl());
		muzixEntity.setMbid(muzix.getMbid());
		muzixEntity.setMuzixId(muzix.getMuzixId());
		muzixEntity.setName(muzix.getName());
		muzixEntity.setUrl(muzix.getUrl());
		
		muzixService.saveMuzix(muzixEntity);
	}catch(Exception e) {
		e.printStackTrace();
		throw e;
	}	
}

public void saveMuzixs(List<Muzix> muzixs) {
	try {
		List<MuzixEntity> muzixEntitys=new ArrayList<MuzixEntity>();
		for (Muzix muzix : muzixs) {
			MuzixEntity muzixEntity=new MuzixEntity();
			muzixEntity.setArtist(muzix.getArtist());
			muzixEntity.setImageUrl(muzix.getImageUrl());
			muzixEntity.setMbid(muzix.getMbid());
			muzixEntity.setMuzixId(muzix.getMuzixId());
			muzixEntity.setName(muzix.getName());
			muzixEntity.setUrl(muzix.getUrl());
			muzixEntitys.add(muzixEntity);
		}
		muzixService.saveMuzixs(muzixEntitys);
	}catch(Exception e) {
		e.printStackTrace();
		throw e;
	}	
}

	public Muzix getMuzixByMusixId(int muzixId) {
		try {
			MuzixEntity muzixEntity=muzixService.getMuzixByMusixId(muzixId);
			Muzix muzix=new Muzix();
			muzix.setArtist(muzixEntity.getArtist());
			muzix.setImageUrl(muzixEntity.getImageUrl());
			muzix.setMbid(muzixEntity.getMbid());
			muzix.setMuzixId(muzixEntity.getMuzixId());
			muzix.setName(muzixEntity.getName());
			muzix.setUrl(muzixEntity.getUrl());
			return muzix;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	
	
	
}
	
	
	

}

