package com.dz.back.acd.acd1000.acd1010.mapper;

import java.util.List;

import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;



public interface ACD1010Mapper {


	List<CarDTO> getCarList();
	

	CarDTO getRegcarCard(String car_cd);


	int addRegCar(CarDTO dto);


	int updateRegCar(CarDTO dto);


	void deleteRegCar(String car_cd);
	
}
