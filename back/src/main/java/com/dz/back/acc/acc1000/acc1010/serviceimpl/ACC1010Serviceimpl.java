package com.dz.back.acc.acc1000.acc1010.serviceimpl;

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

import com.dz.back.acc.acc1000.acc1010.dao.ACC1010DAO;
import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.dto.ACC1010MauthDTO;
import com.dz.back.acc.acc1000.acc1010.dto.MenuDTO;
import com.dz.back.acc.acc1000.acc1010.service.ACC1010Service;

@Service
public class ACC1010Serviceimpl implements ACC1010Service  {

	@Autowired
	private ACC1010DAO empDAO;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

//	사원 유무 확인
	

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}
//	사원목록 전체 불러오기 
	@Override
	public List<ACC1010EmpDTO> readCardList(){
		return empDAO.readCardList();
	}
	
//	자동채번을 위한 CO_CD이용해 최대값 가져오기
	@Override
	public String searchEmpCd(String cocd) {
		
		return empDAO.searchEmpCd(cocd);
	}
	
// 사원 등록
	@Override
	public int register(ACC1010EmpDTO empDTO) {
		System.out.println("service...........register 실행");
		return empDAO.register(empDTO);
	}

	@Override
	public ACC1010EmpDTO validEmpCd(String empcd) {
		System.out.println("service....... validEmpCd 실행 ");
		return empDAO.validEmpCd(empcd);
	}
// 사원 기본 권한 USER 설정
	@Override
	public void rolesSetUser(String empid) {
		empDAO.rolesSetUser(empid);
		
	}
//  사원수정
	@Override
	public int updateEmp(ACC1010EmpDTO empDTO) {
		
		return empDAO.updateEmp(empDTO);
	}
//	단일 사원 정보 가져오기
	@Override
	public ACC1010EmpDTO getEmpCard(String emp_cd) {
		return empDAO.getEmpCard(emp_cd);
		
	}
//	사원 삭제
	@Override
	public void deleteEmp(String emp_cd) {
	empDAO.deleteEmp(emp_cd);
		
	}
//	사원 삭제시 권한테이블의 권한 삭제
	@Override
	public void deleteAuth(String emp_id) {
		empDAO.deleteAuth(emp_id);
		
	}
//	조회로 사원 검색
	@Override
	public List<ACC1010EmpDTO> empSearch(ACC1010EmpDTO empSearch) {
		
		return empDAO.empSearch(empSearch);
	}
// 사원의 메뉴 권한 검색
	@Override
	public List<ACC1010MauthDTO> getMauth(String emp_cd) {
		
		return empDAO.getMauth(emp_cd);
	}
//메뉴 가져오기
	@Override
	public MenuDTO searchMenu(String menucd) {
		return empDAO.searchMenu(menucd);
	}
//	메뉴권한 등록
	@Override
	public int insertMauth(ACC1010MauthDTO mauthDTO) {
		return empDAO.insertMauth(mauthDTO);
		
	}
//  메뉴권한 삭제
	@Override
	public void deleteMauth(ACC1010MauthDTO dto) {
		empDAO.deleteMauth(dto);
		
	}
// 아이디 중복 검사
	@Override
	public int checkEmpId(String emp_id) {
		
		return empDAO.checkEmpId(emp_id);
	}


	
}
