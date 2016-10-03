package com.indivara.micro.common.dto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import biz.source_code.base64Coder.Base64Coder;

public class GenericMessage implements Serializable {

	private static final long serialVersionUID = 9081473490146535359L;
	private Date date;
	private String header;
	private String data;
	private String queue;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setDataObject(Serializable data) {
		try {
			this.data = toB64String(data);
		} catch (IOException e) {
			this.data = "";
		}
	}
	
	public Object getDataObject() {
		try {
			return fromB64String(this.data);
		} catch (Exception e) {
			return null;
		}
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public GenericMessage(Date date, String header, String data, String queue) {
		this.date = date;
		this.header = header;
		this.data = data;
		this.queue = queue;
	}

	public GenericMessage() {
	}

	private static Object fromB64String(String s) throws IOException, ClassNotFoundException {
		byte[] data = Base64Coder.decode(s);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		Object o = ois.readObject();
		ois.close();
		return o;
	}

	private static String toB64String(Serializable o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.close();
		return new String(Base64Coder.encode(baos.toByteArray()));
	}

}
