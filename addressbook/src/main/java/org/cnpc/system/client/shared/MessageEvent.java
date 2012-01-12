package org.cnpc.system.client.shared;

import java.io.Serializable;

import org.jboss.errai.bus.server.annotations.ExposeEntity;

/**
 * Generated.
 */
@ExposeEntity
public class MessageEvent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String message;

    private String firstName;
    private String secondName;
    private String birthDate;
    private String gentle;
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGentle() {
		return gentle;
	}

	public void setGentle(String gentle) {
		this.gentle = gentle;
	}

	public MessageEvent() {
    }

    public MessageEvent(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}