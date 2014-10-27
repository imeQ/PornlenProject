package com.pornlen.service;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	

	public void putMessage(Severity messageType, String message) {
		FacesMessage fm = new FacesMessage(messageType, "", message);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public void putMessage(String message) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "", message);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public void putMessageI18n(String tag){
		//TODO
	}
}
