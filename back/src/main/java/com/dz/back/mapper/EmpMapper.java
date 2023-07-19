package com.dz.back.mapper;

import com.dz.back.dto.EmpDTO;

public interface EmpMapper {
	void login();
	void register(EmpDTO empDTO);
	EmpDTO getEmpByUsername(String username);
	public EmpDTO read(String username);
}
