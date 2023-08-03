package com.dz.back.acc.acc1000.acc1011.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1011.serviceimpl.ACC1011ServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/depmanagement")
public class ACC1011Controller {
	
	@Autowired
	private ACC1011ServiceImpl deptService;
	
	
	// ��� ī�帮��Ʈ ��� ��������
	@GetMapping
	public ResponseEntity<List<DeptDTO>> getCardDeptList(){
		
		List<DeptDTO> deptCardlist = deptService.getCardDeptList();
//		System.out.println(deptCardlist);
		
		return ResponseEntity.ok(deptCardlist);
	}
	
	//ī�� �� ��������
	@PostMapping("/getdept")
	public ResponseEntity<DeptDTO> getCardDept(@RequestBody Map<String,String> dept_cd){
		
		System.out.println(dept_cd);
		
		DeptDTO deptCard = deptService.getCardDept(dept_cd.get("dept_cd"));
		System.out.println(deptCard);
		
		return ResponseEntity.ok(deptCard);
	}
	
	//ī�� �߰�
	@PostMapping("/adddept")
	public ResponseEntity<DeptDTO> addCardDept(@RequestBody DeptDTO dto){
		
		int result = deptService.addDept(dto);
		System.out.println(result);
		 if(result==1) {
			 return ResponseEntity.ok(dto);
		 }else {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
	}
	
	//ī�� ����
	@DeleteMapping("/deletedept/{dept_cd}")
	public void deleteCardDept(@PathVariable String dept_cd) {
	    deptService.deleteDept(dept_cd);
	}

	
	

	

}
