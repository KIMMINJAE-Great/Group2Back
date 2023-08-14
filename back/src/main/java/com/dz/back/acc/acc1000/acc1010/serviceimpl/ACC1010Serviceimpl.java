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

//	��� ���� Ȯ��
	

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}
//	������ ��ü �ҷ����� 
	@Override
	public List<ACC1010EmpDTO> readCardList(){
		return empDAO.readCardList();
	}
	
//	�ڵ�ä���� ���� CO_CD�̿��� �ִ밪 ��������
	@Override
	public String searchEmpCd(String cocd) {
		
		return empDAO.searchEmpCd(cocd);
	}
	
// ��� ���
	@Override
	public int register(ACC1010EmpDTO empDTO) {
		System.out.println("service...........register ����");
		return empDAO.register(empDTO);
	}

	@Override
	public ACC1010EmpDTO validEmpCd(String empcd) {
		System.out.println("service....... validEmpCd ���� ");
		return empDAO.validEmpCd(empcd);
	}
// ��� �⺻ ���� USER ����
	@Override
	public void rolesSetUser(String empid) {
		empDAO.rolesSetUser(empid);
		
	}
//  �������
	@Override
	public int updateEmp(ACC1010EmpDTO empDTO) {
		
		return empDAO.updateEmp(empDTO);
	}
//	���� ��� ���� ��������
	@Override
	public ACC1010EmpDTO getEmpCard(String emp_cd) {
		return empDAO.getEmpCard(emp_cd);
		
	}
//	��� ����
	@Override
	public void deleteEmp(String emp_cd) {
	empDAO.deleteEmp(emp_cd);
		
	}
//	��� ������ �������̺��� ���� ����
	@Override
	public void deleteAuth(String emp_id) {
		empDAO.deleteAuth(emp_id);
		
	}
//	��ȸ�� ��� �˻�
	@Override
	public List<ACC1010EmpDTO> empSearch(ACC1010EmpDTO empSearch) {
		
		return empDAO.empSearch(empSearch);
	}
// ����� �޴� ���� �˻�
	@Override
	public List<ACC1010MauthDTO> getMauth(String emp_cd) {
		
		return empDAO.getMauth(emp_cd);
	}
//�޴� ��������
	@Override
	public MenuDTO searchMenu(String menucd) {
		return empDAO.searchMenu(menucd);
	}
//	�޴����� ���
	@Override
	public int insertMauth(ACC1010MauthDTO mauthDTO) {
		return empDAO.insertMauth(mauthDTO);
		
	}
//  �޴����� ����
	@Override
	public void deleteMauth(ACC1010MauthDTO dto) {
		empDAO.deleteMauth(dto);
		
	}
// ���̵� �ߺ� �˻�
	@Override
	public int checkEmpId(String emp_id) {
		
		return empDAO.checkEmpId(emp_id);
	}


	
}
