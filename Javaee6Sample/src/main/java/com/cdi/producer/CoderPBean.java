package com.cdi.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Named
@ApplicationScoped
public class CoderPBean {
	private String inputString;
	private String codedString;
	private final static int TEST = 1;
	private final static int SHIFT = 2;
	private int coderType = TEST;

	public int getCoderType() {
		return coderType;
	}

	public void setCoderType(int coderType) {
		this.coderType = coderType;
	}

	@Max(26)
	@Min(0)
	@NotNull
	private int transVal;
	
	@Inject
	@Chosen
	CoderP coder;

	@Produces
	@Chosen
	public CoderP getCoder(@New TestCoderPImpl tci, @New CoderPImpl ci) {
		switch (coderType) {
		case TEST:
			return tci;
		case SHIFT:
			return ci;
		default:
			return null;
		}
	}

	public void encodeString() {
		setCodedString(coder.codeString(inputString, transVal));
	}

	public void reset() {
		setInputString("");
		setTransVal(0);
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public String getCodedString() {
		return codedString;
	}

	public void setCodedString(String codedString) {
		this.codedString = codedString;
	}

	public int getTransVal() {
		return transVal;
	}

	public void setTransVal(int transVal) {
		this.transVal = transVal;
	}
}
