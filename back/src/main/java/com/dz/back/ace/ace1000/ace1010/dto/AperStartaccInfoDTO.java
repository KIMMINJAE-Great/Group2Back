package com.dz.back.ace.ace1000.ace1010.dto;

public class AperStartaccInfoDTO {
	private String co_cd;
	private String car_cd;
	private String startacc_km;
	private String insert_id;
	private String insert_ip;
	private String insert_dt;
	private String modify_id;
	private String modify_ip;
	private String modify_dt;
	
	public String getCo_cd() {
		return co_cd;
	}
	public void setCo_cd(String co_cd) {
		this.co_cd = co_cd;
	}
	public String getCar_cd() {
		return car_cd;
	}
	public void setCar_cd(String car_cd) {
		this.car_cd = car_cd;
	}
	public String getStartacc_km() {
		return startacc_km;
	}
	public void setStartacc_km(String startacc_km) {
		this.startacc_km = startacc_km;
	}
	public String getInsert_id() {
		return insert_id;
	}
	public void setInsert_id(String insert_id) {
		this.insert_id = insert_id;
	}
	public String getInsert_ip() {
		return insert_ip;
	}
	public void setInsert_ip(String insert_ip) {
		this.insert_ip = insert_ip;
	}
	public String getInsert_dt() {
		return insert_dt;
	}
	public void setInsert_dt(String insert_dt) {
		this.insert_dt = insert_dt;
	}
	public String getModify_id() {
		return modify_id;
	}
	public void setModify_id(String modify_id) {
		this.modify_id = modify_id;
	}
	public String getModify_ip() {
		return modify_ip;
	}
	public void setModify_ip(String modify_ip) {
		this.modify_ip = modify_ip;
	}
	public String getModify_dt() {
		return modify_dt;
	}
	public void setModify_dt(String modify_dt) {
		this.modify_dt = modify_dt;
	}
	
	@Override
	public String toString() {
		return "AperStartaccInfoDTO [co_cd=" + co_cd + ", car_cd=" + car_cd + ", startacc_km=" + startacc_km
				+ ", insert_id=" + insert_id + ", insert_ip=" + insert_ip + ", insert_dt=" + insert_dt + ", modify_id="
				+ modify_id + ", modify_ip=" + modify_ip + ", modify_dt=" + modify_dt + "]";
	}
}
