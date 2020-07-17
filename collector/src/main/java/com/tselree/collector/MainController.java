package com.tselree.collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tselree.collector.DAO.CollectDAO;
import com.tselree.collector.DAO.OmniformDAO;
import com.tselree.collector.model.*;
@Controller
@RequestMapping(path="/collector")
public class MainController {
	@Autowired
	@Qualifier("sql1")
	private CollectDAO collectDAO;
	@Autowired
	@Qualifier("sql2")
	private OmniformDAO omniformDAO;
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	@GetMapping(path="/test")
	public @ResponseBody String test() {
		return "works!";
	}
	@PostMapping(path="/collect")
	@ResponseBody
	public void collect(@RequestBody OmniformID[] arrOmniformID){
		log.info("Getting Omniform ID Total "+arrOmniformID.length+" Omniform");
		for(OmniformID omniform : arrOmniformID) {
			if(omniformDAO.checkOmniform(omniform.getId()) == omniform.getId()) {
				log.info(omniform.getId());
				
				String omniformPayload = collectDAO.getOmniform(omniform.getId());
				omniformDAO.updOmniform(omniform.getId(), omniformPayload);
				
			}else {
				log.info(omniform.getId());
				
				String omniformPayload = collectDAO.getOmniform(omniform.getId());
				omniformDAO.addOmniform(omniform.getId(), omniformPayload);
				
			}
		}
		
	}
}
