package org.cnpc.system.util;

import java.io.UnsupportedEncodingException;

import javax.ejb.Stateless;

@Stateless
public class ContactUtil {
	
	public String encodeMessage(String message){
		try {
			return new String(message.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Encode Wrong";
	}
}
