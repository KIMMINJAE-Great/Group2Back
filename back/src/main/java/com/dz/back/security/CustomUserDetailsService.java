package com.dz.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dz.back.dto.EmpDTO;
import com.dz.back.mapper.EmpMapper;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		System.out.println("loadUserByUsername........");
		
		System.out.println("username : " + username);
		EmpDTO empDTO = empMapper.read(username);
		if (empDTO == null) {
			System.out.println("MemberDTO is null for username: " + username); 
		} else {
			if (empDTO.getPassword() == null) {
				System.out.println("Password is null for username: " + username);
			}
			if (empDTO.getAuthList() == null) {
				System.out.println("AuthList is null for username: " + username);
			}
		}
		return empDTO == null ? null : new CustomUser(empDTO);
	}
	
}
