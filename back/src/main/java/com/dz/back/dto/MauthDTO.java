package com.dz.back.dto;

public class MauthDTO {
	private String menucd;
    private String mgroupcd;
    private String url;
    private String menunm;
    private String mgroupnm;
    
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
