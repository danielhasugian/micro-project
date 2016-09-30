package com.indivara.micro.servicecore.message;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.repository.RepositoryDefinition;
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

//@RequestMapping("/")
@RestController
@RequestMapping("/")
public class UserMessage {

	@Autowired
	private UserService userService;
	@Autowired
	private JmsTemplate restTemplate;
	
	
	@RequestMapping(value = "findall", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(HttpServletRequest request) {
		GenericMessage gm = new GenericMessage();
		gm.setBody(userService.findAll());
		//send
		restTemplate.convertAndSend("DEMO-JMS-QUEUE", gm);
		GenericResponse gr = new GenericResponse(null, null, gm, null, null);
		return gr;
	}

	@RequestMapping(value = "/findbyusername", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(@RequestParam String username, HttpServletRequest request) {
		GenericMessage gm = new GenericMessage();
		gm.setBody(userService.findByUserName(username));
		
		restTemplate.convertAndSend("DEMO-JMS-QUEUE", gm);
		GenericResponse gr = new GenericResponse(null, null, userService.findByUserName(username), null, null);
		return gr;
	}
	
}
