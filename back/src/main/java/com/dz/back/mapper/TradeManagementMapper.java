package com.dz.back.mapper;


import com.dz.back.dto.EmpDTO;
import com.dz.back.dto.TradeManagementDTO;

public interface  TradeManagementMapper {

	void register(TradeManagementDTO tradeManagementDTO);
	
	
	
	// TradeManagementDTO 의 모든 데이터 가져오기
	TradeManagementDTO getAllData();
	
	 public void insertData(TradeManagementDTO tradeManagementDTO);
}
