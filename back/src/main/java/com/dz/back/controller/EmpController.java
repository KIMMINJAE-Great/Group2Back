package com.dz.back.controller;

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

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody EmpDTO empDTO) {
		System.out.println("EmpController 실행.........." + empDTO.toString());
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
		
	}
	
	@PostMapping("/register")
	public String empReg(@RequestBody EmpDTO empDTO) {
		System.out.println(empDTO.toString());
		// empService.register(empDTO);
		return "Register Success";
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request) {
		System.out.println("logout실행.......");
		SecurityContextHolder.getContext().setAuthentication(null);
		// HTTP 세션 무효화
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return ResponseEntity.ok().body("Logged out");
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}

}
