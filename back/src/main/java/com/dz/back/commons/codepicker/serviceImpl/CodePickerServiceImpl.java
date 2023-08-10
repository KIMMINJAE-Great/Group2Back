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

	
	//�����ϰ�� �ڵ� ��ȣ(int) �˻�, ������ ��� �״�� String���� �˻�
	public List<ComDTO> getCompanyByKeyword(String keyword) {
        try {
        	   Integer co_cd = Integer.parseInt(keyword);
               return codePickerDAO.CompanyfindByCode(co_cd);
           } catch (NumberFormatException e) {
               return codePickerDAO.CompanyfindByName(keyword);
		}
	}
	//�����ϰ�� �ڵ� ��ȣ(int) �˻�, ������ ��� �״�� String���� �˻�
		public List<TradeManagementDTO> getTradeByKeyword(String keyword) {
	        try {
	        	   Integer co_cd = Integer.parseInt(keyword);
	               return codePickerDAO.TradefindByCode(co_cd);
	           } catch (NumberFormatException e) {
	               return codePickerDAO.TradefindByName(keyword);
			}
		}
	
	public List<CarDTO> getRegCarByKeyword(String keyword) {
        try {
        	return codePickerDAO.RegCarfindByName(keyword);
           } catch (Exception e) {
			return Collections.emptyList(); 
		}
               
	}
	public List<DeptDTO> getDeptByKeyword(String keyword) {
        try {
        	return codePickerDAO.DeptfindByName(keyword);
           } catch (Exception e) {
			return Collections.emptyList(); 
		}               
	}

	public ResponseEntity<List<ACC1010EmpDTO>> getEmpByKeyword(String keyword) {
	    try {
	        List<ACC1010EmpDTO> empList = codePickerDAO.EmpfindByName(keyword);
	        return new ResponseEntity<>(empList, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }               
	}
	
}