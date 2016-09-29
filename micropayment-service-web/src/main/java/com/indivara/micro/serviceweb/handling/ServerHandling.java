package com.indivara.micro.serviceweb.handling;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerHandling {

	/**
	 * Method exception IllegalArgumentException, NullPointerException, NumberFormatException
	 * @param HttpServletResponse response
	 * @throws IOException
	 */
	@ExceptionHandler({IllegalArgumentException.class, NullPointerException.class, NumberFormatException.class})
	public void handleBaseException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}
