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

//	ī�� Ŭ���� ������������
	@PostMapping("/getRegcarCard")
	public ResponseEntity<CarDTO> getEmpCard(@RequestBody Map<String, String> car_cd) {
		CarDTO dto = regcarService.getRegcarCard(car_cd.get("car_cd"));
		return ResponseEntity.ok().body(dto);

	}
	
	@PostMapping("/getCarsInfo")
	public ResponseEntity<String> getCarsInfo() {
	    List<CarDTO> carCardList = regcarService.getCardCarList();

	    // 이전에는 carCardList를 CarDTO로 캐스팅하려고 했으나, 이제는 리스트의 요소를 가져와야 합니다.
	    if (!carCardList.isEmpty()) {
	        CarDTO carDTO = carCardList.get(0);

	        String abizcarNBNM = carDTO.getCar_nb() + '.' + carDTO.getCar_nm();

	        CarDTO responseDTO = new CarDTO();
	        responseDTO.setAbizcarNBNM(abizcarNBNM);
	        System.out.println("getCarsInfo 실행 !!!!!!!!");
	        System.out.println("responseDTO :" + responseDTO);
	        System.out.println("abizcarNBNM :" + abizcarNBNM);

	        return ResponseEntity.ok().body(abizcarNBNM);
	    } else {
	        // 만약 carCardList가 비어있다면 처리할 내용을 여기에 추가하세요.
	        return ResponseEntity.notFound().build();
	    }
	}


	// ī�� �߰�
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

	// ī�� �߰�
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
	
	//ī�� ����
		@DeleteMapping("/deletecar/{car_cd}")
		public void deleteRegCar(@PathVariable String car_cd) {
			regcarService.deleteRegCar(car_cd);
		}
		
		
		//üũ�ڽ��� ���õǾ����� �Ѳ����� �����ϱ�
		 @DeleteMapping("/deletecar")
		    public void deleteCheckedCar(@RequestBody List<CarDTO> CarList) {
		        for (CarDTO car : CarList) {

		        	regcarService.deleteRegCar(car.getCar_cd());
		        }
		    }

}
