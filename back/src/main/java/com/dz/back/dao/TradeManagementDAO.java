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
		System.out.println("TradeManagementDAO..register ����..");
		sqlSession.getMapper(TradeManagementMapper.class).register(tradeManagementDTO);
	}
	
	public TradeManagementDTO getAllData() {
		return sqlSession.getMapper(TradeManagementMapper.class).getAllData();
	}
	
		//save ���� ��ư�� ������ �Է��� �ؽ�Ʈ�ʵ忡�ִ� ������ ����Ǵ� �ڵ�
	   public void insertData(TradeManagementDTO tradeManagementDTO) {         
	      sqlSession.getMapper(TradeManagementMapper.class).insertData(tradeManagementDTO);      
	   }


}	


