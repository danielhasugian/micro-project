package com.indivara.micro.servicecore.message;

import java.io.Serializable;
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

import com.indivara.micro.common.dto.GenericMessage;
import com.indivara.micro.common.dto.GenericResponse;
import com.indivara.micro.core.service.UserService;

@RestController
@RequestMapping("/")
public class UserMessage {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${micropayment.queue}")
	private String queue;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "findall", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(HttpServletRequest request) {
		GenericMessage gm = new GenericMessage(new Date(), "send JMS", "", queue);
		gm.setDataObject((Serializable) userService.findAll());

		jmsTemplate.convertAndSend(queue, gm);
		GenericResponse gr = new GenericResponse(null, null, gm, null, null);
		return gr;
	}

	/**
	 * 
	 * @param username
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "findbyusername", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(@RequestParam String username, HttpServletRequest request) {
		GenericMessage gm = new GenericMessage();
		gm.setDataObject((Serializable) userService.findByUserName(username));
		
		jmsTemplate.convertAndSend(queue, gm);
		GenericResponse gr = new GenericResponse(null, null, userService.findByUserName(username), null, null);
		return gr;
	}
	
}
