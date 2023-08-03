package com.dz.back.userauth.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.userauth.dto.EmpDTO;
import com.dz.back.userauth.mapper.UserAuthMapper;


@Repository
public class UserAuthDAO {
	@Autowired
	SqlSession sqlSession;
	
	public EmpDTO getEmpByUsername(String username) {
		return sqlSession.getMapper(UserAuthMapper.class).getEmpByUsername(username);
	}
}
