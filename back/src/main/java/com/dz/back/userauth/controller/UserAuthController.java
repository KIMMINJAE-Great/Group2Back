package com.dz.back.userauth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.userauth.dto.EmpDTO;
import com.dz.back.security.CustomUserDetailsService;
import com.dz.back.userauth.service.UserAuthService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class UserAuthController {

	@Autowired
	private UserAuthService userAuthService;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody EmpDTO empDTO) {
		System.out.println("EmpController 실행.........." + empDTO.toString());
		// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		EmpDTO edto = userAuthService.getEmp(empDTO.getEmp_id());
//		System.out.println(edto.getEmp_resi());
		if (edto == null) {
			System.out.println("edto가 널 일때");
			return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);
		}

		else if (edto.getEmp_resi() != null) {
			System.out.println("퇴사");
			return new ResponseEntity<>("cant use this id", HttpStatus.FORBIDDEN);
		}

		else {
			System.out.println("edto가 널이 아닐때");
			String rawPassword = empDTO.getPassword();
			String encodedPassword = edto.getPassword();
			Boolean isMatch = bcryptPasswordEncoder.matches(rawPassword, encodedPassword);
			if (isMatch == false) {
				return new ResponseEntity<>("password not found", HttpStatus.NOT_FOUND);
			} else {
				UserDetails eDTO = customUserDetailsService.loadUserByUsername(empDTO.getEmp_id());
				System.out.println("마지막 회원정보 넘기기 직전");
				System.out.println(eDTO.toString());
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
}
