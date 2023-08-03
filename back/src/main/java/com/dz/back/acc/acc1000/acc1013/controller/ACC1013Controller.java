package com.dz.back.acc.acc1000.acc1013.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@PostMapping("/companyreg")
//	public ResponseEntity<Object> CompanyTestSearch(@RequestBody ComDTO comDTO) {
//	    System.out.println("/company 뿌셔 TestCode 실행됨");
//	    companyregServiceImpl.getConm(comDTO.getCo_cd());
//	    return new ResponseEntity<>("회사등록에서 처리되는 코드..작업중.. 지속적 업데이트 셿쌰 삤궎", HttpStatus.OK);
//	}
	
	//companyreg 가 실행되면 카드리스트한테 보내야함 (select 로 전부가져오기)
	@GetMapping("/cardlist")
    public ResponseEntity<List<ComDTO>> getAllData() {

        List<ComDTO> list = acc1013ServiceImpl.getAllComRegInfo();
        System.out.println("카드리스트"+list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
	
	//companyreg/save 저장코드 (존재시 업데이트, 없을시 저장)
	@PostMapping("/save")
	public ResponseEntity<Object> ComRegSave(@RequestBody ComDTO comDTO) {
		System.out.println("/companyreg/save 실행");
		System.out.println("받은 직후 co_cd는?"+comDTO.getCo_cd());
//		companyregServiceImpl.getComRegInfoByCocd(comDTO.getCo_cd());
		
		
		System.out.println("실행이전:" +comDTO);
		acc1013ServiceImpl.saveComRegInfo(comDTO);
		System.out.println("실행이후"+comDTO);
		return new ResponseEntity<>("SCO 테이블에 회사정보 등록완료",HttpStatus.OK);
	}
	
	//companyreg/delete 삭제코드
	@PostMapping("/delete")
	public ResponseEntity<Object> ComRegDelete(@RequestBody ComDTO comDTO) {
		System.out.println("/companyreg/delete 실행");
		System.out.println(comDTO.getCo_cd());
		acc1013ServiceImpl.deleteComRegInfoByCocd(comDTO.getCo_cd());
		return new ResponseEntity<>("SCO 테이블에서 회사정보 삭제 완료",HttpStatus.OK);
	}
	
	
	//companyreg/search 카드리스트에 회사코드로 조회(회사등록 textfield에 넣기)
	@PostMapping("/selectCard")
	public ResponseEntity<Object> SelectCard(@RequestBody ComDTO comDTO) {
		
		String co_cd = comDTO.getCo_cd();
		List<ComDTO> result = acc1013ServiceImpl.getComRegInfoByCocd(co_cd);
		System.out.println("result= "+result);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
//	//update 코드 (회사 정보로)
//	@PostMapping("/update")
//	public ResponseEntity<Object> UpdateCard(@RequestBody ComDTO comDTO) {
//		
//		String co_cd = comDTO.getCo_cd();
//		companyregServiceImpl.updateComRegInfoByCocd(co_cd);
//		
//		return new ResponseEntity<>("업데이트 완료",HttpStatus.OK);
//	}
}
