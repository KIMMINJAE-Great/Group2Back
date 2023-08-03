package com.dz.back.acc.acc1000.acc1010.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.dto.ACC1010MauthDTO;
import com.dz.back.acc.acc1000.acc1010.dto.MenuDTO;
import com.dz.back.acc.acc1000.acc1010.mapper.ACC1010Mapper;


@Repository
public class ACC1010DAO {
	
	
	@Autowired
	SqlSession sqlSession;
	


	public List<ACC1010EmpDTO> readCardList() {
		return sqlSession.getMapper(ACC1010Mapper.class).readCardList();
	}
	
	public String searchEmpCd(String cocd) {
		return sqlSession.getMapper(ACC1010Mapper.class).searchEmpCd(cocd);
	}

	public int register(ACC1010EmpDTO empDTO) {
		System.out.println("DAo...................register 실행" + empDTO.toString());
		return sqlSession.getMapper(ACC1010Mapper.class).register(empDTO);
		
	}

	public ACC1010EmpDTO validEmpCd(String empcd) {
		System.out.println("DAo...................validEmpCd 실행");
		return sqlSession.getMapper(ACC1010Mapper.class).validEmpCd(empcd);
	}
	
	public void rolesSetUser(String empid) {
		sqlSession.getMapper(ACC1010Mapper.class).rolesSetUser(empid);
	}

	public int updateEmp(ACC1010EmpDTO empDTO) {
		
		return sqlSession.getMapper(ACC1010Mapper.class).updateEmp(empDTO);
	}


	public ACC1010EmpDTO getEmpCard(String emp_cd) {
		
		return sqlSession.getMapper(ACC1010Mapper.class).getEmpCard(emp_cd);
	}

	public void deleteEmp(String emp_cd) {
		sqlSession.getMapper(ACC1010Mapper.class).deleteEmp(emp_cd);
		
	}

	public void deleteAuth(String emp_id) {
		sqlSession.getMapper(ACC1010Mapper.class).deleteAuth(emp_id);
		
	}

	public List<ACC1010EmpDTO> empSearch(ACC1010EmpDTO empSearch) {
		
		return sqlSession.getMapper(ACC1010Mapper.class).empSearch(empSearch);
	}

	public List<ACC1010MauthDTO> getMauth(String emp_cd) {
		return sqlSession.getMapper(ACC1010Mapper.class).getMauth(emp_cd);
	}

	public MenuDTO searchMenu(String menucd) {
		
		return sqlSession.getMapper(ACC1010Mapper.class).searchMenu(menucd);
	}

	public int insertMauth(ACC1010MauthDTO mauthDTO) {
		return sqlSession.getMapper(ACC1010Mapper.class).insertMauth(mauthDTO);
		
	}

	public void deleteMauth(ACC1010MauthDTO dto) {
		sqlSession.getMapper(ACC1010Mapper.class).deleteMauth(dto);
		
	}

	public int checkEmpId(String emp_id) {
		
		return sqlSession.getMapper(ACC1010Mapper.class).checkEmpId(emp_id);
	}

}	


