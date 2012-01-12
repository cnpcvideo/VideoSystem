package org.cnpc.system.client.shared;

import java.io.Serializable;

import org.jboss.errai.bus.server.annotations.ExposeEntity;

@ExposeEntity
public class PersonVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String secondName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

}
