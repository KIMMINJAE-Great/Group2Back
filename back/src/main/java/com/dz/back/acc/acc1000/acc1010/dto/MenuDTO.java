package com.dz.back.acc.acc1000.acc1010.dto;

public class MenuDTO {
	private String co_cd;
	private String menu_cd;
	private String menu_nm;
	private String mgroup_nm;
	private String url;
	private String mgroup_cd;

	@Override
	public String toString() {
		return "MenuDTO [co_cd=" + co_cd + ", menu_cd=" + menu_cd + ", menu_nm=" + menu_nm + ", mgroup_nm=" + mgroup_nm
				+ ", url=" + url + ", mgroup_cd=" + mgroup_cd + "]";
	}

	public String getCo_cd() {
		return co_cd;
	}

	public void setCo_cd(String co_cd) {
		this.co_cd = co_cd;
	}

	public String getMenu_cd() {
		return menu_cd;
	}

	public void setMenu_cd(String menu_cd) {
		this.menu_cd = menu_cd;
	}

	public String getMenu_nm() {
		return menu_nm;
	}

	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}

	public String getMgroup_nm() {
		return mgroup_nm;
	}

	public void setMgroup_nm(String mgroup_nm) {
		this.mgroup_nm = mgroup_nm;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMgroup_cd() {
		return mgroup_cd;
	}

	public void setMgroup_cd(String mgroup_cd) {
		this.mgroup_cd = mgroup_cd;
	}
}
