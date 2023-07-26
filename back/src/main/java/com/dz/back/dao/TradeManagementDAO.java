package com.dz.back.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.dto.EmpDTO;
import com.dz.back.dto.TradeManagementDTO;
import com.dz.back.mapper.EmpMapper;
import com.dz.back.mapper.TradeManagementMapper;


@Repository
public class TradeManagementDAO {
	
	
	@Autowired
	SqlSession sqlSession;
	
	public void register(TradeManagementDTO tradeManagementDTO) {
		System.out.println("TradeManagementDAO..register 실행..");
		sqlSession.getMapper(TradeManagementMapper.class).register(tradeManagementDTO);
	}
	
	public TradeManagementDTO getAllData() {
		return sqlSession.getMapper(TradeManagementMapper.class).getAllData();
	}
	
		//save 저장 버튼을 누르면 입력한 텍스트필드에있는 값들이 저장되는 코드
	   public void insertData(TradeManagementDTO tradeManagementDTO) {         
	      sqlSession.getMapper(TradeManagementMapper.class).insertData(tradeManagementDTO);      
	   }


}	


