package com.cdi.event;

import java.io.Serializable;
import java.util.logging.Level;

import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

public class PaymentHandler implements Serializable {
	
	private Logger logger = Logger.getLogger(PaymentHandler.class.toString());

	private static final long serialVersionUID = 1L;

	public void creditPayment(@Observes @Credit PaymentEvent event) {
		logger.info("PaymentHandler - Credit Handler: {0}" + "  " +
				event.toString());
		// call a specific Credit handler class...
	}

	public void debitPayment(@Observes @Debit PaymentEvent event) {
		logger.info("PaymentHandler - Debit Handler: {0}" + "  " +
				event.toString());
		// call a specific Debit handler class...
	}
}
