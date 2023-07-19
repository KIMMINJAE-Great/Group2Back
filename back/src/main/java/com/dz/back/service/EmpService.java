package com.dz.back.service;

import org.springframework.stereotype.Service;

import com.dz.back.dto.EmpDTO;

public interface EmpService {

	EmpDTO getEmp (String id);
	void register(EmpDTO empDTO);
	void logout();
}
