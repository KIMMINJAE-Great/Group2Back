package com.dz.back.mapper;

import java.util.List;

import com.dz.back.dto.EmpDTO;
import com.dz.back.dto.MauthDTO;

public interface EmpMapper {
	void login();
	void register(EmpDTO empDTO);
	EmpDTO getEmpByUsername(String username);
	public EmpDTO read(String username);
	List<MauthDTO> readMauthList(String emp_cd);
}
