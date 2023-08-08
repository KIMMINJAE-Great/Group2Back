package com.dz.back.ace.ace1000.ace1010.dto;

public class SendYnDTO {
	private String s_id;
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_nm() {
		return s_nm;
	}
	public void setS_nm(String s_nm) {
		this.s_nm = s_nm;
	}
	private String s_nm;
	@Override
	public String toString() {
		return "SendFgDTO [s_id=" + s_id + ", s_nm=" + s_nm + "]";
	}
	
}
