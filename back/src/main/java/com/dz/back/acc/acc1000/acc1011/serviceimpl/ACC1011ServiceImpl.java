package com.dz.back.acc.acc1000.acc1011.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1011.dao.ACC1011DAO;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;

@Service
public class ACC1011ServiceImpl {
	
	@Autowired
	private ACC1011DAO deptDAO;
	
	public List<DeptDTO> getCardDeptList() {

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

    public int updateDept(DeptDTO dto) {

        return deptDAO.updateDept(dto);
    }


    public List<DeptDTO> deptSearch(DeptDTO deptSearch) {

        return deptDAO.deptSearch(deptSearch);
    }
}
