package com.indivara.micro.common.dto;

import java.util.Date;

public class GenericResponse {

	private Date date;
	private String message;
	private Object data;
	private Boolean failure;
	private String path;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Boolean getFailure() {
		return failure;
	}
	public void setFailure(Boolean failure) {
		this.failure = failure;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public GenericResponse(Date date, String message, Object data, Boolean failure, String path) {
		this.date = date;
		this.message = message;
		this.data = data;
		this.failure = failure;
		this.path = path;
	}
	
}
