package com.dz.back.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dz.back.dto.EmpDTO;
import com.dz.back.dto.MauthDTO;
import com.dz.back.mapper.EmpMapper;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		System.out.println("loadUserByUsername........");
		
		System.out.println("username : " + username);
// semp���� ���� ��������
		EmpDTO empDTO = empMapper.read(username);
		
		
// semp���� ������ ������ emp_cd�� ����Ͽ� �޴� ������ ����Ʈ�� ��������
		List<MauthDTO> mauthList = empMapper.readMauthList(empDTO.getEmp_cd());

		empDTO.setMauthList(mauthList);
		
// CustomUser�� ���� dto�� �޴�����, �޴��׷�, URL ���
	
		
		return empDTO == null ? null : new CustomUser(empDTO);
	}
	
}
