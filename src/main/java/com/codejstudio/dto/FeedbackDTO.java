package com.codejstudio.dto;

import java.util.Date;

public class FeedbackDTO {
	private Integer  f_id;
	private String   f_title;  
    private String   f_content;  
    private String   f_pic;
    private Integer  u_id;
    private Date   create_tme;
    private Date   modify_tme;
    public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getF_title() {
		return f_title;
	}
	public void setF_title(String f_title) {
		this.f_title = f_title;
	}
	public String getF_content() {
		return f_content;
	}
	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	public String getF_pic() {
		return f_pic;
	}
	public void setF_pic(String f_pic) {
		this.f_pic = f_pic;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public Date getCreate_tme() {
		return create_tme;
	}
	public void setCreate_tme(Date create_tme) {
		this.create_tme = create_tme;
	}
	public Date getModify_tme() {
		return modify_tme;
	}
	public void setModify_tme(Date modify_tme) {
		this.modify_tme = modify_tme;
	}
	
	

}
