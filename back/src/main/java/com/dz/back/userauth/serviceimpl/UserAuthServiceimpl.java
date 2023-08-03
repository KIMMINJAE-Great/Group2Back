package com.dz.back.userauth.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.userauth.dto.EmpDTO;
import com.dz.back.userauth.dao.UserAuthDAO;
import com.dz.back.userauth.service.UserAuthService;

@Service
public class UserAuthServiceimpl implements UserAuthService {
	@Autowired
	private UserAuthDAO userAuthDAO;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

//	사원 유무 확인
	@Override
	public EmpDTO getEmp(String id) {
		
		return userAuthDAO.getEmpByUsername(id);
	}
}

