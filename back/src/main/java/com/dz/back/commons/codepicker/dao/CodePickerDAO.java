package com.dz.back.commons.codepicker.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.commons.codepicker.mapper.CodePickerMapper;


@Repository
public class CodePickerDAO {

	@Autowired
	SqlSession sqlSession;

	public List<ComDTO> CompanyfindByName(String name) {
		return sqlSession.getMapper(CodePickerMapper.class).CompanyfindByName(name);
	}

	public List<ComDTO> CompanyfindByCode(Integer code) {
		return sqlSession.getMapper(CodePickerMapper.class).CompanyfindByCode(code);
	}
	
	public List<CarDTO> RegCarfindByName(String name) {
		return sqlSession.getMapper(CodePickerMapper.class).RegCarfindByName(name);
	}
}
