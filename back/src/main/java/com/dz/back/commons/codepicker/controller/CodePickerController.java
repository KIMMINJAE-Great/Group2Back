package com.dz.back.commons.codepicker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.commons.codepicker.serviceImpl.CodePickerServiceImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/codepicker")
public class CodePickerController {
	@Autowired
	private CodePickerServiceImpl codePickerServiceImpl;
	
	
	//회사 이름으로 검색하는 코드 
	@GetMapping("/company/searchinfo")
	public List<ComDTO> SearchCodePickerCompany(@RequestParam("value") String keyword) {
		//
		System.out.println("코드피커 회사 검색 컨트롤러 실행됨");
		return codePickerServiceImpl.getCompanyByKeyword(keyword);
	}
	
	//차량등록
	@GetMapping("/regcar/searchinfo")
	public List<CarDTO> SearchCodePickerRegCar(@RequestParam("value") String keyword) {
		//
		System.out.println("코드피커 회계단위 (Test)검색 컨트롤러 실행됨");
		return codePickerServiceImpl.getRegCarByKeyword(keyword);
	}
	
	
	@GetMapping("/codepicker/company")
	public void SearchCodePickerCompany() {
		
	}
	
	@GetMapping("/codepicker/emp")
	public void SearchCodePickerEmp() {
		
	}
}
