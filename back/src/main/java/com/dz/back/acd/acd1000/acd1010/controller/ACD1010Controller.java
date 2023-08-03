package com.dz.back.acd.acd1000.acd1010.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.acd.acd1000.acd1010.serviceImpl.ACD1010ServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/regcar")
public class ACD1010Controller {

	@Autowired
	ACD1010ServiceImpl acd1010ServiceImpl;
	
	
	
	@GetMapping("/cardlist")
    public ResponseEntity<List<CarDTO>> getAllData() {

        List<CarDTO> list = acd1010ServiceImpl.getAllCarRegInfo();
        System.out.println("카드리스트"+list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
	
	
}
