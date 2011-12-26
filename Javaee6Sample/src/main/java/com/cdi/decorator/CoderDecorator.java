package com.cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import com.cdi.alternative.Coder;

@Decorator
public abstract class CoderDecorator implements Coder {
	@Inject
	@Delegate
	@Any
	Coder coder;

	public String codeString(String s, int tval) {
		int len = s.length();
		return "In decorator and " + coder.codeString(s, tval);
	}
}
