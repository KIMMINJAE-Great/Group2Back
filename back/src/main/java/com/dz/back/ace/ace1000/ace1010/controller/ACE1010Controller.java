package com.dz.back.ace.ace1000.ace1010.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.SendYnDTO;
import com.dz.back.ace.ace1000.ace1010.dto.StartEndFgDTO;
import com.dz.back.ace.ace1000.ace1010.dto.UseFgDTO;
import com.dz.back.ace.ace1000.ace1010.service.ACE1010Service;

@RestController
@RequestMapping("/ace1010")
@CrossOrigin(origins="*")
public class ACE1010Controller {
	
	@Autowired
	private ACE1010Service service;
//	Test ������ ��������
	@GetMapping("/getallcars")
	public ResponseEntity<List<AbizCarPersonDTO>> getallcars(){
		List<AbizCarPersonDTO> dto = service.getallcars();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
		
	}
	
//	���� ����
	@GetMapping("/usefg")
	public ResponseEntity<List<UseFgDTO>> usefg(){
		List<UseFgDTO> dto = service.usefg();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}
	
//	���� ����
	@GetMapping("/sendyn")
	public ResponseEntity<List<SendYnDTO>> sendyn(){
		List<SendYnDTO> dto = service.sendyn();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}
	
	
//	���,���� ����
	@GetMapping("/startendfg")
	public ResponseEntity<List<StartEndFgDTO>> startendfg(){
		List<StartEndFgDTO> dto = service.startendfg();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}
//	Test �����Ϻ� �Է�
	@PostMapping("/test")
	public  ResponseEntity<String> test(@RequestBody AbizCarPersonDTO dto) {
		System.out.println("�ך� ����........... : "+dto.toString());
		
//		insert�ϱ����� ������ AbbizcarpersonDTO ����
	AbizCarPersonDTO acpdto = dto;
		System.out.println(dto.getCar_cd());
		
//	������ seq_nb�� �ִ밪�� ������ +1 ���ֱ�
		int seqnb = service.findMaxSeqNb(dto.getCar_cd());
		seqnb++;   
	    acpdto.setSeq_nb(seqnb);
	    
// use_dt ��¥ ���� ����	    
	    String datetimeString = dto.getUse_dt();
	    if (datetimeString != null && datetimeString.length() >= 10) {
	        String dateString = datetimeString.substring(0, 10);
	        acpdto.setUse_dt(dateString);
	    } else {
	    	acpdto.setUse_dt(null);
	    }
	    
	    
	    System.out.println("������ ���� �ѱ������ Ȯ�� : "+ acpdto.toString());
		int result = service.insertAbizCarPerson(acpdto);
		if(result == 1) {
			return ResponseEntity.ok().body("insert success");
		} else {
			
			return ResponseEntity.ok().body("insert failed");
		}
	}
	
	@GetMapping("/searchcarforabizperson")
	public ResponseEntity<List<AbizCarPersonDTO>> findallbycar (@RequestParam String car_cd){
		System.out.println("findallbycarȣ��........");
		System.out.println(car_cd);
		List<AbizCarPersonDTO> dto = service.findallbycar(car_cd);
		
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
		
	}
	
}
