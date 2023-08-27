package com.dz.back.ace.ace1000.ace1010.dto;

public class DeleteRequestAbizCarPersonDTO {
	private String co_cd;
	
	private String car_cd;
	private int seq_nb;

	public String getCar_cd() {
		return car_cd;
	}

	public void setCar_cd(String car_cd) {
		this.car_cd = car_cd;
	}

	public int getSeq_nb() {
		return seq_nb;
	}

	public void setSeq_nb(int seq_nb) {
		this.seq_nb = seq_nb;
	}
	public String getCo_cd() {
		return co_cd;
	}

	public void setCo_cd(String co_cd) {
		this.co_cd = co_cd;
	}

	@Override
	public String toString() {
		return "DeleteRequestAbizCarPersonDTO [co_cd=" + co_cd + ", car_cd=" + car_cd + ", seq_nb=" + seq_nb + "]";
	}

	
}
