package com.dz.back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dz.back.dto.EmpDTO;

public interface EmpService {

	EmpDTO getEmp (String id);
	int register(EmpDTO empDTO);
	void logout();
	List<EmpDTO> readCardList();
	String searchEmpCd(String cocd);
	EmpDTO validEmpCd(String empcd);
	void rolseSetUser(String empid);
}
