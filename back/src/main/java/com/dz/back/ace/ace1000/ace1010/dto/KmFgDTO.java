package com.dz.back.ace.ace1000.ace1010.dto;

public class KmFgDTO {
	private int km;
	private String fg;
	@Override
	public String toString() {
		return "KmFgDTO [km=" + km + ", fg=" + fg + "]";
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public String getFg() {
		return fg;
	}
	public void setFg(String fg) {
		this.fg = fg;
	}
}
