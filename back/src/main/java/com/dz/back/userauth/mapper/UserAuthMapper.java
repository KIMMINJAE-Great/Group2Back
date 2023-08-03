package com.dz.back.userauth.mapper;

import java.util.List;

import com.dz.back.userauth.dto.EmpDTO;
import com.dz.back.userauth.dto.MauthDTO;

public interface UserAuthMapper {
	void login();
	EmpDTO getEmpByUsername(String username);
	public EmpDTO read(String username);
	List<MauthDTO> readMauthList(String emp_cd);
}
