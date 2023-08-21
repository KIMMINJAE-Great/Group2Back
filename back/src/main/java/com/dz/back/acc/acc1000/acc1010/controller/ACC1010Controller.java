package com.dz.back.acc.acc1000.acc1010.controller;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
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

import com.dz.back.security.CustomUserDetailsService;
import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.dto.ACC1010MauthDTO;
import com.dz.back.acc.acc1000.acc1010.dto.MenuDTO;
import com.dz.back.acc.acc1000.acc1010.service.ACC1010Service;
import com.dz.back.acc.acc1000.acc1010.serviceimpl.ACC1010Serviceimpl;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.commons.Commons;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/emp")
public class ACC1010Controller {

	@Autowired
	private ACC1010Service empService;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
		
// 카드리스트로 보낼 전 사원 검색
	@GetMapping("/cardlist")
	public ResponseEntity<List <ACC1010EmpDTO>> readCardList(){
		List<ACC1010EmpDTO> cardList =	empService.readCardList();
		return ResponseEntity.ok().body(cardList);
	}
//	사원 검색
	@GetMapping("/empsearch")
	public ResponseEntity<List<ACC1010EmpDTO>> empSearch(@RequestParam(required=false) String company, 
	                                              @RequestParam(required=false) String status, 
	                                              @RequestParam(required=false) String nameIdEmail) {
	    System.out.println("empSeach실행............");
	    List<ACC1010EmpDTO> empSearchList;
//	    전사원 가져오기
	    if(company == "" && status=="" && nameIdEmail == "") {
	    	empSearchList = empService.readCardList();
//	    	조회 조건에 따른 사원들 가져오기
	    }else {
	    if(company != null && company.isEmpty()) {
	        company = null;
	    }
	    
	    if(nameIdEmail != null && nameIdEmail.isEmpty()) {
	        nameIdEmail = null;
	    }
	    
	    // 재직 상태에 따라 적절한 값으로 변경
	    if(status != null) {
	        if(status.isEmpty() || status.equals("ing")) {
	            status = "IS NULL";
	        } else if(status.equals("done")) {
	            status = "IS NOT NULL";
	        }
	    }
	    
	    ACC1010EmpDTO empSearch = new ACC1010EmpDTO();
	    empSearch.setCo_cd(company);
	    empSearch.setEmp_resi(status);
	    empSearch.setEmp_id(nameIdEmail);
	    empSearch.setEmp_nm(nameIdEmail);
	    
	    
	   
	    	
	    	empSearchList  = empService.empSearch(empSearch);
	    }
	    return ResponseEntity.ok().body(empSearchList);
	}
	
//신규 사원 등록
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody ACC1010EmpDTO empDTO ){
		System.out.println("사원 등록 실행........");
		System.out.println("empID.......... : " + empDTO.getEmp_id());
		int check = empService.checkEmpId(empDTO.getEmp_id());
		System.out.println("check........ : " + check);
		if( check == 1) {
			return new ResponseEntity<>("이미 존재하는 로그인 ID입니다. 다시 한번 확인해주세요.", HttpStatus.BAD_REQUEST);
		}
	    // 클라이언트로부터 받은 값 출력
	    System.out.println("resiter........... : "+empDTO.toString());
	    
	    
	    //empcd 가져오기
	    String empCd = empDTO.getEmp_cd();
	    
	    //클라이언트로 보낼 DTO 만들기
	    ACC1010EmpDTO finEmpDTO = empDTO;
	    
	    //입사일 포맷 변화
	    String datetimeString = empDTO.getEmp_hrd();
	    if (datetimeString != null && datetimeString.length() >= 10) {
	        String dateString = datetimeString.substring(0, 10);
	        finEmpDTO.setEmp_hrd(dateString);
	    } else {
	    	 finEmpDTO.setEmp_hrd(null);
	    }
	    
	    //비밀번호 암호화
	    String encodePw = bcryptPasswordEncoder.encode(empDTO.getPassword());
	    finEmpDTO.setPassword(encodePw);
	    
	    
	    // empCd 값이 비었을 때
	    if(empCd == "") {
	        // 자동 채번
	        String autoCempCd = empService.searchEmpCd(empDTO.getCo_cd());
	        
	        System.out.println("autoCempCd...................." + autoCempCd);
//	        만약 네자리수로 입력되어 있는 사원번호가 있다면 아래의 앞에서 4자리를 잘라내는것 때문에 다시 000001부터 시작해서 duplicate 오류발생
	        int num =0 ;
	        if(autoCempCd.length() == 10) {
	        	num = Integer.parseInt(autoCempCd.substring(4));
	        	num++;   
	        } else  {
	        	num++;
	        }
	         
	       
	        autoCempCd = String.format("%06d", num);
	        
	        
	        finEmpDTO.setEmp_cd(empDTO.getCo_cd()+autoCempCd);
	        
	        System.out.println(finEmpDTO.getEmp_cd());
	        
	        empService.register(finEmpDTO);
	        empService.rolesSetUser(finEmpDTO.getEmp_id());
	        System.out.println("자동채번 : " +finEmpDTO);
	        return ResponseEntity.ok().body(finEmpDTO);
	         
	//  empCd 값이 있을때
	    } else {

	//  emp_cd중복검사
	        ACC1010EmpDTO empCdCheck =  empService.validEmpCd(empCd);
	        if(empCdCheck != null){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("exist emp_cd");
	        } else {
	            empService.register(finEmpDTO);
	            empService.rolesSetUser(finEmpDTO.getEmp_id());
	            return ResponseEntity.ok().body(finEmpDTO);
	        }               
	    }       
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody ACC1010EmpDTO empDTO ){
		System.out.println("update 실행............");
		System.out.println(empDTO.toString());
		
		
		ACC1010EmpDTO finEmpDTO = empDTO;
	    String datetimeString = empDTO.getEmp_hrd();
	    if (datetimeString != null && datetimeString.length() >= 10) {
	        String dateString = datetimeString.substring(0, 10);
	        finEmpDTO.setEmp_hrd(dateString);
	    } else {
	    	 finEmpDTO.setEmp_hrd(null);
	    }
		
		
		if(empService.updateEmp(empDTO) == 1) {
			return ResponseEntity.ok().body("update success");
		} else {
			return ResponseEntity.ok().body("update failed");
		}
	}
	
//	카드 클릭시 정보가져오기
	@PostMapping("/getEmpCard")
	public ResponseEntity<ACC1010EmpDTO> getEmpCard(@RequestBody Map<String,String> emp_cd){
		ACC1010EmpDTO dto = empService.getEmpCard(emp_cd.get("emp_cd"));
		return ResponseEntity.ok().body(dto);
		
		
	}

	
//	사원 삭제
	@DeleteMapping("/delete/{emp_cd}")
	public void empDelete(@PathVariable String emp_cd) {
		ACC1010EmpDTO dto = empService.getEmpCard(emp_cd);
		System.out.println("이엠피 아이디................. "+dto.getEmp_id());
		
		ACC1010MauthDTO dto2 = new ACC1010MauthDTO();
		dto2.setEmpcd(emp_cd);
		empService.deleteMauth(dto2);
		empService.deleteAuth(dto.getEmp_id());
		empService.deleteEmp(emp_cd);
	}
	
	//체크박스가 선택되었을때 한꺼번에 삭제하기
		 @DeleteMapping("/delete")
		    public void deleteCheckedEmp(@RequestBody List<ACC1010EmpDTO> empList) {
			 
			    ACC1010MauthDTO dto2 = new ACC1010MauthDTO();
			 
			 
		        for (ACC1010EmpDTO emp : empList) {
		        	 	empService.deleteEmp(emp.getEmp_cd());
		        	 	
		        	 	dto2.setEmpcd(emp.getEmp_cd());
		        	 	empService.deleteMauth(dto2);
		        	 	empService.deleteAuth(emp.getEmp_id());
		        	 	empService.deleteEmp(emp.getEmp_cd());
		        	 	
		        	 	
		        	
		        }
		    }
	
	
//	카드에서 사원의 메뉴권한 요청
	@GetMapping("/getmauth/{emp_cd}")
	public ResponseEntity<List<ACC1010MauthDTO>> getmauth(@PathVariable String emp_cd){
		 List<ACC1010MauthDTO> dto = empService.getMauth(emp_cd);
		return ResponseEntity.ok().body(dto);
	}
	
//	메뉴 권한 등록
	@PostMapping("/insertmauth")
	public ResponseEntity<?> insertMauth(@RequestBody ACC1010MauthDTO dto, HttpServletRequest request){
		System.out.println("insertmauth 실행............");
		System.out.println(dto.getEmpcd());
//		IP 가져오기
		String clientIP = Commons.getClientIP(request);
		System.out.println("menucd......... " +dto.getMenucd());
		MenuDTO mdto =  empService.searchMenu(dto.getMenucd());
		
		System.out.println("ip............"+clientIP);
		System.out.println("mdto......... : "+ mdto);
		
		ACC1010MauthDTO mauthDTO = new ACC1010MauthDTO();
		mauthDTO.setCocd(mdto.getCo_cd());
		mauthDTO.setMenucd(mdto.getMenu_cd());
		mauthDTO.setMenunm(mdto.getMenu_nm());
		mauthDTO.setUrl(mdto.getUrl());
		mauthDTO.setMgroupcd(mdto.getMgroup_cd());
		mauthDTO.setMgroupnm(mdto.getMgroup_nm());
		mauthDTO.setInsertid(dto.getInsertid());
		mauthDTO.setEmpcd(dto.getEmpcd());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String now_dt = format.format(now);
		System.out.println(now_dt);
		
		mauthDTO.setInsertdt(now_dt);
	
		
		int result = empService.insertMauth(mauthDTO);
		
		if(result ==1) {
			
			return ResponseEntity.ok().body("메뉴권한 등록 완료");
			} else {
				return new ResponseEntity<>("메뉴 권한 등록 실패", HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping("/deletemauth/{empcd}/{menucd}")
	public void deleteMauth(@PathVariable String empcd, @PathVariable String menucd) {
		System.out.println("deleteMauth 실행..........");
		ACC1010MauthDTO dto = new ACC1010MauthDTO();
		dto.setEmpcd(empcd);
		dto.setMenucd(menucd);
		empService.deleteMauth(dto);
	}
	
}
