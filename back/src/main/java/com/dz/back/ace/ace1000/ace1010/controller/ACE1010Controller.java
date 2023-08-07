package com.dz.back.ace.ace1000.ace1010.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.service.ACE1010Service;

@RestController
@RequestMapping("/ace1010")
@CrossOrigin(origins="*")
public class ACE1010Controller {
	
	@Autowired
	private ACE1010Service service;
	
	@GetMapping("/getallcars")
	public ResponseEntity<List<AbizCarPersonDTO>> getallcars(){
		List<AbizCarPersonDTO> dto = service.getallcars();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
		
	}
}
