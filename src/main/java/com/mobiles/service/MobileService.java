package com.mobiles.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.MobileDao;
import com.mobiles.entity.Mobile;
import com.mobiles.exception.NameNotFoundException;

@Service
public class MobileService {
	private static Logger log=Logger.getLogger(MobileService.class);
	@Autowired
	MobileDao md;

	public String postData(Mobile mb) {
		PropertyConfigurator.configure("logs.properties");
		log.info(mb);
		String mm= md.postData(mb);
		log.info(mm);
		return mm;
		
	}
	public String postList( List<Mobile> mbl) {
		return md.postList(mbl);	
	}
	public List<Mobile> findAllmbl() {
		return md.findAllmbl();
	}
	public Mobile findIdVal(int id) {
		return md.findIdVal(id);
	}
	public String delValId(int ids) {
		return md.delValId(ids);
	}
	public String updateVal( Mobile mb) {
		return md.updateVal(mb);
	}
	public List<Mobile> getObjects(String name) throws NameNotFoundException {
		List<Mobile> lms=md.findAllmbl().stream().filter(x->x.getBrand().equals(name)).collect(Collectors.toList());
		if(lms.isEmpty()) {
			throw new NameNotFoundException("custom/ Brand name not found");
		}
		else {		
			return lms;
		}
	}
}
