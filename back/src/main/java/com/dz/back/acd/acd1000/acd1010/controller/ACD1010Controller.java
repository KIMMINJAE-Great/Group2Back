package com.dz.back.acd.acd1000.acd1010.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.acd.acd1000.acd1010.serviceImpl.ACD1010ServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/regcar")
public class ACD1010Controller {

	@Autowired
	ACD1010ServiceImpl regcarService;

	@GetMapping("/cardlist")
	public ResponseEntity<List<CarDTO>> getCardCarList() {
		List<CarDTO> carCardList = regcarService.getCardCarList();
		System.out.println(carCardList);
		return ResponseEntity.ok(carCardList);
	}

//	카드 클릭시 정보가져오기
	@PostMapping("/getRegcarCard")
	public ResponseEntity<CarDTO> getEmpCard(@RequestBody Map<String, String> car_cd) {
		CarDTO dto = regcarService.getRegcarCard(car_cd.get("car_cd"));
		return ResponseEntity.ok().body(dto);

	}

	// 카드 추가
	@PostMapping("/addcar")
	public ResponseEntity<CarDTO> addRegCar(@RequestBody CarDTO dto) {

		int result = regcarService.addRegCar(dto);
		System.out.println(result);
		if (result == 1) {
			System.out.println(dto);
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// 카드 추가
	@PutMapping("/updatecar")
	public ResponseEntity<CarDTO> updateRegCar(@RequestBody CarDTO dto) {

		int result = regcarService.updateRegCar(dto);
		System.out.println(result);
		if (result == 1) {
			System.out.println(dto);
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//카드 삭제
		@DeleteMapping("/deletecar/{car_cd}")
		public void deleteRegCar(@PathVariable String car_cd) {
			regcarService.deleteRegCar(car_cd);
		}
		
		
		//체크박스가 선택되었을때 한꺼번에 삭제하기
		 @DeleteMapping("/deletecar")
		    public void deleteCheckedCar(@RequestBody List<CarDTO> CarList) {
		        for (CarDTO car : CarList) {

		        	regcarService.deleteRegCar(car.getCar_cd());
		        }
		    }

}
