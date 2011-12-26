package com.cdi.base;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class Generator implements Serializable{
//
//	@Inject @MaxNumber int maxNumber;
//	
//	@Inject @Random Instance<Integer> random;
	private static final long serialVersionUID = -6785337732812330925L;
	private int maxNumber = 100;

	@Produces
	@MaxNumber
	int getMaxNumber() {
		return maxNumber;
	}

	private java.util.Random random = new java.util.Random(
			System.currentTimeMillis());

	java.util.Random getRandom() {
		return random;
	}

	@Produces
	@Random
	int next() {
		return getRandom().nextInt(maxNumber);
	}
	
}
