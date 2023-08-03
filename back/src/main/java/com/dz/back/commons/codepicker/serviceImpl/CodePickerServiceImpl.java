package com.dz.back.commons.codepicker.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.commons.codepicker.dao.CodePickerDAO;



@Service
public class CodePickerServiceImpl {

	@Autowired
    private CodePickerDAO codePickerDAO;

	
	//숫자일경우 코드 번호(int) 검색, 문자일 경우 그대로 String으로 검색
	public List<ComDTO> getCompanyByKeyword(String keyword) {
        try {
        	   Integer co_cd = Integer.parseInt(keyword);
               return codePickerDAO.CompanyfindByCode(co_cd);
           } catch (NumberFormatException e) {
               return codePickerDAO.CompanyfindByName(keyword);
		}
	}
	
	public List<CarDTO> getRegCarByKeyword(String keyword) {
        try {
        	return codePickerDAO.RegCarfindByName(keyword);
           } catch (Exception e) {
			return Collections.emptyList(); 
		}
               
	}
	
}