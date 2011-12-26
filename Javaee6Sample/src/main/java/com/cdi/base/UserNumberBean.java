package com.cdi.base;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UserNumberBean implements Serializable {

	private static final long serialVersionUID = 3930137039193526762L;
	private int number;
	private Integer userNumber;
	private int minimum;
	private int remainingGuesses;

	@Inject
	@MaxNumber
	private int maxNumber;

	private int maxnimum;

	@Inject
	@Random
	private Instance<Integer> randomInt;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getMaxnimum() {
		return maxnimum;
	}

	public void setMaxnimum(int maxnimum) {
		this.maxnimum = maxnimum;
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getRemainingGuesses() {
		return remainingGuesses;
	}

	public void setRemainingGuesses(int remainingGuesses) {
		this.remainingGuesses = remainingGuesses;
	}

	@PostConstruct
	public void reset() {
		this.minimum = 0;
		this.userNumber = 0;
		this.maxnimum = maxNumber;
		this.remainingGuesses = 10;
		this.number = randomInt.get();
	}

	public String check() throws InterruptedException {
		if (userNumber > number) {
			this.maxnimum = userNumber - 1;
		}
		if (userNumber < number) {
			this.minimum = userNumber + 1;
		}
		if (userNumber == number) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Correct!"));
		}
		remainingGuesses--;

		return null;
	}

	public void validateNumberRange(FacesContext context,
			UIComponent toValidate, Object value) {
		if (this.remainingGuesses <= 0) {
			FacesMessage message = new FacesMessage("No guesses left");
			context.addMessage(toValidate.getClientId(context), message);
			((UIInput) toValidate).setValid(false);
			return;
		}
		int input = (Integer) value;
		
		if (input < this.minimum || input > this.maxnimum) {
			((UIInput) toValidate).setValid(false);
			FacesMessage message = new FacesMessage("Invalid guess");
			context.addMessage(toValidate.getClientId(context), message);
			
		}
	}

}
