package com.dz.back.acd.acd1000.acd1010.dto;

import java.time.LocalDateTime;

public class CarDTO {
	private String co_cd;
	private String emp_cd;
	private String car_cd;
	private String car_nb;
	private String car_nm;
	private String get_dt;
	private String disposal_dt;
	private String lease_yn;
	private String lfr_dt;
	private String lto_dt;
	private String insur_tr_cd;
	private String ifr_dt;
	private String ito_dt;
	private String use_yn;
	public String getCo_cd() {
		return co_cd;
	}
	
	
	
	@Override
	public String toString() {
		return "CarDTO [co_cd=" + co_cd + ", emp_cd=" + emp_cd + ", car_cd=" + car_cd + ", car_nb=" + car_nb
				+ ", car_nm=" + car_nm + ", get_dt=" + get_dt + ", disposal_dt=" + disposal_dt + ", lease_yn="
				+ lease_yn + ", lfr_dt=" + lfr_dt + ", lto_dt=" + lto_dt + ", insur_tr_cd=" + insur_tr_cd + ", ifr_dt="
				+ ifr_dt + ", ito_dt=" + ito_dt + ", use_yn=" + use_yn + "]";
	}



	public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
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
	public String getCar_nb() {
		return car_nb;
	}
	public void setCar_nb(String car_nb) {
		this.car_nb = car_nb;
	}
	public String getCar_nm() {
		return car_nm;
	}
	public void setCar_nm(String car_nm) {
		this.car_nm = car_nm;
	}
	public String getGet_dt() {
		return get_dt;
	}
	public void setGet_dt(String get_dt) {
		this.get_dt = get_dt;
	}
	public String getDisposal_dt() {
		return disposal_dt;
	}
	public void setDisposal_dt(String disposal_dt) {
		this.disposal_dt = disposal_dt;
	}
	public String getLease_yn() {
		return lease_yn;
	}
	public void setLease_yn(String lease_yn) {
		this.lease_yn = lease_yn;
	}
	public String getLfr_dt() {
		return lfr_dt;
	}
	public void setLfr_dt(String lfr_dt) {
		this.lfr_dt = lfr_dt;
	}
	public String getLto_dt() {
		return lto_dt;
	}
	public void setLto_dt(String lto_dt) {
		this.lto_dt = lto_dt;
	}
	public String getInsur_tr_cd() {
		return insur_tr_cd;
	}
	public void setInsur_tr_cd(String insur_tr_cd) {
		this.insur_tr_cd = insur_tr_cd;
	}
	public String getIfr_dt() {
		return ifr_dt;
	}
	public void setIfr_dt(String ifr_dt) {
		this.ifr_dt = ifr_dt;
	}
	public String getIto_dt() {
		return ito_dt;
	}
	public void setIto_dt(String ito_dt) {
		this.ito_dt = ito_dt;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public void setAbizcarNBNM(String abizcarNBNM) {
		// TODO Auto-generated method stub
		
	}
	

}

