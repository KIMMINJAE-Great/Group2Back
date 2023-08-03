package com.dz.back.acd.acd1000.acd1010.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.acd.acd1000.acd1010.dao.ACD1010DAO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;


@Service
public class ACD1010ServiceImpl {
	
	@Autowired
	ACD1010DAO carRegDAO;
	
	
	public List<CarDTO> getAllCarRegInfo() {		
		return carRegDAO.getAllCarRegInfo();
	}
}
