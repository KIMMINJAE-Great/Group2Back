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

//	사원 유무 확인
	@Override
	public EmpDTO getEmp(String id) {
		
		return empDAO.getEmpByUsername(id);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}
//	사원목록 전체 불러오기 
	@Override
	public List<EmpDTO> readCardList(){
		return empDAO.readCardList();
	}
	
//	자동채번을 위한 CO_CD이용해 최대값 가져오기
	@Override
	public String searchEmpCd(String cocd) {
		
		return empDAO.searchEmpCd(cocd);
	}
	
// 사원 등록
	@Override
	public int register(EmpDTO empDTO) {
		System.out.println("service...........register 실행");
		return empDAO.register(empDTO);
	}

	@Override
	public EmpDTO validEmpCd(String empcd) {
		System.out.println("service....... validEmpCd 실행 ");
		return empDAO.validEmpCd(empcd);
	}

	@Override
	public void rolseSetUser(String empid) {
		empDAO.rolseSetUser(empid);
		
	}

	@Override
	public int updateEmp(EmpDTO empDTO) {
		
		return empDAO.updateEmp(empDTO);
	}
	
	@Override
	public EmpDTO getEmpCard(String emp_cd) {
		return empDAO.getEmpCard(emp_cd);
		
	}
	
	@Override
	public void deleteEmp(String emp_cd) {
	empDAO.deleteEmp(emp_cd);
		
	}
	@Override
	public void deleteAuth(String emp_id) {
		empDAO.deleteAuth(emp_id);
		
	}
	@Override
	public List<EmpDTO> empSearch(EmpDTO empSearch) {
		
		return empDAO.empSearch(empSearch);
	}


	
}
