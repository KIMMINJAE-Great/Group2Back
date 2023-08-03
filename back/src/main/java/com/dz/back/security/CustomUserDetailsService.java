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
// semp에서 정보 가져오기
		EmpDTO empDTO = userAuthMapper.read(username);
		
		
// semp에서 가져온 정보중 emp_cd를 사용하여 메뉴 권한을 리스트로 가져오기
		List<MauthDTO> mauthList = userAuthMapper.readMauthList(empDTO.getEmp_cd());

		empDTO.setMauthList(mauthList);
		
// CustomUser로 보낼 dto에 메뉴권한, 메뉴그룹, URL 담기
	
		
		return empDTO == null ? null : new CustomUser(empDTO);
	}
	
}
