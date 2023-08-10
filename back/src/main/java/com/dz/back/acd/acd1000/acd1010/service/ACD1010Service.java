package com.dz.back.acd.acd1000.acd1010.service;

import java.util.List;

import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;

public interface ACD1010Service {
	
	List<CarDTO> getCardCarList();
	
	CarDTO getRegcarCard(String car_cd);
	
	int addRegCar(CarDTO dto);
	
	int updateRegCar(CarDTO dto);
	
	void deleteRegCar(String car_cd);
	
	List<CarDTO> carSearch(CarDTO carSearch);
	
	

}
