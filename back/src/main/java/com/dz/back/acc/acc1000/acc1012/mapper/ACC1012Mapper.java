package com.dz.back.acc.acc1000.acc1012.mapper;


import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;

public interface  ACC1012Mapper {

	void register(TradeManagementDTO tradeManagementDTO);
	
	
	
	// TradeManagementDTO �� ��� ������ ��������
	TradeManagementDTO getAllData();
	
	 public void insertData(TradeManagementDTO tradeManagementDTO);
}
