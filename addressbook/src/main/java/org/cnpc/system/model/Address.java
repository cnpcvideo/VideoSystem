package org.cnpc.system.model;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.cnpc.system.model.ContactMechanism;


@Entity
@DiscriminatorValue(value="PHONE")
public class Address extends ContactMechanism {
	private static final long serialVersionUID = 1L;
	
	@Column
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
