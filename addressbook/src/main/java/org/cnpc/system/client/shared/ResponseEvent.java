package org.cnpc.system.client.shared;

import java.io.Serializable;
import java.util.ArrayList;

import org.jboss.errai.bus.server.annotations.ExposeEntity;

import antlr.collections.List;

/**
 * Generated.
 */
@ExposeEntity
public class ResponseEvent implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private int id;
    private String message;
    private ArrayList<PModle> pmodleList;

    public ResponseEvent() {
    }

    public ResponseEvent(String message) {
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

	public ArrayList<PModle> getPmodleList() {
		return pmodleList;
	}

	public void setPmodleList(ArrayList<PModle> pmodleList) {
		this.pmodleList = pmodleList;
	}
    
    
}