package com.codejstudio.service.dto;


/**
 * User映射类
 * 
 * @author codejstudio
 * @2016年11月18日
 */
public class UserDTO extends BaseDTO {
	private String u_mobile;
	private String u_password;
	private String u_username;

	public String getU_mobile() {
		return u_mobile;
	}

	public void setU_mobile(String u_mobile) {
		this.u_mobile = u_mobile;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_username() {
		return u_username;
	}

	public void setU_username(String u_username) {
		this.u_username = u_username;
	}

}