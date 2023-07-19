package com.dz.back.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.dto.EmpDTO;
import com.dz.back.mapper.EmpMapper;


@Repository
public class EmpDAO {
	
	
	@Autowired
	SqlSession sqlSession;
	
	public void register(EmpDTO empDTO) {
		System.out.println("EmpDAO.....register 실행.........");
		sqlSession.getMapper(EmpMapper.class).register(empDTO);
	}
	
	public EmpDTO getEmpByUsername(String username) {
		return sqlSession.getMapper(EmpMapper.class).getEmpByUsername(username);
	}

}	


