package com.dz.back.controller;

import java.sql.Date;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println("EmpController �떎�뻾.........." + empDTO.toString());
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		EmpDTO edto = empService.getEmp(empDTO.getEmp_id());
		System.out.println("edto............. : "+edto.toString());
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
		System.out.println("logout�떎�뻾.......");
		SecurityContextHolder.getContext().setAuthentication(null);
		// HTTP �꽭�뀡 臾댄슚�솕
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return ResponseEntity.ok().body("Logged out");
	}

	@GetMapping("/cardlist")
	public ResponseEntity<List <EmpDTO>> readCardList(){
		List<EmpDTO> cardList =	empService.readCardList();
		return ResponseEntity.ok().body(cardList);
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
		String dateString = datetimeString.substring(0, 10);
			
//비밀번호 암호화
		String encodePw = bcryptPasswordEncoder.encode(empDTO.getPassword());
		
		finEmpDTO.setEmp_hrd(dateString);
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
			 
//	empCd 값이 있을때
		} else {

//	emp_cd중복검사
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
	
}
