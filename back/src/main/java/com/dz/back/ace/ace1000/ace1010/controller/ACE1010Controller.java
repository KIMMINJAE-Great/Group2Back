package com.dz.back.ace.ace1000.ace1010.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.acd.acd1000.acd1010.serviceImpl.ACD1010ServiceImpl;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.SendYnDTO;
import com.dz.back.ace.ace1000.ace1010.dto.StartEndFgDTO;
import com.dz.back.ace.ace1000.ace1010.dto.UseFgDTO;
import com.dz.back.ace.ace1000.ace1010.service.ACE1010Service;

@RestController
@RequestMapping("/ace1010")
@CrossOrigin(origins = "*")
public class ACE1010Controller {

	@Autowired
	private ACE1010Service service;

	@Autowired
	ACD1010ServiceImpl regcarService;

//	Test 데이터 가져오기
	@GetMapping("/getallcars")
	public ResponseEntity<List<AbizCarPersonDTO>> getallcars() {
		List<AbizCarPersonDTO> dto = service.getallcars();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);

	}

//	운행 구분
	@GetMapping("/usefg")
	public ResponseEntity<List<UseFgDTO>> usefg() {
		List<UseFgDTO> dto = service.usefg();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}

//	마감 유무
	@GetMapping("/sendyn")
	public ResponseEntity<List<SendYnDTO>> sendyn() {
		List<SendYnDTO> dto = service.sendyn();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}

//	출발,도착 구분
	@GetMapping("/startendfg")
	public ResponseEntity<List<StartEndFgDTO>> startendfg() {
		List<StartEndFgDTO> dto = service.startendfg();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}

//	 운행기록부 입력
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody AbizCarPersonDTO dto) {
		System.out.println("테슽 실행........... : " + dto.toString());

//		insert하기위해 가공할 AbbizcarpersonDTO 생성
		AbizCarPersonDTO acpdto = dto;
		System.out.println(dto.getCar_cd());

//	차량의 seq_nb의 최대값을 가져와 +1 해주기
		int seqnb = service.findMaxSeqNb(dto.getCar_cd());
		seqnb++;
		acpdto.setSeq_nb(seqnb);

// use_dt 날짜 형태 변경	    
		String datetimeString = dto.getUse_dt();
		if (datetimeString != null && datetimeString.length() >= 10) {
			String dateString = datetimeString.substring(0, 10);
			acpdto.setUse_dt(dateString);
		} else {
			acpdto.setUse_dt(null);
		}
		if(acpdto.getEnd_fg().isEmpty() || acpdto.getStart_fg().isEmpty() ) {
			return ResponseEntity.ok().body("Required value not entered");
		}
		System.out.println("마지막 서비스 넘기기전에 확인 : " + acpdto.toString());
		int result = service.insertAbizCarPerson(acpdto);
		if (result == 1) {
			return ResponseEntity.ok().body("insert success");
		} else {

			return ResponseEntity.ok().body("insert failed");
		}
	}

//	운행기록부 수정
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody AbizCarPersonDTO dto) {
		System.out.println("업데이트 시작");
		AbizCarPersonDTO fdto = dto;
		String datetimeString = dto.getUse_dt();
		if (datetimeString != null && datetimeString.length() >= 10) {
			String dateString = datetimeString.substring(0, 10);
			fdto.setUse_dt(dateString);
		} else {
			fdto.setUse_dt(null);
		}

		int result = service.updateAbizCarPerson(fdto);
		System.out.println("엥 몇인거야 " + result);
		System.out.println(fdto.toString());
		if (result == 1) {
			return ResponseEntity.ok().body("update success");
		} else {
			return ResponseEntity.ok().body("update failed");
		}
	}

//	운행기록부 조회
	@GetMapping("/searchcarforabizperson")
	public ResponseEntity<?> findallbycar(@RequestParam String car_cd) {
		System.out.println("findallbycar호출........");

		System.out.println(car_cd);

		CarDTO cdto = regcarService.findCar(car_cd);
	
		if (cdto == null) {
			return ResponseEntity.ok().body("not found");
		} else if (cdto.getUse_yn().equals("N") ) {
			return ResponseEntity.ok().body("not using");
		} else {
			List<AbizCarPersonDTO> dto = service.findallbycar(car_cd);

			if (dto == null || dto.isEmpty()) {
				dto = new ArrayList<>(); // 리스트 초기화
				AbizCarPersonDTO newDto = new AbizCarPersonDTO();
				newDto.setEmp_cd(cdto.getEmp_cd());
				newDto.setCo_cd(cdto.getCo_cd());
				newDto.setCar_cd(cdto.getCar_cd());
				dto.add(newDto); // 새로운 DTO 객체를 리스트에 추가
			} else {
				for (AbizCarPersonDTO item : dto) {
					item.setEmp_cd(cdto.getEmp_cd());
					item.setCo_cd(cdto.getCo_cd());
					item.setCar_cd(cdto.getCar_cd());
				}
			}

			System.out.println("처음 불러올때");
			System.out.println(dto.toString());
			return ResponseEntity.ok().body(dto);
		}

	}

}
