package com.dz.back.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class EmpDTO {
	private String co_cd;
	private String emp_cd;
	private String emp_nm;
	private String emp_id;// emp_id
	private String password;
	private String dept_cd;
	private List<AuthDTO> authList;
	private List<MauthDTO> mauthList;
	private String gender;
	private String app_password;
	private String emp_lang;
	private String emp_email1;
	private String emp_email2;
	private String emp_semail1;
	private String emp_semail2;
	private String emp_mobile;
	private String emp_hphone;
	private String emp_add;
	private String emp_hrd;
	private String emp_resi;
	private String emp_post;
	
	public String getCo_cd() {
		return co_cd;
	}
	public void setCo_cd(String co_cd) {
		this.co_cd = co_cd;
	}
	public String getEmp_cd() {
		return emp_cd;
	}
	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}
	public String getEmp_nm() {
		return emp_nm;
	}
	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public List<AuthDTO> getAuthList() {
		return authList;
	}
	public void setAuthList(List<AuthDTO> authList) {
		this.authList = authList;
	}
	public List<MauthDTO> getMauthList() {
		return mauthList;
	}
	public void setMauthList(List<MauthDTO> mauthList) {
		this.mauthList = mauthList;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getApp_password() {
		return app_password;
	}
	public void setApp_password(String app_password) {
		this.app_password = app_password;
	}
	public String getEmp_lang() {
		return emp_lang;
	}
	public void setEmp_lang(String emp_lang) {
		this.emp_lang = emp_lang;
	}
	
	public String getEmp_mobile() {
		return emp_mobile;
	}
	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}
	public String getEmp_hphone() {
		return emp_hphone;
	}
	public void setEmp_hphone(String emp_hphone) {
		this.emp_hphone = emp_hphone;
	}
	public String getEmp_add() {
		return emp_add;
	}
	public void setEmp_add(String emp_add) {
		this.emp_add = emp_add;
	}
	public String getEmp_hrd() {
		return emp_hrd;
	}
	public void setEmp_hrd(String emp_hrd) {
		this.emp_hrd = emp_hrd;
	}
	public String getEmp_resi() {
		return emp_resi;
	}
	public void setEmp_resi(String emp_resi) {
		this.emp_resi = emp_resi;
	}
	public String getEmp_post() {
		return emp_post;
	}
	public void setEmp_post(String emp_post) {
		this.emp_post = emp_post;
	}
	public String getEmp_email1() {
		return emp_email1;
	}
	public void setEmp_email1(String emp_email1) {
		this.emp_email1 = emp_email1;
	}
	public String getEmp_email2() {
		return emp_email2;
	}
	public void setEmp_email2(String emp_email2) {
		this.emp_email2 = emp_email2;
	}
	public String getEmp_semail1() {
		return emp_semail1;
	}
	public void setEmp_semail1(String emp_semail1) {
		this.emp_semail1 = emp_semail1;
	}
	public String getEmp_semail2() {
		return emp_semail2;
	}
	public void setEmp_semail2(String emp_semail2) {
		this.emp_semail2 = emp_semail2;
	}
	@Override
	public String toString() {
		return "EmpDTO [co_cd=" + co_cd + ", emp_cd=" + emp_cd + ", emp_nm=" + emp_nm + ", emp_id=" + emp_id
				+ ", password=" + password + ", dept_cd=" + dept_cd + ", authList=" + authList + ", mauthList="
				+ mauthList + ", gender=" + gender + ", app_password=" + app_password + ", emp_lang=" + emp_lang
				+ ", emp_email1=" + emp_email1 + ", emp_email2=" + emp_email2 + ", emp_semail1=" + emp_semail1
				+ ", emp_semail2=" + emp_semail2 + ", emp_mobile=" + emp_mobile + ", emp_hphone=" + emp_hphone
				+ ", emp_add=" + emp_add + ", emp_hrd=" + emp_hrd + ", emp_resi=" + emp_resi + ", emp_post=" + emp_post
				+ "]";
	}
	
	


	

	
	
	
}
