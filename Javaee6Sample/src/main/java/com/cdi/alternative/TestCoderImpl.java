package com.cdi.alternative;

import javax.enterprise.inject.Alternative;

@Alternative
public class TestCoderImpl implements Coder {

	@Override
	public String codeString(String s, int tval) {
		return ("TestCoderImpl");
	}

}
