package com.dz.back.ace.ace1000.ace1010.dto;

public class UseFgDTO {

	private String d_id;
	private String d_nm;
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getD_nm() {
		return d_nm;
	}
	public void setD_nm(String d_nm) {
		this.d_nm = d_nm;
	}
	
	@Override
	public String toString() {
		return "Usefg [d_id=" + d_id + ", d_nm=" + d_nm + "]";
	}
	
}
