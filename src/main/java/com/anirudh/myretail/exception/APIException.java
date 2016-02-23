package com.anirudh.myretail.exception;

public class APIException extends RuntimeException {
	
	public APIException(Throwable cause){
		super(cause);
	}
	
	public APIException(String message){
		super(message);
	}
	
	public APIException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public APIException(){
		super();
	}

}
