package com.richfaces.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean {
	
	private String name;

	public String getName() {
		//System.out.println("name............."+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
