package com.indivara.micro.serviceweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.indivara.micro.common.dto.GenericMessage;
import com.indivara.micro.common.dto.GenericResponse;
import com.indivara.micro.core.service.UserService;
import com.indivara.micro.serviceweb.common.CommonController;

@RequestMapping("/")
@RestController
public class UserController extends CommonController {

	@Autowired
	private UserService userService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Bean
	  RestTemplate restTemplate(){
	    return new RestTemplate();
	  }
	
	@RequestMapping(value = "findall", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(HttpServletRequest request) {
		restTemplate.getForObject("http://localhost:3000/findall", GenericMessage.class);
				
		GenericMessage msg =(GenericMessage)jmsTemplate.receiveAndConvert("DEMO-JMS-QUEUE");
		return getMessage(new Date(), "Exist", msg, Boolean.FALSE, request.getRequestURI());
	}

	@RequestMapping(value = "findbyusername", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(@RequestParam String username, HttpServletRequest request) {
		restTemplate.getForObject("http://localhost:3000/findbyusername?username="+username+"", GenericMessage.class);
		
		GenericMessage msg =(GenericMessage)jmsTemplate.receiveAndConvert("DEMO-JMS-QUEUE");
		
		return getMessage(new Date(), "Exist", msg, Boolean.FALSE,
				request.getRequestURI());
	}
}
