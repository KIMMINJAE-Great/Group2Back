package com.dz.back.commons.codepicker.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.commons.codepicker.mapper.CodePickerMapper;


@Repository
public class CodePickerDAO {

	@Autowired
	SqlSession sqlSession;
//comapny
	public List<ComDTO> searchCompanyByKeyword(String keyword) {
		 return sqlSession.getMapper(CodePickerMapper.class).searchCompanyByKeyword(keyword);
	}

//trade
	public List<TradeManagementDTO> searchTradeByKeyword(String keyword) {
		 return sqlSession.getMapper(CodePickerMapper.class).searchTradeByKeyword(keyword);
	}

	
	//regcar
	public List<CarDTO> searchCarByKeyword(String keyword) {
	    return sqlSession.getMapper(CodePickerMapper.class).searchCarByKeyword(keyword);
	}
	
//	//dept
//	public List<DeptDTO> DeptfindByName(String name) {
//		return sqlSession.getMapper(CodePickerMapper.class).DeptfindByName(name);
//	}
//	public List<DeptDTO> DeptfindByCode(Integer code) {
//		return sqlSession.getMapper(CodePickerMapper.class).DeptfindByCode(code);
//	}
//	
//	
//	public List<ACC1010EmpDTO> EmpfindByName(String name) throws Exception {
//	    try {
//	    	System.out.println("여기서 문제발생?");
//	        return sqlSession.getMapper(CodePickerMapper.class).EmpfindByName(name);
//	    } catch (Exception e) {
//	        // Optionally, log the error here.
//	        throw new Exception("DB에 에러 발생함", e);
//	    }
//	}
}
