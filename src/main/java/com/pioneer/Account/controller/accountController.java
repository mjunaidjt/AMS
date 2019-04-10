package com.pioneer.Account.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pioneer.Account.model.Account;
import com.pioneer.Account.repository.accountRepository;

@RestController
@RequestMapping(value = "/account")


public class accountController {
	
	@Autowired
	private accountRepository accountrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getActive() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<Account> account = accountrepository.findActive();
		return mapper.writeValueAsString(account);
	}
	@RequestMapping(value ="/all",method = RequestMethod.GET)
	public String getAll() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<Account> account = accountrepository.findAll();
		return mapper.writeValueAsString(account);
	}
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public String getBySearch(@RequestBody String data) throws JsonProcessingException {
		return getSearch(data,true);
	}
	@RequestMapping(value ="/search/all",method = RequestMethod.GET)
	public String get(@RequestBody String data) throws JsonProcessingException {
		return getSearch(data,false);
	}
	//Requires testing and repository  function
	/*
	@RequestMapping(value ="/search/all",method = RequestMethod.GET)
	public String getByKey(@RequestBody String data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JSONObject object = new JSONObject(data);
		if (!object.has("search")) {
			return "Search string is missing!";
		}
		long accounttype_ID=0;
		if (object.has("accounttype_ID"))
			accounttype_ID=object.getLong("accounttype_ID");
		List<Account> account=accountrepository.findByAdvancedSearch(accounttype_ID);
		return mapper.writeValueAsString(account);

	}
	*/
	public String getSearch(String data,boolean active) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JSONObject object = new JSONObject(data);
		if (!object.has("search")) {
			return "Search string is missing!";
		}
		
		List<Account> account= ((active==true) ? accountrepository.findBySearch(object.getString("search")):accountrepository.findAllBySearch(object.getString("search")));
		return mapper.writeValueAsString(account);
	}

	@RequestMapping(value="/advancedsearch",method = RequestMethod.GET)
	public String getByAdvancedSearch(@RequestBody String data) throws JsonProcessingException {
		return getAdvancedSearch(data,true);
	}
	
	@RequestMapping(value="/advancedsearch/all",method = RequestMethod.GET)
	public String getAllByAdvancedSearch(@RequestBody String data) throws JsonProcessingException {
		return getAdvancedSearch(data,false);
	}
	public String getAdvancedSearch(String data,boolean active) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JSONObject object = new JSONObject(data);
		long accounttype_ID=0;
		if (object.has("accounttype_ID"))
			accounttype_ID=object.getLong("accounttype_ID");
		
		List<Account> account=((active==true) ? accountrepository.findByAdvancedSearch(accounttype_ID):accountrepository.findAllByAdvancedSearch(accounttype_ID));
			return mapper.writeValueAsString(account);
	}
	@SuppressAjWarnings("static-access")
	@RequestMapping(method = RequestMethod.POST)
	public String insert(@RequestBody String data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
		Date date = new Date();
		Account account = new Account();
		
		JSONObject object = new JSONObject(data);
		
		if (!object.has("account_TITLE")) {
			return "Name of the account Missing!";
		}
		
		account.setACCOUNT_TITLE(object.getString("account_TITLE"));
		account.setACCOUNT_DESCRIPTION(object.getString("account_DESCRIPTION"));
		account.setACCOUNT_CREDITBALANCE(object.getDouble("account_CREDITBALANCE"));
		account.setACCOUNT_DEBITBALANCE(object.getDouble("account_DEBITBALANCE"));
		account.setACCOUNT_ADDED(dateFormat.format(date));
		account.setISACTIVE(object.getString("isactive"));
		account.setACCOUNTTYPE_ID(object.getInt("accounttype_ID"));
		account.setMODIFIED_BY(object.getString("modified_BY"));
		account.setMODIFIED_WHEN(dateFormat.format(date));

		account = accountrepository.saveAndFlush(account);
		return mapper.writeValueAsString(account);
	}

	@SuppressAjWarnings("static-access")
	@RequestMapping(value ="/{id}",method = RequestMethod.PUT)
	public String update(@RequestBody String data,@PathVariable Long id) throws JsonProcessingException {
		ObjectMapper mapper= new ObjectMapper();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
		Date date = new Date();
		Account account = accountrepository.findOne(id);
		JSONObject object=new JSONObject(data);
		if(!object.has("account_TITLE"))
			account.setACCOUNT_TITLE(object.getString("account_TITLE"));
		if(!object.has("account_DESCRIPTION"))
			account.setACCOUNT_DESCRIPTION(object.getString("account_DESCRIPTION"));
		if(!object.has("account_CREDITBALANCE"))
			account.setACCOUNT_CREDITBALANCE(object.getDouble("account_CREDITBALANCE"));
		if(!object.has("account_DEBITBALANCE"))
			account.setACCOUNT_DEBITBALANCE(object.getDouble("account_DEBITBALANCE"));
			account.setMODIFIED_WHEN(dateFormat.format(date));
		if(!object.has("isactive"))
				account.setISACTIVE(object.getString("isactive"));
		if(!object.has("accounttype_ID"))	
			account.setACCOUNTTYPE_ID(object.getInt("accounttype_ID"));
		account = accountrepository.saveAndFlush(account);
		return mapper.writeValueAsString(account);
	}

	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		Account account = accountrepository.findOne(id);
		if(account!=null)
		accountrepository.delete(id);
		else
			return "Could not find given ID"; 
		return "Record has been deleted";
	}
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public String getOne(@PathVariable Long id) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		Account account = accountrepository.findOne(id);

		return mapper.writeValueAsString(account);
	}
}
