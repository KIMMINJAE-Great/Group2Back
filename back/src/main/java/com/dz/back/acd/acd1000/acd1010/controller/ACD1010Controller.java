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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@GetMapping("/carsearch")
    public ResponseEntity<List<CarDTO>> carSearch(@RequestParam(required = false) String lease_yn) {

        List<CarDTO> carSearchList;
        if (lease_yn == "" || lease_yn.equals("all")) {
            carSearchList = regcarService.getCardCarList();
        } else {
        	if(lease_yn != null && lease_yn.isEmpty()) {
        		lease_yn = null;
        	}

            if (lease_yn != null) {
                if (lease_yn.isEmpty()) {
                	lease_yn = null;
                } else if (lease_yn.equals("owned")) {
                	lease_yn = "1";
                }else if (lease_yn.equals("rented")) {
                	lease_yn = "2";
                }else if (lease_yn.equals("leased")) {
                	lease_yn = "3";
            }}

            CarDTO carSearch = new CarDTO();
            carSearch.setLease_yn(lease_yn);
            carSearchList = regcarService.carSearch(carSearch);
        }
        return ResponseEntity.ok().body(carSearchList);
    }

//	카占쏙옙 클占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
	@PostMapping("/getRegcarCard")
	public ResponseEntity<CarDTO> getEmpCard(@RequestBody Map<String, String> car_cd) {
		CarDTO dto = regcarService.getRegcarCard(car_cd.get("car_cd"));
		return ResponseEntity.ok().body(dto);

	}
	
	@PostMapping("/getCarsInfo")
	public ResponseEntity<String> getCarsInfo() {
	    List<CarDTO> carCardList = regcarService.getCardCarList();

	    // �씠�쟾�뿉�뒗 carCardList瑜� CarDTO濡� 罹먯뒪�똿�븯�젮怨� �뻽�쑝�굹, �씠�젣�뒗 由ъ뒪�듃�쓽 �슂�냼瑜� 媛��졇���빞 �빀�땲�떎.
	    if (!carCardList.isEmpty()) {
	        CarDTO carDTO = carCardList.get(0);

	        String abizcarNBNM = carDTO.getCar_nb() + '.' + carDTO.getCar_nm();

	        CarDTO responseDTO = new CarDTO();
	        responseDTO.setAbizcarNBNM(abizcarNBNM);
	        System.out.println("getCarsInfo �떎�뻾 !!!!!!!!");
	        System.out.println("responseDTO :" + responseDTO);
	        System.out.println("abizcarNBNM :" + abizcarNBNM);

	        return ResponseEntity.ok().body(abizcarNBNM);
	    } else {
	        // 留뚯빟 carCardList媛� 鍮꾩뼱�엳�떎硫� 泥섎━�븷 �궡�슜�쓣 �뿬湲곗뿉 異붽��븯�꽭�슂.
	        return ResponseEntity.notFound().build();
	    }
	}


	// 카占쏙옙 占쌩곤옙
	@PostMapping("/addcar")
	public ResponseEntity<CarDTO> addRegCar(@RequestBody CarDTO dto) {
		
		
		 // 원본형식에서 처음부터 10자리까지만 잘라서 
	    String GetDt = dto.getGet_dt().substring(0, 10);
	    String DisposalDt = dto.getDisposal_dt().substring(0, 10);
	    String LfrDt = dto.getLfr_dt().substring(0, 10);
	    String LtoDt = dto.getLto_dt().substring(0, 10);
	    String IfrDt = dto.getIfr_dt().substring(0, 10);
	    String ItoDt = dto.getIto_dt().substring(0, 10);

	    // 날짜를 자른 값으로 DTO 수정
	    dto.setGet_dt(GetDt);
	    dto.setDisposal_dt(DisposalDt);
	    dto.setLfr_dt(LfrDt);
	    dto.setLto_dt(LtoDt);
	    dto.setIfr_dt(IfrDt);
	    dto.setIto_dt(ItoDt);
	    
		

		int result = regcarService.addRegCar(dto);
		System.out.println(result);
		if (result == 1) {
			System.out.println(dto);
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// 카占쏙옙 占쌩곤옙
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
	
	//카占쏙옙 占쏙옙占쏙옙
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
