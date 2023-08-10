package com.dz.back.commons.codepicker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.commons.codepicker.serviceImpl.CodePickerServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/codepicker")
public class CodePickerController {
	@Autowired
	private CodePickerServiceImpl codePickerServiceImpl;
	

	private static final Logger logger = LoggerFactory.getLogger(CodePickerController.class);

	//ȸ���ڵ嵵��
	@GetMapping("/company/searchinfo")
	public List<ComDTO> SearchCodePickerCompanyInfo(@RequestParam("value") String keyword) {
		//
		System.out.println("�ڵ���Ŀ ȸ�� �˻� ��Ʈ�ѷ� �����");
		return codePickerServiceImpl.getCompanyByKeyword(keyword);
	}
	//�ŷ�ó�ڵ嵵��
	@GetMapping("/trademanagement/searchinfo")
	public List<TradeManagementDTO> SearchCodePickerTradeInfo(@RequestParam("value") String keyword) {
		//
		System.out.println("�ڵ���Ŀ ȸ�� �˻� ��Ʈ�ѷ� �����");
		return codePickerServiceImpl.getTradeByKeyword(keyword);
	}
	
	//�����ڵ嵵��
	@GetMapping("/regcar/searchinfo")
	public List<CarDTO> SearchCodePickerRegCarInfo(@RequestParam("value") String keyword) {
		//
		System.out.println("�ڵ���Ŀ ���� (Test)�˻� ��Ʈ�ѷ� �����");
		return codePickerServiceImpl.getRegCarByKeyword(keyword);
	}
	//�μ��ڵ嵵��
	@GetMapping("/depmanagement/searchinfo")
	public List<DeptDTO> SearchCodePickerDeptInfo(@RequestParam("value") String keyword) {
		//
		System.out.println("�ڵ���Ŀ �μ� (Test)�˻� ��Ʈ�ѷ� �����");
		return codePickerServiceImpl.getDeptByKeyword(keyword);
	}
	
//	//����ڵ嵵��
//	@GetMapping("/empmanagement/searchinfo")
//	public ResponseEntity<List<ACC1010EmpDTO>> SearchCodePickerEmpInfo(@RequestParam("value") String keyword) {
//		//
//		System.out.println("�ڵ���Ŀ ��� �˻� ��Ʈ�ѷ� �����");		
//		return codePickerServiceImpl.getEmpByKeyword(keyword);
//	}
	
	@GetMapping("/empmanagement/searchinfo")
	public ResponseEntity<List<ACC1010EmpDTO>> SearchCodePickerEmpInfo(@RequestParam("value") String keyword) {
	    System.out.println("�ڵ���Ŀ ��� �˻� ��Ʈ�ѷ� �����");
	    ResponseEntity<List<ACC1010EmpDTO>> response = codePickerServiceImpl.getEmpByKeyword(keyword);

	    logger.info("Response: {}", response);

	    return response;
	}
	
	@GetMapping("/codepicker/company")
	public void SearchCodePickerCompany() {
		
	}
	
	@GetMapping("/codepicker/emp")
	public void SearchCodePickerEmp() {
		
	}
}
