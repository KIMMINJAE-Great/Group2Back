package com.dz.back.acc.acc1000.acc1010.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.dto.ACC1010MauthDTO;

public interface ACC1010Service {

	int register(ACC1010EmpDTO empDTO);
	void logout();
	List<ACC1010EmpDTO> readCardList();
	String searchEmpCd(String cocd);
	ACC1010EmpDTO validEmpCd(String empcd);
	void rolesSetUser(String empid);
	int updateEmp(ACC1010EmpDTO empDTO);
	ACC1010EmpDTO getEmpCard(String emp_cd);
	void deleteEmp(String emp_cd);
	void deleteAuth(String emp_id);
	List<ACC1010EmpDTO> empSearch(ACC1010EmpDTO empSearch);
	List<ACC1010MauthDTO> getMauth (String emp_cd);
	int insertMauth (ACC1010MauthDTO dto);
	void deleteMauth(ACC1010MauthDTO dto);
	int checkEmpId(String emp_id);
}
