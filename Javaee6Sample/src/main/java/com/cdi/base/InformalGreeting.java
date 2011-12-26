package com.cdi.base;

@Informal
public class InformalGreeting extends Greeting {
	public String greet(String name) {
		return "Hi, " + name;
	}
}
