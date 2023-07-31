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

//	��� ���� Ȯ��
	@Override
	public EmpDTO getEmp(String id) {
		
		return empDAO.getEmpByUsername(id);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}
//	������ ��ü �ҷ����� 
	@Override
	public List<EmpDTO> readCardList(){
		return empDAO.readCardList();
	}
	
//	�ڵ�ä���� ���� CO_CD�̿��� �ִ밪 ��������
	@Override
	public String searchEmpCd(String cocd) {
		
		return empDAO.searchEmpCd(cocd);
	}
	
// ��� ���
	@Override
	public int register(EmpDTO empDTO) {
		System.out.println("service...........register ����");
		return empDAO.register(empDTO);
	}

	@Override
	public EmpDTO validEmpCd(String empcd) {
		System.out.println("service....... validEmpCd ���� ");
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
