package com.dz.back.ace.ace1000.ace1010.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.mapper.ACC1010Mapper;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.SendYnDTO;
import com.dz.back.ace.ace1000.ace1010.dto.StartEndFgDTO;
import com.dz.back.ace.ace1000.ace1010.dto.UseFgDTO;
import com.dz.back.ace.ace1000.ace1010.mapper.ACE1010Mapper;

@Repository
public class ACE1010DAO {
	@Autowired
	SqlSession sqlSession;
	
	
	public List<AbizCarPersonDTO> getallcars(){
		
		return sqlSession.getMapper(ACE1010Mapper.class).getallcars();
	}


	public List<UseFgDTO> usefg() {
	
		return sqlSession.getMapper(ACE1010Mapper.class).usefg();
	}


	public List<SendYnDTO> sendyn() {
		
		return sqlSession.getMapper(ACE1010Mapper.class).sendyn();
	}


	public List<StartEndFgDTO> startendfg() {
		
		return sqlSession.getMapper(ACE1010Mapper.class).startendfg();
	}
}
