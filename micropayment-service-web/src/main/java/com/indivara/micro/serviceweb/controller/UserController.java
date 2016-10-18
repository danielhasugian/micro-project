package com.indivara.micro.serviceweb.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.indivara.micro.common.dto.GenericMessage;
import com.indivara.micro.common.dto.GenericResponse;
import com.indivara.micro.serviceweb.common.CommonController;

@RequestMapping("/")
@RestController
public class UserController extends CommonController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${micropayment.queue}")
	private String queue;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(HttpServletRequest request) {
		restTemplate.getForObject(clientHost+"/findall", GenericMessage.class);
		Object object = jmsTemplate.receiveAndConvert(queue);
		GenericMessage msg = (GenericMessage) object;
		return getMessage(new Date(), "Exist", msg.getDataObject(), Boolean.FALSE, request.getRequestURI());
	}

	@RequestMapping(value = "findbyusername", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(@RequestParam String username, HttpServletRequest request) {
		restTemplate.getForObject(clientHost+"/findbyusername?username="+username+"", GenericMessage.class);
		GenericMessage msg =(GenericMessage)jmsTemplate.receiveAndConvert(queue);
		return getMessage(new Date(), "Exist", msg, Boolean.FALSE,
				request.getRequestURI());
	}
}
