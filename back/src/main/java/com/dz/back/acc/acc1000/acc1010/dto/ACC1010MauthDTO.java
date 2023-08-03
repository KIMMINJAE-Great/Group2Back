package com.dz.back.acc.acc1000.acc1010.dto;

public class ACC1010MauthDTO {
	@Override
	public String toString() {
		return "MauthDTO [menucd=" + menucd + ", mgroupcd=" + mgroupcd + ", url=" + url + ", menunm=" + menunm
				+ ", mgroupnm=" + mgroupnm + ", cocd=" + cocd + ", empcd=" + empcd + ", insertid=" + insertid
				+ ", insertip=" + insertip + ", insertdt=" + insertdt + "]";
	}
	private String menucd;
    private String mgroupcd;
    private String url;
    private String menunm;
    private String mgroupnm;
    private String cocd;
    private String empcd;
    private String insertid;
    private String insertip;
    private String insertdt;
    public String getCocd() {
		return cocd;
	}
	public void setCocd(String cocd) {
		this.cocd = cocd;
	}
	public String getEmpcd() {
		return empcd;
	}
	public void setEmpcd(String empcd) {
		this.empcd = empcd;
	}
	public String getInsertid() {
		return insertid;
	}
	public void setInsertid(String insertid) {
		this.insertid = insertid;
	}
	public String getInsertip() {
		return insertip;
	}
	public void setInsertip(String insertip) {
		this.insertip = insertip;
	}
	public String getInsertdt() {
		return insertdt;
	}
	public void setInsertdt(String insertdt) {
		this.insertdt = insertdt;
	}
	
	public String getMgroupnm() {
		return mgroupnm;
	}
	public void setMgroupnm(String mgroupnm) {
		this.mgroupnm = mgroupnm;
	}
	public String getMenucd() {
		return menucd;
	}
	public void setMenucd(String menucd) {
		this.menucd = menucd;
	}
	public String getMgroupcd() {
		return mgroupcd;
	}
	public void setMgroupcd(String mgroupcd) {
		this.mgroupcd = mgroupcd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMenunm() {
		return menunm;
	}
	public void setMenunm(String menunm) {
		this.menunm = menunm;
	}
    

}
