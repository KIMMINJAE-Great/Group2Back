package com.dz.back.ace.ace1000.ace1010.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
//	Test 데이터 가져오기
	@GetMapping("/getallcars")
	public ResponseEntity<List<AbizCarPersonDTO>> getallcars(){
		List<AbizCarPersonDTO> dto = service.getallcars();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
		
	}
	
//	운행 구분
	@GetMapping("/usefg")
	public ResponseEntity<List<UseFgDTO>> usefg(){
		List<UseFgDTO> dto = service.usefg();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}
	
//	마감 유무
	@GetMapping("/sendyn")
	public ResponseEntity<List<SendYnDTO>> sendyn(){
		List<SendYnDTO> dto = service.sendyn();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}
	
	
//	출발,도착 구분
	@GetMapping("/startendfg")
	public ResponseEntity<List<StartEndFgDTO>> startendfg(){
		List<StartEndFgDTO> dto = service.startendfg();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}
	
}
