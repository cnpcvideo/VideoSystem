package com.cdi.producer;

public class TestCoderPImpl implements CoderP{

	@Override
	public String codeString(String s, int tval) {
		return TestCoderPImpl.class.toString();
	}

}
