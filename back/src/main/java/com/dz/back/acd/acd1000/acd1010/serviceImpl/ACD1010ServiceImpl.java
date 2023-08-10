package com.dz.back.acd.acd1000.acd1010.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.acd.acd1000.acd1010.dao.ACD1010DAO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;


@Service
public class ACD1010ServiceImpl {
	
	@Autowired
	ACD1010DAO regcarDAO;
	
	
	public List<CarDTO> getCardCarList() {		
		return regcarDAO.getCarList();
	}
	
	public CarDTO getRegcarCard(String car_cd) {
		return regcarDAO.getRegcarCard(car_cd);
	}
	
	public int addRegCar(CarDTO dto) {
		return regcarDAO.addRegCar(dto);
	}

	public int updateRegCar(CarDTO dto) {
		
		return regcarDAO.updateRegCar(dto);
	}

	public void deleteRegCar(String car_cd) {
		
		regcarDAO.deleteRegCar(car_cd);
		
	}

	public List<CarDTO> carSearch(CarDTO carSearch) {
		
		return regcarDAO.carSearch(carSearch);
	}
}
