package com.mobiles.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobiles.entity.Mobile;
import com.mobiles.repository.MobileRepository;
import com.mobiles.service.MobileService;

@Repository
public class MobileDao {
	private static Logger log=Logger.getLogger(MobileDao.class);
	@Autowired
	MobileRepository mr;

	public String postData(Mobile mc) {
		PropertyConfigurator.configure("logs.properties");
		log.info(mc);
	Mobile mrs=	mr.save(mc);
		 log.info(mrs);
		 return "saved";
	}
	public String postList(List<Mobile> mcl) {
		mr.saveAll(mcl);
		return "All data saved";
	}
	public List<Mobile> findAllmbl() {
		//mr.saveAll();
		return mr.findAll(); 
	}
	public Mobile findIdVal(int id) {
		return mr.findById(id).get();
	}
	public String delValId(int ids) {
		mr.deleteById(ids);
		return "deleted succesfully";
	}
	public String updateVal( Mobile mb) {
		 mr.save(mb);
		 return "updated successfully";
	}

}
