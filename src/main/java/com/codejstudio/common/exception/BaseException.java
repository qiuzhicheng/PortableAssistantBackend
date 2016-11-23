package com.codejstudio.common.exception;

public class BaseException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 991041123773838070L;
	protected int code;
	
	public BaseException(){}
	
	public BaseException(int code) {
		super();
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
