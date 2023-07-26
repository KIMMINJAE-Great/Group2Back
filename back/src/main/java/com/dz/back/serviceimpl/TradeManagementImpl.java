package com.dz.back.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.dao.EmpDAO;
import com.dz.back.dao.TradeManagementDAO;
import com.dz.back.dto.EmpDTO;
import com.dz.back.dto.TradeManagementDTO;

@Service
public class TradeManagementImpl {
	
	@Autowired
	private TradeManagementDAO tradeManagementDAO;


	public void register(TradeManagementDTO tradeManagementDTO) {
		System.out.println(tradeManagementDTO.toString());
		tradeManagementDAO.register(tradeManagementDTO);
	}
	
		// insert 
	   public void insertData(TradeManagementDTO tradeManagementDTO) {
		   tradeManagementDAO.insertData(tradeManagementDTO);
	   }


	

}
