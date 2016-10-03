package com.indivara.micro.serviceweb.common;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.indivara.micro.common.dto.GenericResponse;

public class CommonController {
	
	final static Logger LOGGER = Logger.getLogger(CommonController.class);
	
	@Value("${client.host}")
	protected String clientHost;
	
	
	protected GenericResponse genericResponse;
	
	public GenericResponse getMessage(String message, Object object, String path){
		return getMessageTemplate(new Date(), message, object, Boolean.FALSE, path);
	}
	
	public GenericResponse getMessage(Date date, String message, Object object, Boolean status, String path){
		return getMessageTemplate(date, message, object, status, path);
	}
	
	private GenericResponse getMessageTemplate(Date date, String message, Object object, Boolean status, String path){
		genericResponse = new GenericResponse(date, message, object, status, path);
		return genericResponse;
	}
}
