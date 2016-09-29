package com.indivara.micro.serviceweb.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indivara.micro.common.dto.GenericResponse;
import com.indivara.micro.core.service.UserService;
import com.indivara.micro.serviceweb.common.CommonController;

@RequestMapping("/")
@RestController
public class UserController extends CommonController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "findall", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(HttpServletRequest request) {
		return getMessage(new Date(), "Exist", userService.findAll(), Boolean.FALSE, request.getRequestURI());
	}

	@RequestMapping(value = "findbyusername", method = RequestMethod.GET)
	public @ResponseBody GenericResponse isExist(@RequestParam String username, HttpServletRequest request) {
		return getMessage(new Date(), "Exist", userService.findByUserName(username), Boolean.FALSE,
				request.getRequestURI());
	}
}
