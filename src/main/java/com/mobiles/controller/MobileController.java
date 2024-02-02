package com.mobiles.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobiles.entity.Mobile;
import com.mobiles.exception.NameNotFoundException;
import com.mobiles.repository.MobileRepository;
import com.mobiles.service.MobileService;

@RestController
public class MobileController {
	private static Logger log = Logger.getLogger(MobileController.class);//loger import check every time
	@Autowired
	MobileService ms;

	@Autowired
	MobileRepository mr;
	
	@PostMapping(path = "/mob")
	
	public String postData(@RequestBody Mobile m) {
		PropertyConfigurator.configure("logs.properties");
		log.info(m);
		
		 String mb=ms.postData(m);
		 log.info(mb);
		 return mb;
		
	}
	//normally
	//if we want to show log returnd obj we want to use above
//	public String postData(@RequestBody Mobile m) {
//		PropertyConfigurator.configure("logs.properties");
//		log.info(m);
//		return ms.postData(m);
//		
//	}

	@PostMapping(path = "/lsmob")
	public String postList(@RequestBody List<Mobile> mls) {
		return ms.postList(mls);
	}

	@GetMapping(value = "getall")
	public List<Mobile> findAllmbl() {
		return ms.findAllmbl();
	}

	@GetMapping(path = "getid/{id}")
	public Mobile findIdVal(@PathVariable int id) {
		return ms.findIdVal(id);
	}

	@DeleteMapping(path = "delId/{id}")
	public String delValId(@PathVariable int id) {
		return ms.delValId(id);
	}

	@PutMapping(path = "/update")
	public String updateVal(@RequestBody Mobile mb) {
		return ms.updateVal(mb);
	}
	@GetMapping(path="/getObject/{name}")
	public List<Mobile> getObjects(@PathVariable String name) throws NameNotFoundException {
		return ms.getObjects(name);
	}
	//////////////jpa query//////////////
	@GetMapping("/getAllQuery")
	public List<Mobile> getALlQuery(){
		return mr.getAllQuery();
	}
	
	@GetMapping(value="gets/{a}/{b}")
	public List<Object> gets(@PathVariable  int a, @PathVariable int b){
		return mr.gets(a, b);
	}
	
}
