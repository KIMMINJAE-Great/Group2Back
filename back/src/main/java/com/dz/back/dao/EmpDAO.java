package com.dz.back.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.dto.AuthDTO;
import com.dz.back.dto.EmpDTO;
import com.dz.back.mapper.EmpMapper;


@Repository
public class EmpDAO {
	
	
	@Autowired
	SqlSession sqlSession;
	
	public EmpDTO getEmpByUsername(String username) {
		return sqlSession.getMapper(EmpMapper.class).getEmpByUsername(username);
	}

	public List<EmpDTO> readCardList() {
		return sqlSession.getMapper(EmpMapper.class).readCardList();
	}
	
	public String searchEmpCd(String cocd) {
		return sqlSession.getMapper(EmpMapper.class).searchEmpCd(cocd);
	}

	public int register(EmpDTO empDTO) {
		System.out.println("DAo...................register 실행" + empDTO.toString());
		return sqlSession.getMapper(EmpMapper.class).register(empDTO);
		
	}

	public EmpDTO validEmpCd(String empcd) {
		System.out.println("DAo...................validEmpCd 실행");
		return sqlSession.getMapper(EmpMapper.class).validEmpCd(empcd);
	}
	
	public void rolseSetUser(String empid) {
		sqlSession.getMapper(EmpMapper.class).rolseSetUser(empid);
	}

	public int updateEmp(EmpDTO empDTO) {
		
		return sqlSession.getMapper(EmpMapper.class).updateEmp(empDTO);
	}


	public EmpDTO getEmpCard(String emp_cd) {
		
		return sqlSession.getMapper(EmpMapper.class).getEmpCard(emp_cd);
	}

	public void deleteEmp(String emp_cd) {
		sqlSession.getMapper(EmpMapper.class).deleteEmp(emp_cd);
		
	}

	public void deleteAuth(String emp_id) {
		sqlSession.getMapper(EmpMapper.class).deleteAuth(emp_id);
		
	}

	public List<EmpDTO> empSearch(EmpDTO empSearch) {
		
		return sqlSession.getMapper(EmpMapper.class).empSearch(empSearch);
	}

}	


