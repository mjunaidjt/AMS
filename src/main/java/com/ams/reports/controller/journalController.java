package com.ams.reports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ams.reports.model.Journal;
import com.ams.reports.repository.journalRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/journal")
public class journalController {

	@Autowired
	private journalRepository journalrepository;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getActive() throws JsonProcessingException {
		
		ObjectMapper objmap=new ObjectMapper();
		List<Journal> journal=journalrepository.findActive();
		
		return objmap.writeValueAsString(journal);
	}
	
	@RequestMapping(value ="/all" , method=RequestMethod.GET)
	public String getAll() throws JsonProcessingException {
		
		ObjectMapper objmap=new ObjectMapper();
		List<Journal> journal=journalrepository.findAll();
		
		return objmap.writeValueAsString(journal);
	}
	
	@RequestMapping(value ="/{id}" , method=RequestMethod.GET)
	public String  getOne(@PathVariable long LEDGER_ID) {
		return null;
		
	}
	
	public void insert() {
		
	}
	 
    public void update() {
		
	}
    
    @RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public void delete(@PathVariable long LEDGER_ID) {
		
	}
	
	
}
