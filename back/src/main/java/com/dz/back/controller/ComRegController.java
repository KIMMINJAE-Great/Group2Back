package com.dz.back.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.dto.ComDTO;

import com.dz.back.serviceimpl.CompanyregServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/company")
public class ComRegController {

	@Autowired
	private CompanyregServiceImpl companyregServiceImpl;
	
//	//companyreg �뿉�꽌 post濡� 蹂대궪寃�
//	@PostMapping("/companyreg")
//	public ResponseEntity<Object> CompanyTestSearch(@RequestBody ComDTO comDTO) {
//		System.out.println("/company �뿉�꽌 TestCode �떎�뻾�맖");
//		companyregServiceImpl.getConm(comDTO.getCo_cd());
//		return new ResponseEntity<>("�뀒�뒪�듃�뿉�꽌 �꽌移섑븯�뒗 肄붾뱶�씤�뜲..�옉�룞���븞�븿 �뿬�듉.. �젒�냽�셿猷� �삤�궎",HttpStatus.OK);
//	}
	
	//companyreg 가 실행되면 카드리스트한테 보내야함
	@GetMapping("/cardlist")
    public ResponseEntity<List<ComDTO>> getAllData() {
		System.out.println("/companyreg 에서 CompanyReadCard를 가져오기 위한 쿼리문 실행됨");
        List<ComDTO> list = companyregServiceImpl.getAllComRegInfo();
        System.out.println(list+"/cardlist 실행");

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
	
	//companyreg/save 저장코드
	@PostMapping("/save")
	public ResponseEntity<Object> ComRegSave(@RequestBody ComDTO comDTO) {
		System.out.println("/companyreg/save 실행");
		companyregServiceImpl.saveComRegInfo(comDTO);
		return new ResponseEntity<>("SCO 테이블에 회사정보 등록완료",HttpStatus.OK);
	}
	
	//companyreg/delete 삭제코드
	@PostMapping("/delete")
	public ResponseEntity<Object> ComRegDelete(@RequestBody ComDTO comDTO) {
		System.out.println("/companyreg/delete 실행");
		System.out.println(comDTO.getCo_cd());
		companyregServiceImpl.deleteComRegInfoByCocd(comDTO.getCo_cd());
		return new ResponseEntity<>("SCO 테이블에서 회사정보 삭제 완료",HttpStatus.OK);
	}
	
	
	//companyreg/search 카드리스트에 회사코드로 전부 가져오기
	@PostMapping("/selectCard")
	public ResponseEntity<Object> SelectCard(@RequestBody ComDTO comDTO) {
		
		String co_cd = comDTO.getCo_cd();
		List<ComDTO> result = companyregServiceImpl.getComRegInfoByCocd(co_cd);
		System.out.println("result= "+result);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
	
	/*
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody EmpDTO empDTO) {
		System.out.println("EmpController �떎�뻾.........." + empDTO.toString());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		EmpDTO edto = empService.getEmp(empDTO.getEmp_id());
		
		if (edto == null) {
			return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);
		} else  {
			String rawPassword = empDTO.getPassword(); 
			String encodedPassword = edto.getPassword(); 
			Boolean isMatch = encoder.matches(rawPassword, encodedPassword); 
			if (isMatch == false) {
				return new ResponseEntity<>("password not found", HttpStatus.NOT_FOUND);
			} else {
				UserDetails eDTO = customUserDetailsService.loadUserByUsername(empDTO.getEmp_id());
				return new ResponseEntity<>(eDTO, HttpStatus.OK);
			}
		}
		*/
}
