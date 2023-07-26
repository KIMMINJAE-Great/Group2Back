package com.dz.back.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.dao.DeptDAO;
import com.dz.back.dto.DeptDTO;

@Service
public class DeptServiceImpl {
	
	@Autowired
	private DeptDAO deptDAO;
	
	public List<DeptDTO> getCardDeptList(){
		
		return deptDAO.getDeptList();
		
	}
	
	public DeptDTO getCardDept(String dept_cd) {
		System.out.println(dept_cd);
		return deptDAO.getDeptByCode(dept_cd);
	}
	
	public int addDept(DeptDTO dto) {
		
		
		return deptDAO.insertDept(dto);
	}
	
	public void deleteDept(String dept_cd) {
		
		deptDAO.deleteDept(dept_cd);
	}

}
