package com.dz.back.commons.codepicker.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
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
	public List<DeptDTO> DeptfindByName(String name) {
		return sqlSession.getMapper(CodePickerMapper.class).DeptfindByName(name);
	}
	public List<ACC1010EmpDTO> EmpfindByName(String name) throws Exception {
	    try {
	    	System.out.println("여기서 문제발생?");
	        return sqlSession.getMapper(CodePickerMapper.class).EmpfindByName(name);
	    } catch (Exception e) {
	        // Optionally, log the error here.
	        throw new Exception("DB에 에러 발생함", e);
	    }
	}
}
