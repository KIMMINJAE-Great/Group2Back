package com.dz.back.mapper;


import com.dz.back.dto.EmpDTO;
import com.dz.back.dto.TradeManagementDTO;

public interface  TradeManagementMapper {

	void register(TradeManagementDTO tradeManagementDTO);
	
	
	
	// TradeManagementDTO �� ��� ������ ��������
	TradeManagementDTO getAllData();
	
	 public void insertData(TradeManagementDTO tradeManagementDTO);
}
