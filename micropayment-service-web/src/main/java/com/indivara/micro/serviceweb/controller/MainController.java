package com.indivara.micro.serviceweb.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indivara.micro.common.dto.GenericResponse;
import com.indivara.micro.serviceweb.common.CommonController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
public class MainController extends CommonController {

	@RequestMapping(value = "isexist", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(HttpServletRequest request){
		return getMessage("Exist", null, request.getRequestURI());
	}
	
	@HystrixCommand(fallbackMethod = "senderror")
	@RequestMapping(value = "fallbackmethod", method = RequestMethod.GET)
	public @ResponseBody GenericResponse fallbackMethod(HttpServletRequest request){
		return getMessage("Exist", null, request.getRequestURI());
	}
	
	public @ResponseBody GenericResponse senderror(){
		return getMessage(new Date(), "Opp sorry", null, Boolean.TRUE, "");
	}
}
