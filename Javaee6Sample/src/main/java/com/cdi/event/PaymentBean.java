package com.cdi.event;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Digits;
import java.io.Serializable;

@Named
@SessionScoped
public class PaymentBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	@Credit
	Event<PaymentEvent> creditEvent;

	@Inject
	@Debit
	Event<PaymentEvent> debitEvent;

	public static final int DEBIT = 1;
	public static final int CREDIT = 2;

	private int paymentOption = DEBIT;

	public int getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(int paymentOption) {
		this.paymentOption = paymentOption;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@Digits(integer = 10, fraction = 2, message = "Invalid value")
	private BigDecimal value;
	private Date datetime;

	@Logged
	public String pay() {
		this.setDatetime(Calendar.getInstance().getTime());
		switch (paymentOption) {
		case DEBIT:
			PaymentEvent debitPayload = new PaymentEvent();
			debitPayload.setPaymentType("Debit");
			debitPayload.setValue(value);
			debitPayload.setDatetime(datetime);
			debitEvent.fire(debitPayload);
			break;
		case CREDIT:
			PaymentEvent creditPayload = new PaymentEvent();
			creditPayload.setPaymentType("Credit");
			creditPayload.setValue(value);
			creditPayload.setDatetime(datetime);
			creditEvent.fire(creditPayload);
			break;
		default:
			System.err.println("Invalid payment option!");
		}
		return "/response.xhtml";
	}

	@Logged
	public void reset() {
		setPaymentOption(DEBIT);
		setValue(BigDecimal.ZERO);
	}
}
