package com.dz.back.ace.ace1000.ace1010.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.dz.back.ace.ace1000.ace1010.dao.ACE1010DAO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarBookmarkDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AutoCalcMileageDTO;
import com.dz.back.ace.ace1000.ace1010.dto.DeleteRequestAbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AperStartaccInfoDTO;
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
	
	@Autowired
	ACE1010DAO dao;

	private String car_cd;

//	Test 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
	@GetMapping("/getallcars")
	public ResponseEntity<List<AbizCarPersonDTO>> getallcars() {
		List<AbizCarPersonDTO> dto = service.getallcars();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);

	}

//	占쏙옙占쏙옙 占쏙옙占쏙옙
	@GetMapping("/usefg")
	public ResponseEntity<List<UseFgDTO>> usefg() {
		List<UseFgDTO> dto = service.usefg();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}

//	占쏙옙占쏙옙 占쏙옙占쏙옙
	@GetMapping("/sendyn")
	public ResponseEntity<List<SendYnDTO>> sendyn() {
		List<SendYnDTO> dto = service.sendyn();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}

//	占쏙옙占�,占쏙옙占쏙옙 占쏙옙占쏙옙
	@GetMapping("/startendfg")
	public ResponseEntity<List<StartEndFgDTO>> startendfg() {
		List<StartEndFgDTO> dto = service.startendfg();
		System.out.println(dto.toString());
		return ResponseEntity.ok().body(dto);
	}

//	 占쏙옙占쏙옙占싹븝옙 占쌉뤄옙
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody AbizCarPersonDTO dto) {
		System.out.println("占쌓싷옙 占쏙옙占쏙옙........... : " + dto.toString());

//		占쌉뤄옙 占쏙옙占쏙옙占쏙옙 占시곤옙 占쌩븝옙 占쏙옙 占쏙옙占쏙옙占쏙옙짜 占쌉뤄옙 占쏙옙占쏙옙
		String checkTimeResult = service.checkUseDtAndStartTime(dto);
		if (checkTimeResult.equals("before data exist")) {
			return ResponseEntity.ok().body("before data exist");
		} else if (checkTimeResult.equals("same time data exist")) {
			return ResponseEntity.ok().body("same time data exist");
		}

//		insert占싹깍옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 AbbizcarpersonDTO 占쏙옙占쏙옙
		AbizCarPersonDTO acpdto = dto;
		System.out.println(dto.getCar_cd());

//	占쏙옙占쏙옙占쏙옙 seq_nb占쏙옙 占쌍대값占쏙옙 占쏙옙占쏙옙占쏙옙 +1 占쏙옙占쌍깍옙
		int seqnb = service.findMaxSeqNb(dto.getCar_cd());
		seqnb++;
		acpdto.setSeq_nb(seqnb);

// use_dt 占쏙옙짜 占쏙옙占쏙옙 占쏙옙占쏙옙	    
		String datetimeString = dto.getUse_dt();
		if (datetimeString != null && datetimeString.length() >= 10) {
			String dateString = datetimeString.substring(0, 10);
			acpdto.setUse_dt(dateString);
		} else {
			acpdto.setUse_dt(null);
		}
		if (acpdto.getEnd_fg().isEmpty() || acpdto.getStart_fg().isEmpty()) {
			return ResponseEntity.ok().body("Required value not entered");
		}
		System.out.println("占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占싼깍옙占쏙옙占쏙옙占� 확占쏙옙 : " + acpdto.toString());
		int result = service.insertAbizCarPerson(acpdto);
		if (result == 1) {
			return ResponseEntity.ok().body("insert success");
		} else {

			return ResponseEntity.ok().body("insert failed");
		}
	}

	@PostMapping("/selectedCopy")
	public ResponseEntity<String> selectedCopy(@RequestBody List<AbizCarPersonDTO> requestData) {
	    System.out.println("Received requestData: " + requestData);

	    for (AbizCarPersonDTO dto : requestData) {
	        int seqnb = service.findMaxSeqNb(dto.getCar_cd());
	        seqnb++;
	        dto.setSeq_nb(seqnb);

	        System.out.println("seqnb : " + seqnb);
	        
	        String datetimeString = dto.getUse_dt();
	        if (datetimeString != null && datetimeString.length() >= 10) {
	        	String dateString = datetimeString.substring(0, 10);
	            dto.setUse_dt(dateString);
	            System.out.println("dateString : " + dateString);
	        } else {
	            System.out.println("null 이 나올수가 없음@@@@@@@@@");
	        }

	        int result = service.insertAbizCarPerson(dto);
	        System.out.println("result : " + result);
	    }
	    

	    return ResponseEntity.ok().body("insert success");
        

//		if (dataList.size() == 3) {
//			String startDatetimeString = (String) dataList.get(1);
//			System.out.println("startDatetimeString : " + startDatetimeString);
//
//			String endDatetimeString = (String) dataList.get(2);
//			System.out.println("endDatetimeString : " + endDatetimeString);
//
//			if (startDatetimeString != null && startDatetimeString.length() >= 10) {
//				String startDatetimeString1 = startDatetimeString.substring(0, 10);
//				dto.setUse_dt(startDatetimeString1);
//				System.out.println("startDatetimeString1 : " + startDatetimeString1);
//
//			} else {
//				System.out.println("null �씠 �굹�삱�닔媛� �뾾�쓬@@@@@@@@@");
//			}
//
//		}
//		int result = service.insertAbizCarPerson(dto);
//		System.out.println("result :" + result);

	}

//	占쏙옙占쏙옙占싹븝옙 占쏙옙占쏙옙
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody AbizCarPersonDTO dto) {
		System.out.println("占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙");
		System.out.println(dto.toString());
//		占쌉뤄옙 占쏙옙占쏙옙占쏙옙 占시곤옙 占쌩븝옙 占쏙옙 占쏙옙占쏙옙占쏙옙짜 占쌉뤄옙 占쏙옙占쏙옙
		String checkTimeResult = service.checkUseDtAndStartTime(dto);
		if (checkTimeResult.equals("before data exist")) {
			return ResponseEntity.ok().body("before data exist");
		} else if (checkTimeResult.equals("same time data exist")) {
			return ResponseEntity.ok().body("same time data exist");
		} else if (checkTimeResult.equals("same time exist at working row")) {
			System.out.println("占쌩븝옙占실는곤옙 占쌍억옙占� 占쏙옙占쏙옙占승곤옙");
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
		System.out.println("占쏙옙 占쏙옙占싸거억옙 " + result);
		System.out.println(finalDto.toString());
		if (result == 1) {
			return ResponseEntity.ok().body("update success");
		} else {
			return ResponseEntity.ok().body("update failed");
		}
	}

//	占쏙옙占쏙옙占싹븝옙 占쏙옙회
	@GetMapping("/searchcarforabizperson")
	public ResponseEntity<?> findallbycar(@RequestParam String car_cd, @RequestParam String startDate,
			@RequestParam String endDate) {
		System.out.println("findallbycar호占쏙옙........");

		System.out.println(car_cd);

		CarDTO cdto = regcarService.findCar(car_cd);
		System.out.println(cdto);

		if (cdto == null) {
			return ResponseEntity.ok().body("not found");
		} else if (cdto.getUse_yn().equals("N")) {
			return ResponseEntity.ok().body("not using");
		} else {

			List<AbizCarPersonDTO> dto = service.findallbycar(car_cd, startDate, endDate);
			//int startacc = service.getstartaccfordivision(dto.get(0).getCar_cd());
			if (dto == null || dto.isEmpty()) {
				dto = new ArrayList<>(); // 占쏙옙占쏙옙트 占십깍옙화
				AbizCarPersonDTO newDto = new AbizCarPersonDTO();
				newDto.setEmp_cd(cdto.getEmp_cd());
				newDto.setCo_cd(cdto.getCo_cd());
				newDto.setCar_cd(cdto.getCar_cd());
				dto.add(newDto); // 占쏙옙占싸울옙 DTO 占쏙옙체占쏙옙 占쏙옙占쏙옙트占쏙옙 占쌩곤옙
			} else {
				for (AbizCarPersonDTO item : dto) {
					item.setEmp_cd(cdto.getEmp_cd());
					item.setCo_cd(cdto.getCo_cd());
					item.setCar_cd(cdto.getCar_cd());
				}
			}
			
			System.out.println("처占쏙옙 占쌀뤄옙占시띰옙");
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
	


//	占싫분울옙 占쏙옙占쏙옙占� 占쏙옙占십거몌옙 占쏙옙占쏙옙占쏙옙占쏙옙
	@GetMapping("/getstartaccfordivision")
	public ResponseEntity<Integer> getstartaccfordivision(@RequestParam String car_cd){
		
		int result = service.getstartaccfordivision(car_cd);
		
		return ResponseEntity.ok().body(result);
	}
	
	
//	占쏙옙占쏙옙占쏙옙 占싫븝옙 占쏙옙占� 
	@PostMapping("/savedivisiondistance")
	public ResponseEntity<?> savedivisiondistance(@RequestBody List<AutoCalcMileageDTO> dto){
		System.out.println("占싫븝옙 占쏙옙트占싼뤄옙");
		System.out.println(dto.toString());
			int result = service.savedivisiondistance(dto);
		return ResponseEntity.ok().body(result);
	}
	/* �슫�뻾湲곕줉遺� - 湲곗큹嫄곕━ �엯�젰 - Tabel aper_startacc_info */
	@PostMapping("/insertStartaccKm")
	public int insertStartaccKm(@RequestBody AperStartaccInfoDTO aperStartaccInfoDTO) {

		String co_cd = aperStartaccInfoDTO.getCo_cd();
		String car_cd = aperStartaccInfoDTO.getCar_cd();
		String startacc_km = aperStartaccInfoDTO.getStartacc_km();

		System.out.println("co_cd :" + co_cd);
		System.out.println("car_cd :" + car_cd);
		System.out.println("startacc_km :" + startacc_km);

		int result = service.checkAperStart(aperStartaccInfoDTO);
		System.out.println("result : " + result);

		if (result == 0) {
			String insert_id = aperStartaccInfoDTO.getInsert_id();
			System.out.println("insert_id :" + insert_id);
			int test = service.insertStartaccKm(aperStartaccInfoDTO);
		} else if (result == 1) {
			String modify_id = aperStartaccInfoDTO.getModify_id();
			System.out.println("modify_id :" + modify_id);
			service.updateStartaccKm(aperStartaccInfoDTO);
			return result;
		}
		return result;
	}

	/* �슫�뻾湲곕줉遺� - 湲곗큹嫄곕━ �엯�젰 - Tabel aper_startacc_info */
	@PostMapping("/selectStartaccKm")
	public ResponseEntity<Map<String, Object>> selectStartaccKm(@RequestBody Map<String, String> requestData) {
	    String car_cd = requestData.get("car_cd");
	    System.out.println("car_cd : " + car_cd);

	    // car_cd瑜� �궗�슜�븯�뿬 startacc_km�쓣 �뜲�씠�꽣踰좎씠�뒪�뿉�꽌 議고쉶�븯�뒗 �옉�뾽 �닔�뻾
	    String startaccKm = service.selectStartaccKm(car_cd); // �삁�떆濡� 硫붿냼�뱶 �씠由꾩� selectStartaccKmByCarCd�씪 媛��젙
	    
	    Map<String, Object> response = new HashMap<>();
	    response.put("startacc_km", startaccKm);

	    return ResponseEntity.ok().body(response);
	}
	
	
	
//	 즐겨찾기 입력
	@PostMapping("/insertbookmark")
	public ResponseEntity<String> insertbookmark(@RequestBody List<AbizCarBookmarkDTO> dto) {
		System.out.println("�ך� ����........... : " + dto.toString());



		List<AbizCarBookmarkDTO> bookmarks = dto;
		System.out.println(bookmarks);
		

		int result = service.insertBookmark(bookmarks);
		
		if (result == 1) {
			return ResponseEntity.ok().body("insert success");
		} else {

			return ResponseEntity.ok().body("insert failed");
		}
	}
//즐겨찾기 수정
	 @PutMapping("/updatebookmark")
	 public ResponseEntity<String> updatebookmark(@RequestBody AbizCarBookmarkDTO dto) {
		 System.out.println("������ ��ü ���Դ�?");
		 
		 AbizCarBookmarkDTO cdto = dto;
		 
		 int result = service.updateBookmark(cdto);
			System.out.println(result);
			if (result == 1) {
				return ResponseEntity.ok().body("update success");
			} else {
				return ResponseEntity.ok().body("update failed");
			}
		 
		 
	 }
	
	//즐겨찾기 조회
	@GetMapping("/abizbookmark")
	public ResponseEntity<?> findallbookmark(@RequestParam String emp_cd,@RequestParam String co_cd){
		
		List<AbizCarBookmarkDTO> dto = service.findallbookmark(emp_cd);
		if(dto == null || dto.isEmpty()) {
			dto = new ArrayList<>(); // ����Ʈ �ʱ�ȭ
			AbizCarBookmarkDTO newDto = new AbizCarBookmarkDTO();
			newDto.setEmp_cd(emp_cd);
			newDto.setCo_cd(co_cd);
			dto.add(newDto); // ���ο� dto ��ü�� ����Ʈ�� �߰�
			
		}else {
			for(AbizCarBookmarkDTO item : dto) {
				item.setEmp_cd(emp_cd);
				item.setCo_cd(co_cd);
			}
		}

		System.out.println(dto);
		
		return ResponseEntity.ok().body(dto);
	}
	
	//즐겨찾기 출발지에서 회사,자택 조회
	@GetMapping("/bookmarkstartfg")
	public ResponseEntity<AbizCarBookmarkDTO> bookmarkstartfg(@RequestParam String emp_cd,@RequestParam String co_cd,@RequestParam String start_fg){
		
		AbizCarBookmarkDTO dto = service.bookmarkstartfg(emp_cd,co_cd,start_fg);
		
		return ResponseEntity.ok().body(dto);
	}
	
	//즐겨찾기 도착지에서 회사,자택 조회
		@GetMapping("/bookmarkendfg")
		public ResponseEntity<AbizCarBookmarkDTO> bookmarkendfg(@RequestParam String emp_cd,@RequestParam String co_cd,@RequestParam String end_fg){
			
			AbizCarBookmarkDTO dto = service.bookmarkendfg(emp_cd,co_cd,end_fg);
			
			return ResponseEntity.ok().body(dto);
		}

	
	
	
}
