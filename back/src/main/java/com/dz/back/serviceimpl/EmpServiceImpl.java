package com.dz.back.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dz.back.dao.EmpDAO;
import com.dz.back.dto.EmpDTO;
import com.dz.back.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService  {

	@Autowired
	private EmpDAO empDAO;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public EmpDTO getEmp(String id) {
		
		return empDAO.getEmpByUsername(id);
	}

	@Override
	public void register(EmpDTO empDTO) {
		System.out.println(empDTO.toString());
		//empDTO.setPassword(passwordEncoder.encode(empDTO.getPassword()));
		empDAO.register(empDTO);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}


	
}
