package com.dz.back.ace.ace1000.ace1010.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.dto.ACC1010MauthDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.acd.acd1000.acd1010.serviceImpl.ACD1010ServiceImpl;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AutoCalcMileageDTO;
import com.dz.back.ace.ace1000.ace1010.dto.DeleteRequestAbizCarPersonDTO;
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

//		입력 데이터 시간 중복 및 이전날짜 입력 방지
		String checkTimeResult = service.checkUseDtAndStartTime(dto);
		if(checkTimeResult.equals("before data exist")) {
			return ResponseEntity.ok().body("before data exist");
		} else if(checkTimeResult.equals("same time data exist")) {
			return ResponseEntity.ok().body("same time data exist");
		}

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
		System.out.println(dto.toString());
//		입력 데이터 시간 중복 및 이전날짜 입력 방지
		String checkTimeResult = service.checkUseDtAndStartTime(dto);
		if(checkTimeResult.equals("before data exist")) {
			return ResponseEntity.ok().body("before data exist");
		} else if(checkTimeResult.equals("same time data exist")) {
			return ResponseEntity.ok().body("same time data exist");
		} else if(checkTimeResult.equals("same time exist at working row")) {
			System.out.println("중복되는게 있어야 나오는거");
			return ResponseEntity.ok().body("same time exist at working row");
		}
		
		AbizCarPersonDTO finalDto = dto;
		String datetimeString = dto.getUse_dt();
		if (datetimeString != null && datetimeString.length() >= 10) {
			String dateString = datetimeString.substring(0, 10);
			finalDto.setUse_dt(dateString);
		} else {
			finalDto.setUse_dt(null);
		}

		int result = service.updateAbizCarPerson(finalDto);
		System.out.println("엥 몇인거야 " + result);
		System.out.println(finalDto.toString());
		if (result == 1) {
			return ResponseEntity.ok().body("update success");
		} else {
			return ResponseEntity.ok().body("update failed");
		}
	}

//	운행기록부 조회
	@GetMapping("/searchcarforabizperson")
	public ResponseEntity<?> findallbycar(@RequestParam String car_cd,@RequestParam String startDate, @RequestParam String endDate) {
		System.out.println("findallbycar호출........");

		System.out.println(car_cd);

		CarDTO cdto = regcarService.findCar(car_cd);
		System.out.println(cdto);
	
		if (cdto == null) {
			return ResponseEntity.ok().body("not found");
		} else if (cdto.getUse_yn().equals("N") ) {
			return ResponseEntity.ok().body("not using");
		} else {
			
			List<AbizCarPersonDTO> dto = service.findallbycar(car_cd, startDate, endDate);
			//int startacc = service.getstartaccfordivision(dto.get(0).getCar_cd());
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
	
	@DeleteMapping("/deleteabizcarperson")
	public ResponseEntity<Integer> deleteAbizcarPerson(@RequestBody List<DeleteRequestAbizCarPersonDTO> dto){
		
//	
	        	int result = service.deleteAbizcarPerson(dto);
	        	
        	return ResponseEntity.ok().body(result);
		
	      
	}

	@PostMapping("/autocalcmileage") 
	public ResponseEntity<Integer> updateAutoCalcMileage (@RequestBody AutoCalcMileageDTO dto){
		System.out.println(dto.toString());
		
		int result = service.updateAutoCalcMileage(dto);
		
			return ResponseEntity.ok().body(result);
		
	}
	


//	안분에 사용할 기초거리 가져오기
	@GetMapping("/getstartaccfordivision")
	public ResponseEntity<Integer> getstartaccfordivision(@RequestParam String car_cd){
		
		int result = service.getstartaccfordivision(car_cd);
		
		return ResponseEntity.ok().body(result);
	}
	
	
//	운행기록 안분 계산 
	@PostMapping("/savedivisiondistance")
	public ResponseEntity<?> savedivisiondistance(@RequestBody List<AutoCalcMileageDTO> dto){
		System.out.println("안분 컨트롤러");
		System.out.println(dto.toString());
			int result = service.savedivisiondistance(dto);
		return ResponseEntity.ok().body(result);
	}
}
