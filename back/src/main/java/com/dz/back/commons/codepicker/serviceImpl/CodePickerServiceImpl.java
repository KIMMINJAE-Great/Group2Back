package com.dz.back.commons.codepicker.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.commons.codepicker.dao.CodePickerDAO;



@Service
public class CodePickerServiceImpl {

	@Autowired
    private CodePickerDAO codePickerDAO;

	
	
	public List<ComDTO> getCompanyByKeyword(String keyword) {
     	return codePickerDAO.searchCompanyByKeyword(keyword);     
	}
	
	public List<TradeManagementDTO> getTradeByKeyword(String keyword) {
     	return codePickerDAO.searchTradeByKeyword(keyword);     
	}
	
	public List<CarDTO> getRegCarByKeyword(String keyword) {
        	return codePickerDAO.searchCarByKeyword(keyword);     
	}
	
	
//	public List<DeptDTO> getDeptByKeyword(String keyword) {
//        try {
//        	Integer dept_cd = Integer.parseInt(keyword);
//            return codePickerDAO.DeptfindByCode(dept_cd);          	
//           } catch (NumberFormatException e) {
//        	return codePickerDAO.DeptfindByName(keyword);
//		}               
//	}
//	public ResponseEntity<List<ACC1010EmpDTO>> getEmpByKeyword(String keyword) {
//	    try {
//	        List<ACC1010EmpDTO> empList = codePickerDAO.EmpfindByName(keyword);
//	        return new ResponseEntity<>(empList, HttpStatus.OK);
//	    } catch (Exception e) {
//	        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
//	    }               
//	}
	
}