package com.dz.back.ace.ace1000.ace1010.dto;

public class AutoCalcMileageDTO {
	private int seq_nb;
	private String car_cd;
	private int mileage_km;
	public int getSeq_nb() {
		return seq_nb;
	}
	public void setSeq_nb(int seq_nb) {
		this.seq_nb = seq_nb;
	}
	public String getCar_cd() {
		return car_cd;
	}
	public void setCar_cd(String car_cd) {
		this.car_cd = car_cd;
	}
	public int getMileage_km() {
		return mileage_km;
	}
	public void setMileage_km(int mileage_km) {
		this.mileage_km = mileage_km;
	}
	@Override
	public String toString() {
		return "AutoCalcMileageDTO [seq_nb=" + seq_nb + ", car_cd=" + car_cd + ", mileage_km=" + mileage_km + "]";
	}
	
}
