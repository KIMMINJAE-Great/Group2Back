package com.dz.back.acc.acc1000.acc1013.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acc.acc1000.acc1013.serviceimpl.ACC1013ServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/company")
public class ACC1013Controller {

	@Autowired
	private ACC1013ServiceImpl acc1013ServiceImpl;
	

	
	//companyreg 가 실행되면 카드리스트한테 보내야함 (select 로 전부가져오기)
	@GetMapping("/cardlist")
    public ResponseEntity<?> getAllData() {
		try {
		    List<ComDTO> list = acc1013ServiceImpl.getAllComRegInfo();
		    System.out.println("카드리스트"+list);
		    if(list.isEmpty()) {
		    	return new ResponseEntity<>("데이터가 없습니다.", HttpStatus.NO_CONTENT);
		    }		    
		    return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (DataAccessException e) {
	        // 데이터베이스 예외 처리
	        return new ResponseEntity<>("데이터베이스 오류가 발생", HttpStatus.INTERNAL_SERVER_ERROR);
	    } catch (Exception ex) {
	        // 기타 예외 처리
	        return new ResponseEntity<>("오류가 발생.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
    }
	
	//companyreg/save 저장코드 (존재시 업데이트, 없을시 저장)
	@PostMapping("/save")
	public ResponseEntity<Object> ComRegSave(@RequestBody ComDTO comDTO) {
		System.out.println("/companyreg/save 실행");
		System.out.println("받은 직후 co_cd는?"+comDTO.getCo_cd());
//		companyregServiceImpl.getComRegInfoByCocd(comDTO.getCo_cd());
		
		ComDTO dto = comDTO;
		System.out.println("dto 내용물 한번 보기" +dto.toString());
		String datetimeString = comDTO.getEst_dt();
		String datetimeString2 = comDTO.getOpn_dt();
		String datetimeString3 = comDTO.getCls_dt();
		String datetimeString4 = comDTO.getAc_dt();
		
		 if (datetimeString != null && datetimeString.length() >= 10) {
		        String dateString = datetimeString.substring(0, 10);
		        dto.setEst_dt(dateString);
		    } else {
		    	dto.setEst_dt(null);
		    }
		 if (datetimeString2 != null && datetimeString2.length() >= 10) {
		        String dateString2 = datetimeString2.substring(0, 10);
		        dto.setOpn_dt(dateString2);
		    } else {
		    	dto.setOpn_dt(null);
		    }
		 if (datetimeString3 != null && datetimeString3.length() >= 10) {
		        String dateString3 = datetimeString3.substring(0, 10);
		        dto.setCls_dt(dateString3);
		    } else {
		    	dto.setCls_dt(null);
		    }
		 if (datetimeString4 != null && datetimeString4.length() >= 10) {
		        String dateString4 = datetimeString4.substring(0, 10);
		        dto.setAc_dt(dateString4);
		    } else {
		    	dto.setAc_dt(null);
		    }
		 
		 
		System.out.println("실행이전:" +comDTO);
		boolean isSaved = acc1013ServiceImpl.saveComRegInfo(dto);
		System.out.println("실행이후"+comDTO);
		if(isSaved) {
	        return new ResponseEntity<>("SCO 테이블에 회사정보 등록완료", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("회사 정보 저장에 실패// 중복 키 위반 또는 기타 데이터 무결성 문제", HttpStatus.BAD_REQUEST);
	    }
	}
	
	//companyreg/delete/{co_cd} 삭제코드
	@DeleteMapping("/delete/{co_cd}")
	public void ComRegDelete(@PathVariable String co_cd) {
		System.out.println("/companyreg/delete 실행");
		acc1013ServiceImpl.deleteComRegInfoByCocd(co_cd);
		
	}
	
	//체크박스가 선택되었을때 한꺼번에 삭제하기(객체가 여러개 담겨있을땐 이게 실행됨)
		 @DeleteMapping("/delete")
		    public void deleteCheckedCoCd(@RequestBody List<ComDTO> comList) {
		        for (ComDTO com : comList) {
		        	System.out.println(com.getCo_cd());
		        	acc1013ServiceImpl.deleteComRegInfoByCocd(com.getCo_cd());
		        }
		    }
	
	
	//companyreg/search 카드리스트에 회사코드로 조회(회사등록 textfield에 넣기)
//	@PostMapping("/selectCard")
//	public ResponseEntity<Object> SelectCard(@RequestBody ComDTO comDTO) {
//		
//		String co_cd = comDTO.getCo_cd();
//		List<ComDTO> result = acc1013ServiceImpl.getComRegInfoByCocd(co_cd);
//		System.out.println("result= "+result);
//		return new ResponseEntity<>(result,HttpStatus.OK);
//	}
	@PostMapping("/selectCard")
	public ResponseEntity<ComDTO> SelectCard(@RequestBody Map<String, String> co_cd) {
		
		ComDTO scCard = acc1013ServiceImpl.getCardSt(co_cd.get("co_cd"));
		
		return ResponseEntity.ok(scCard);
	}
	
	//update 코드 (회사 정보로)
	@PutMapping("/update")
	public ResponseEntity<ComDTO> UpdateCard(@RequestBody ComDTO comDTO) {
		ComDTO dto = comDTO;
		System.out.println("dto 내용물 한번 보기" +dto.toString());
		String datetimeString = comDTO.getEst_dt();
		String datetimeString2 = comDTO.getOpn_dt();
		String datetimeString3 = comDTO.getCls_dt();
		String datetimeString4 = comDTO.getAc_dt();
		 if (datetimeString != null && datetimeString.length() >= 10) {
		        String dateString = datetimeString.substring(0, 10);
		        dto.setEst_dt(dateString);
		    } else {
		    	dto.setEst_dt(null);
		    }
		 if (datetimeString2 != null && datetimeString2.length() >= 10) {
		        String dateString2 = datetimeString2.substring(0, 10);
		        dto.setOpn_dt(dateString2);
		    } else {
		    	dto.setOpn_dt(null);
		    }
		 if (datetimeString3 != null && datetimeString3.length() >= 10) {
		        String dateString3 = datetimeString3.substring(0, 10);
		        dto.setCls_dt(dateString3);
		    } else {
		    	dto.setCls_dt(null);
		    }
		 if (datetimeString4 != null && datetimeString4.length() >= 10) {
		        String dateString4 = datetimeString4.substring(0, 10);
		        dto.setAc_dt(dateString4);
		    } else {
		    	dto.setAc_dt(null);
		    }
		acc1013ServiceImpl.updateComRegInfoByCocd(dto);
		
		return ResponseEntity.ok().build();
	}
}
