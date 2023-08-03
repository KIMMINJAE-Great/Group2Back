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
	
	
	//ȸ�� �̸����� �˻��ϴ� �ڵ� 
	@GetMapping("/company/searchinfo")
	public List<ComDTO> SearchCodePickerCompany(@RequestParam("value") String keyword) {
		//
		System.out.println("�ڵ���Ŀ ȸ�� �˻� ��Ʈ�ѷ� �����");
		return codePickerServiceImpl.getCompanyByKeyword(keyword);
	}
	
	//�������
	@GetMapping("/regcar/searchinfo")
	public List<CarDTO> SearchCodePickerRegCar(@RequestParam("value") String keyword) {
		//
		System.out.println("�ڵ���Ŀ ȸ����� (Test)�˻� ��Ʈ�ѷ� �����");
		return codePickerServiceImpl.getRegCarByKeyword(keyword);
	}
	
	
	@GetMapping("/codepicker/company")
	public void SearchCodePickerCompany() {
		
	}
	
	@GetMapping("/codepicker/emp")
	public void SearchCodePickerEmp() {
		
	}
}
