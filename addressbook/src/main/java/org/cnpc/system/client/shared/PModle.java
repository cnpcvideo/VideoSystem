package org.cnpc.system.client.shared;

import java.io.Serializable;

public class PModle implements Serializable{

	private static final long serialVersionUID = 1L;

	private String string1;
	private String string2;
	
	public String getString1() {
		return string1;
	}
	public void setString1(String string1) {
		this.string1 = string1;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	
	
}
