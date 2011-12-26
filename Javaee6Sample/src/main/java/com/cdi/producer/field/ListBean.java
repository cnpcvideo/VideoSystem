package com.cdi.producer.field;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named
@ConversationScoped
public class ListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1738367350709117810L;
	@EJB
	private RequestBean request;
	@NotNull
	private String inputString;
	private ToDo toDo;
	private List<ToDo> toDos;


	public RequestBean getRequest() {
		return request;
	}

	public void setRequest(RequestBean request) {
		this.request = request;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public List<ToDo> getToDos() {
		return request.getToDos();
	}

	public void setToDos(List<ToDo> toDos) {
		this.toDos = toDos;
	}

	
	public void createTask() {
		this.setToDo(request.createToDo(inputString));
	}

	public ToDo getToDo() {
		return toDo;
	}

	public void setToDo(ToDo toDo) {
		this.toDo = toDo;
	}

}
