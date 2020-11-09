package com.sowjanya;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

public class Response {
	private String message;
	private boolean status;
	
	
	
	public Response() {
		
	}

	public Response(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
	

}
