package com.ams.transaction.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ams.transaction.model.TransactionVoucher;
import com.ams.transaction.repository.transactionVoucherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/transactionvoucher")
public class transactionVoucherController{

	
	@Autowired
	private transactionVoucherRepository transactionvoucherrepository;
	
	//  get active...............
	// tested..................
	@RequestMapping(method=RequestMethod.GET)
	public String getActive() throws JsonProcessingException{
		
		ObjectMapper objmapper=new ObjectMapper();
		List<TransactionVoucher> transactionvoucher=transactionvoucherrepository.findActive();
		
		return objmapper.writeValueAsString(transactionvoucher);
	}
	
	// get all.................
	//tested..................
	@RequestMapping(value= "/all" , method=RequestMethod.GET)
	public String getAll() throws JsonProcessingException{
		
		ObjectMapper objmapper=new ObjectMapper();
		List<TransactionVoucher> transactionvoucher=transactionvoucherrepository.findAll();
		
		return objmapper.writeValueAsString(transactionvoucher);
	
}
	
	//get one by id
	//tested..............
	@RequestMapping(value="/{id}", method=RequestMethod.GET)  
	public String getOne(@PathVariable Long id) throws JsonProcessingException {
		ObjectMapper objmapper =new ObjectMapper();
		TransactionVoucher transactionvoucher=transactionvoucherrepository.findOne(id);
		
		return objmapper.writeValueAsString(transactionvoucher);
		
	}
	
	
	/// get search method for getBySearch and getAllBySearch.................
	public String getSearch(String data,Boolean active ) throws JsonProcessingException {
		
		ObjectMapper objmapper=new ObjectMapper();
    	JSONObject object=new JSONObject(data);
		
		
		  if(!(object.has("search"))) { return "Search is Missing !"; }
		
		List<TransactionVoucher> transactionvoucher=(
				(active==true)?
				transactionvoucherrepository.findBySearch(object.getString("search")):
		        transactionvoucherrepository.findAllBySearch(object.getString("search"))
		        );
		        
		        return objmapper.writeValueAsString(transactionvoucher);
	}
	
	// getBySearch...................
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String getBySearch(@RequestBody String search) throws JsonProcessingException {
		
		return getSearch(search,true);
		
	}
	
	
	// getAllBySearch...................
	
	@RequestMapping(value= "/search/all" , method=RequestMethod.GET)
	public String getAllBySearch(@RequestBody String search) throws JsonProcessingException {
		
		return getSearch(search,false);
		
	}
	
	// get search method for getByAdvancedSearch and getAllByAdvancedSearch.................
	// tested................
	public String getAdvancedSearch(String data,Boolean active) throws JsonProcessingException {
		
		ObjectMapper objmapper=new ObjectMapper();
		JSONObject object = new JSONObject(data);
		long TRANSACTION_ID=0;
		
		if(object.has("TRANSACTION_ID")) {
			TRANSACTION_ID=object.getLong("TRANSACTION_ID");
		}
		List<TransactionVoucher> transactionvoucher=((active==true)?
				transactionvoucherrepository.findByAdvancedSearch(TRANSACTION_ID):
				transactionvoucherrepository.findAllByAdvancedSearch(TRANSACTION_ID));
		return objmapper.writeValueAsString(transactionvoucher);
		
	}
	
	// get by aadvanced search.....
	// tested................
	@RequestMapping(value= "/advancedsearch" ,method=RequestMethod.GET)
	public String getByAdvancedSearch(@RequestBody String data) throws JsonProcessingException {
		
		return getAdvancedSearch(data,true);
		
	}
	
	// get all by advance search.....................
	// tested................
	@RequestMapping(value ="/advancedsearch/all" , method=RequestMethod.GET)
	public String getAllByAdvanceSearch(@RequestBody String data) throws JsonProcessingException {
		
		return getAdvancedSearch(data,false);
		
	}
	
	// post method...................
	//  tested.................
	@SuppressWarnings("static-Access")
	@RequestMapping(method=RequestMethod.POST)
	public String Insert(@RequestBody String data) throws JsonProcessingException {
		
		ObjectMapper Objmapper=new ObjectMapper();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY HH.mm.ss");
		Date date=new Date();
		
		TransactionVoucher transactionvoucher=new TransactionVoucher();
		
		JSONObject object=new JSONObject(data);
		
		
		if(!(object.has("TRANSACTION_DESCRIPTION"))){
			return "Transaction Description is Missing !";
		}		
		if(!(object.has("TRANSACTION_DESCRIPTION"))){
			return "Transaction Description is Missing !";
		}
		
		transactionvoucher.setTRANSACTION_DATE(object.getString("TRANSACTION_DATE"));
		transactionvoucher.setTRANSACTION_DESCRIPTION(object.getString("TRANSACTION_DESCRIPTION"));
		transactionvoucher.setISACTIVE("Y");
		transactionvoucher.setMODIFIED_BY((long)0);
		transactionvoucher.setMODIFIED_WHEN(dateFormat.format(date));
		transactionvoucher.setMODIFIED_WORKSTATION("Local");
		
		transactionvoucher=transactionvoucherrepository.saveAndFlush(transactionvoucher);
		
		return Objmapper.writeValueAsString(transactionvoucher);
	}
	
	// put method....................
    //  tested ..............
	//@SuppressWarnings("static-access")
	@RequestMapping(value="/{id}" , method=RequestMethod.PUT)
	public String update(@PathVariable  long id , @RequestBody String data) throws JsonProcessingException {
		
		ObjectMapper objmapper =new ObjectMapper();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY HH.mm.ss");
		Date date=new Date();
		
		JSONObject object=new JSONObject(data);
		
		TransactionVoucher transactionvoucher=transactionvoucherrepository.findOne(id);
		if(object.has("TRANSACTION_DATE")) {
			transactionvoucher.setTRANSACTION_DATE(object.getString("TRANSACTION_DATE"));
		}
		if(object.has("TRANSACTION_DESCRIPTION")) {
			transactionvoucher.setTRANSACTION_DESCRIPTION(object.getString("TRANSACTION_DESCRIPTION"));
		}
		if(object.has("ISACTIVE")) {
			transactionvoucher.setISACTIVE(object.getString("ISACTIVE"));
		}

		transactionvoucher.setMODIFIED_BY((long)0);
		transactionvoucher.setMODIFIED_WHEN(dateFormat.format(date));
		transactionvoucher.setMODIFIED_WORKSTATION("Local");
		
		transactionvoucher=transactionvoucherrepository.saveAndFlush(transactionvoucher);
		
		 
		return objmapper.writeValueAsString(transactionvoucher)  ;
		
	}
	
	//delete method ...............
	// tested...................
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public String delete(@PathVariable Long id ) {
		
		TransactionVoucher transactionvoucher=transactionvoucherrepository.findOne(id); 
		
		transactionvoucherrepository.delete(transactionvoucher);
		
		return "The Record has been Deleted Successfully ! ";
	}	
	
	
}
	
	
	
