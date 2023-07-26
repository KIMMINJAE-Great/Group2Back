package com.dz.back.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.dto.DeptDTO;
import com.dz.back.dto.EmpDTO;
import com.dz.back.mapper.DeptMapper;
import com.dz.back.mapper.EmpMapper;

@Repository
public class DeptDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	public List<DeptDTO> getDeptList() {		
		return sqlsession.getMapper(DeptMapper.class).getDeptList();
	}
	
	public DeptDTO getDeptByCode(String dept_cd) {	
		System.out.println(dept_cd);
		return sqlsession.getMapper(DeptMapper.class).getDeptByCode(dept_cd);	
	}
	
	public int insertDept(DeptDTO dto) {
		
		return sqlsession.getMapper(DeptMapper.class).insertDept(dto);
	}
	
	public void deleteDept(String dept_cd) {
		
		sqlsession.getMapper(DeptMapper.class).deleteDept(dept_cd);
	}
	


}
