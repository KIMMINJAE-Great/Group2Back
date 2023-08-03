package com.dz.back.acc.acc1000.acc1011.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.mapper.ACC1010Mapper;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1011.mapper.ACC1011Mapper;

@Repository
public class ACC1011DAO {
	
	@Autowired
	SqlSession sqlsession;
	
	public List<DeptDTO> getDeptList() {
		return sqlsession.getMapper(ACC1011Mapper.class).getDeptList();
	}

	public DeptDTO getDeptByCode(String dept_cd) {
		System.out.println(dept_cd);
		return sqlsession.getMapper(ACC1011Mapper.class).getDeptByCode(dept_cd);
	}

	public int insertDept(DeptDTO dto) {

		return sqlsession.getMapper(ACC1011Mapper.class).insertDept(dto);
	}

	public void deleteDept(String dept_cd) {

		sqlsession.getMapper(ACC1011Mapper.class).deleteDept(dept_cd);
	}

	public int updateDept(DeptDTO dto) {

		return sqlsession.getMapper(ACC1011Mapper.class).updateDept(dto);
	}

	public List<DeptDTO> deptSearch(DeptDTO deptSearch) {
		
		return sqlsession.getMapper(ACC1011Mapper.class).deptSearch(deptSearch);
	}

	


}
