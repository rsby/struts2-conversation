package com.google.code.struts2.scope.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Form;
import com.opensymphony.xwork2.util.ValueStack;

public class ConversationForm extends Form {

	public ConversationForm(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}
	
	@Override
	protected String getDefaultTemplate() {
		return "conversation-form-close";
	}
}
