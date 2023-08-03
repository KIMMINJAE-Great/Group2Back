package com.dz.back.acc.acc1000.acc1012.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1010.dao.ACC1010DAO;
import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1012.dao.ACC1012DAO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;

@Service
public class ACC1012Serviceimpl {
	
	@Autowired
	private ACC1012DAO tradeManagementDAO;


	public void register(TradeManagementDTO tradeManagementDTO) {
		System.out.println(tradeManagementDTO.toString());
		tradeManagementDAO.register(tradeManagementDTO);
	}
	
		// insert 
	   public void insertData(TradeManagementDTO tradeManagementDTO) {
		   tradeManagementDAO.insertData(tradeManagementDTO);
	   }


	

}
