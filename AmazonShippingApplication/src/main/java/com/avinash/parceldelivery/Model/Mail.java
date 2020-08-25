package com.avinash.parceldelivery.Model;

import java.util.List;

public class Mail {
	private String subject;
	private String body;
	private List<String> recipient;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<String> getRecipient() {
		return recipient;
	}
	public void setRecipient(List<String> recipient) {
		this.recipient = recipient;
	}
	
}
