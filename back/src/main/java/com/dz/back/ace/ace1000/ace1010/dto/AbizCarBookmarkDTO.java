package com.dz.back.ace.ace1000.ace1010.dto;

public class AbizCarBookmarkDTO {
	
	private String co_cd;
	private String emp_cd;
	private String bookmark_cd;
	private String bookmark_nm;
	private String use_fg;
	private String start_time;
	private String end_time;
	private String start_fg;
	private String start_addr;
	private String end_fg;
	private String end_addr;
	private int mileage_km;
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
	public String getBookmark_cd() {
		return bookmark_cd;
	}
	public void setBookmark_cd(String bookmark_cd) {
		this.bookmark_cd = bookmark_cd;
	}
	public String getBookmark_nm() {
		return bookmark_nm;
	}
	public void setBookmark_nm(String bookmark_nm) {
		this.bookmark_nm = bookmark_nm;
	}
	public String getUse_fg() {
		return use_fg;
	}
	public void setUse_fg(String use_fg) {
		this.use_fg = use_fg;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStart_fg() {
		return start_fg;
	}
	public void setStart_fg(String start_fg) {
		this.start_fg = start_fg;
	}
	public String getStart_addr() {
		return start_addr;
	}
	public void setStart_addr(String start_addr) {
		this.start_addr = start_addr;
	}
	public String getEnd_fg() {
		return end_fg;
	}
	public void setEnd_fg(String end_fg) {
		this.end_fg = end_fg;
	}
	public String getEnd_addr() {
		return end_addr;
	}
	public void setEnd_addr(String end_addr) {
		this.end_addr = end_addr;
	}
	public int getMileage_km() {
		return mileage_km;
	}
	public void setMileage_km(int mileage_km) {
		this.mileage_km = mileage_km;
	}
	@Override
	public String toString() {
		return "AbizCarBookmarkDTO [co_cd=" + co_cd + ", emp_cd=" + emp_cd + ", bookmark_cd=" + bookmark_cd
				+ ", bookmark_nm=" + bookmark_nm + ", use_fg=" + use_fg + ", start_time=" + start_time + ", end_time="
				+ end_time + ", start_fg=" + start_fg + ", start_addr=" + start_addr + ", end_fg=" + end_fg
				+ ", end_addr=" + end_addr + ", mileage_km=" + mileage_km + "]";
	}

}
