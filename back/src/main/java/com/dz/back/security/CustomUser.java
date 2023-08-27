package com.dz.back.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.dz.back.userauth.dto.AuthDTO;
import com.dz.back.userauth.dto.EmpDTO;
import com.dz.back.userauth.dto.MauthDTO;

public class CustomUser extends User {

	private EmpDTO empDTO;

	private String co_cd;


	private String emp_cd;
	private String emp_nm;
	private String emp_id;
	private String dept_cd;
	private List<AuthDTO> authList;
	private List<MauthDTO> mauthList;

	// React에 넘겨줄 회원정보에서 password를 null로 변환
	@Override
	public String getPassword() {
		return null;
	}

	public CustomUser(EmpDTO empDTO) {
		super(empDTO.getEmp_id(), empDTO.getPassword(), empDTO.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

		this.co_cd = empDTO.getCo_cd();
		this.emp_cd = empDTO.getEmp_cd();
		this.emp_nm = empDTO.getEmp_nm();
		this.emp_id = empDTO.getEmp_id();
		this.dept_cd = empDTO.getDept_cd();
		this.authList = empDTO.getAuthList();
		this.mauthList = empDTO.getMauthList();
		System.out.println("커스텀 유저 : "+empDTO.toString());

	}

	

	public List<MauthDTO> getMauthList() {
		return mauthList;
	}

	public String getEmp_cd() {
		return emp_cd;
	}

	public String getEmp_nm() {
		return emp_nm;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public String getDept_cd() {
		return dept_cd;
	}

	public List<AuthDTO> getAuthList() {
		return authList;
	}
	public String getCo_cd() {
		return co_cd;
	}

	public void setCo_cd(String co_cd) {
		this.co_cd = co_cd;
	}
}
