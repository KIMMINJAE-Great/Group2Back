package com.dz.back.controller;

import java.sql.Date;
import java.time.Instant;
import java.time.ZonedDateTime;
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

import com.dz.back.dto.EmpDTO;
import com.dz.back.security.CustomUserDetailsService;
import com.dz.back.service.EmpService;
import com.dz.back.serviceimpl.EmpServiceImpl;
//import com.dz.back.serviceimpl.EmpServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpServiceImpl empService;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
		
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody EmpDTO empDTO) {
		System.out.println("EmpController 실행.........." + empDTO.toString());
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		EmpDTO edto = empService.getEmp(empDTO.getEmp_id());
		
		if (edto == null) {
			System.out.println("edto가 널 일때");
			return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);
		} else  {
			System.out.println("edto가 널이 아닐때");
			String rawPassword = empDTO.getPassword(); 
			String encodedPassword = edto.getPassword(); 
			Boolean isMatch = bcryptPasswordEncoder.matches(rawPassword, encodedPassword); 
			if (isMatch == false) {
				return new ResponseEntity<>("password not found", HttpStatus.NOT_FOUND);
			} else {
				UserDetails eDTO = customUserDetailsService.loadUserByUsername(empDTO.getEmp_id());
				return new ResponseEntity<>(eDTO, HttpStatus.OK);
			}
		}
		
	}
	

	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request) {
		System.out.println("logout실행.......");
		SecurityContextHolder.getContext().setAuthentication(null);
		// HTTP �꽭�뀡 臾댄슚�솕
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return ResponseEntity.ok().body("Logged out");
	}
	
// 카드리스트로 보낼 전 사원 검색
	@GetMapping("/cardlist")
	public ResponseEntity<List <EmpDTO>> readCardList(){
		List<EmpDTO> cardList =	empService.readCardList();
		return ResponseEntity.ok().body(cardList);
	}
//	사원 검색
	@GetMapping("/empsearch")
	public ResponseEntity<List<EmpDTO>> empSearch(@RequestParam(required=false) String company, 
	                                              @RequestParam(required=false) String status, 
	                                              @RequestParam(required=false) String nameIdEmail) {
	    System.out.println("empSeach실행............");
	    List<EmpDTO> empSearchList;
	    if(company == "" && status=="" && nameIdEmail == "") {
	    	empSearchList = empService.readCardList();
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
	    
	    EmpDTO empSearch = new EmpDTO();
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
	public ResponseEntity<?> register(@RequestBody EmpDTO empDTO ){
	    
	    // 클라이언트로부터 받은 값 출력
	    System.out.println("resiter........... : "+empDTO.toString());
	    
	    
	    //empcd 가져오기
	    String empCd = empDTO.getEmp_cd();
	    
	    //클라이언트로 보낼 DTO 만들기
	    EmpDTO finEmpDTO = empDTO;
	    
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
	        
	        int num = Integer.parseInt(autoCempCd.substring(4));
	        num++;   
	        autoCempCd = String.format("%06d", num);
	        
	        
	        finEmpDTO.setEmp_cd(empDTO.getCo_cd()+autoCempCd);
	        
	        empService.register(finEmpDTO);
	        empService.rolseSetUser(finEmpDTO.getEmp_id());
	        System.out.println("자동채번 : " +finEmpDTO);
	        return ResponseEntity.ok().body(finEmpDTO);
	         
	//  empCd 값이 있을때
	    } else {

	//  emp_cd중복검사
	        EmpDTO empCdCheck =  empService.validEmpCd(empCd);
	        if(empCdCheck != null){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("exist emp_cd");
	        } else {
	            empService.register(finEmpDTO);
	            empService.rolseSetUser(finEmpDTO.getEmp_id());
	            return ResponseEntity.ok().body(finEmpDTO);
	        }               
	    }       
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody EmpDTO empDTO ){
		System.out.println("update 실행............");
		System.out.println(empDTO.toString());
		
		if(empService.updateEmp(empDTO) == 1) {
			return ResponseEntity.ok().body("update success");
		} else {
			return ResponseEntity.ok().body("update failed");
		}
	}
	
//	카드 클릭시 정보가져오기
	@PostMapping("/getEmpCard")
	public ResponseEntity<EmpDTO> getEmpCard(@RequestBody Map<String,String> emp_cd){
		EmpDTO dto = empService.getEmpCard(emp_cd.get("emp_cd"));
		return ResponseEntity.ok().body(dto);
	}
	
//	사원 삭제
	@DeleteMapping("/delete/{emp_cd}")
	public void empDelete(@PathVariable String emp_cd) {
		EmpDTO dto = empService.getEmpCard(emp_cd);
		System.out.println("이엠피 아이디................. "+dto.getEmp_id());
		empService.deleteAuth(dto.getEmp_id());
		empService.deleteEmp(emp_cd);
	}
	
}
