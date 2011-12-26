package com.cdi.producer;

public class CoderPImpl implements CoderP {

	@Override
	public String codeString(String s, int tval) {
		return CoderPImpl.class.toString();
	}

}
