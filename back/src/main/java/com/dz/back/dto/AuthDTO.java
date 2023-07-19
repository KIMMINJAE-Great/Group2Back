package com.dz.back.dto;

import lombok.Getter;
import lombok.Setter;


public class AuthDTO {
	private String co_cd;
	
	private String emp_id;
	private String auth;
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getCo_cd() {
		return co_cd;
	}
	public void setCo_cd(String co_cd) {
		this.co_cd = co_cd;
	}
}
