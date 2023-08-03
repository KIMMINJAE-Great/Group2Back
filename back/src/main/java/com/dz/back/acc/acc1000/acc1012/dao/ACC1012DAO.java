package com.dz.back.acc.acc1000.acc1012.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.mapper.ACC1010Mapper;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1012.mapper.ACC1012Mapper;


@Repository
public class ACC1012DAO {
	
	
	@Autowired
	SqlSession sqlSession;
	
	public void register(TradeManagementDTO tradeManagementDTO) {
		System.out.println("TradeManagementDAO..register ����..");
		sqlSession.getMapper(ACC1012Mapper.class).register(tradeManagementDTO);
	}
	
	public TradeManagementDTO getAllData() {
		return sqlSession.getMapper(ACC1012Mapper.class).getAllData();
	}
	
		//save ���� ��ư�� ������ �Է��� �ؽ�Ʈ�ʵ忡�ִ� ������ ����Ǵ� �ڵ�
	   public void insertData(TradeManagementDTO tradeManagementDTO) {         
	      sqlSession.getMapper(ACC1012Mapper.class).insertData(tradeManagementDTO);      
	   }


}	


