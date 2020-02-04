package com.scp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scp.beans.Address;

@Controller
public class AddressController {

	private AddressRestAPI restService = new AddressRestAPI();
	
	/*
	 * @RequestMapping(value = "/home",method = RequestMethod.GET)
	public ModelAndView empReg() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("empbn",new Emp());
		model.put("employees",service.getAllEmps());
		return new ModelAndView("employee",model);
	}
	 */
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView allAddresses() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("addressBean",new Address());
		//this calls our rest controller and it calls the bank service controller
		model.put("addressList", restService.getAllAddress());
		return new ModelAndView("address",model);
	}
	
	@RequestMapping(value="/address/{addressId}",method=RequestMethod.GET)
	public ModelAndView getSingleAddresses(@PathVariable("addressId") int addressId) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("addressBean",new Address());
		model.put("address", restService.getSingleAddress(addressId));
		return new ModelAndView("address",model);
	
	}
}
