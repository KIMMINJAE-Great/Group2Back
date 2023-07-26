package com.dz.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.dto.TradeManagementDTO;
import com.dz.back.service.TradeManagementService;
import com.dz.back.serviceimpl.TradeManagementImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tradeManagement")
public class TradeManagementController {

	private final SqlSessionTemplate sqlSession; // SqlSessionTemplate ����

	@Autowired
	private TradeManagementImpl tradeManagementService;

	@Autowired
	public TradeManagementController(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	@PostMapping("/getSearchData")
	public ResponseEntity<Object> getSearchData(@RequestBody TradeManagementDTO tradeManagementDTO) {
	    System.out.println("TradeManagementController ����.." + tradeManagementDTO.toString());

	    Map<String, Object> searchMap = new HashMap<>();
	    searchMap.put("bp_classification", tradeManagementDTO.getBp_classification());
	    searchMap.put("bp_code", tradeManagementDTO.getBp_code());
	    searchMap.put("bp_name", tradeManagementDTO.getBp_name());

	    System.out.println(searchMap);

	    // MyBatis�� ���� SQL ������ �����ϰ� ����� �޾ƿ�
	    List<TradeManagementDTO> result = sqlSession.selectList("getSearchData", searchMap);
	    System.out.println(result);

	    if (result != null && !result.isEmpty()) {
	        return ResponseEntity.ok(result);
	    } else {
	        return ResponseEntity.noContent().build();
	    }
	}

	
	@PostMapping("/insertData")
	public ResponseEntity<Object> insertData(@RequestBody TradeManagementDTO tradeManagementDTO) {
		System.out.println("TradeManagementController ����.." + tradeManagementDTO.toString());
		 System.out.println("/tradeManagement/insertData �����");
		 
		 tradeManagementService.insertData(tradeManagementDTO);
	      
	      return new ResponseEntity<>("SCO ���̺� ȸ������ ��ϿϷ�",HttpStatus.OK);

	}
}
