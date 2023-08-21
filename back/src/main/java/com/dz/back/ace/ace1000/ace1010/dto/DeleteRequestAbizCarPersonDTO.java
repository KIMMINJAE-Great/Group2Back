package com.dz.back.ace.ace1000.ace1010.dto;

public class DeleteRequestAbizCarPersonDTO {
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

	@Override
	public String toString() {
		return "DeleteRequestAbizCarPersonDTO [car_cd=" + car_cd + ", seq_nb=" + seq_nb + "]";
	}

}
