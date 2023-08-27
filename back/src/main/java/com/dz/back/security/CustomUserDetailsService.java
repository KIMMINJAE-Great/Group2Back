package com.dz.back.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dz.back.userauth.dto.EmpDTO;
import com.dz.back.userauth.dto.MauthDTO;
import com.dz.back.userauth.mapper.UserAuthMapper;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserAuthMapper userAuthMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		System.out.println("loadUserByUsername........");
		
		System.out.println("username : " + username);
// semp���� ���� ��������
		EmpDTO empDTO = userAuthMapper.read(username);
		
		
// semp���� ������ ������ emp_cd�� ����Ͽ� �޴� ������ ����Ʈ�� ��������
		List<MauthDTO> mauthList = userAuthMapper.readMauthList(empDTO.getEmp_cd());

// CustomUser�� ���� dto�� �޴�����, �޴��׷�, URL ���
		empDTO.setMauthList(mauthList);
		
	
		String co_cd = (userAuthMapper.getEmpByUsername(username)).getCo_cd();
		empDTO.setCo_cd(co_cd);
		System.out.println("login...........cocd get");
		System.out.println(empDTO.toString());
		return empDTO == null ? null : new CustomUser(empDTO);
	}
	
}
