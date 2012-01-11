package org.cnpc.system.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PHONE")
public class Fax extends ContactMechanism {
	private static final long serialVersionUID = 1L;
	
	@Column
	private String faxNumber;

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	
	

}
