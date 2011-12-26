package com.cdi.base;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Printer {
	@Inject Greeting greeting;
//	@Inject @Informal Greeting greeting;
	
	private String name;
	private String salutation;
	
	public void createSalutation() {
		this.salutation = greeting.greet(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
}
