package com.dz.back.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class EmpDTO {
	private String co_cd;
	private String emp_cd;
	private String emp_nm;
	private String emp_id;// emp_id
	private String password;
	private String biz_nm;
	private String dept_cd;
	private List<AuthDTO> authList;
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
	public String getBiz_nm() {
		return biz_nm;
	}
	public void setBiz_num(String biz_nm) {
		this.biz_nm = biz_nm;
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
	@Override
	public String toString() {
		return "EmpDTO [co_cd=" + co_cd + ", emp_cd=" + emp_cd + ", emp_nm=" + emp_nm + ", emp_id=" + emp_id
				+ ", password=" + password + ", biz_nm=" + biz_nm + ", dept_cd=" + dept_cd + ", authList=" + authList
				+ "]";
	}
	
	
}
