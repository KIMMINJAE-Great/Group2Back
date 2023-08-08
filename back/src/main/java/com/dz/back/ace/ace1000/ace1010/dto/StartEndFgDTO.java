package com.dz.back.ace.ace1000.ace1010.dto;

public class StartEndFgDTO {
	private String p_id;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_nm() {
		return p_nm;
	}
	public void setP_nm(String p_nm) {
		this.p_nm = p_nm;
	}
	@Override
	public String toString() {
		return "StartEndFgDTO [p_id=" + p_id + ", p_nm=" + p_nm + "]";
	}
	private String p_nm;
}
