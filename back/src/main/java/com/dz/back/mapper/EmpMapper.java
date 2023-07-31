package com.dz.back.mapper;

import java.util.List;

import com.dz.back.dto.AuthDTO;
import com.dz.back.dto.EmpDTO;
import com.dz.back.dto.MauthDTO;

public interface EmpMapper {
	void login();
	int register(EmpDTO empDTO);
	EmpDTO getEmpByUsername(String username);
	public EmpDTO read(String username);
	List<MauthDTO> readMauthList(String emp_cd);
	List<EmpDTO> readCardList();
	String searchEmpCd(String cocd);
	EmpDTO validEmpCd(String empcd);
	void rolseSetUser(String empid);
	int updateEmp(EmpDTO empDTO);
	EmpDTO getEmpCard(String emp_cd);
	void deleteEmp(String emp_cd);
	void deleteAuth(String emp_id);
	List<EmpDTO> empSearch(EmpDTO empSearch);
}
