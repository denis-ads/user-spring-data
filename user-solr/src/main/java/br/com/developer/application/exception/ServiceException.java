package br.com.developer.application.exception;

import br.com.developer.domain.model.ResponseDefault;

public class ServiceException extends Exception{

	private ResponseDefault responseDefault;
	
    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(ResponseDefault responseDefault) {
		this.responseDefault = responseDefault;
	}

	private static final long serialVersionUID = -4610574559439037462L;

	public ResponseDefault getResponseDefault() {
		return responseDefault;
	}

	public void setResponseDefault(ResponseDefault responseDefault) {
		this.responseDefault = responseDefault;
	}
	
}
