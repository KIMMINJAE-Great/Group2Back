package com.dz.back.acc.acc1000.acc1012.controller;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1012.serviceimpl.ACC1012Serviceimpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tradeManagement")
public class ACC1012Controller {

	private final SqlSessionTemplate sqlSession; // SqlSessionTemplate

	@Autowired
	private ACC1012Serviceimpl acc1012Service;

	@Autowired
	public ACC1012Controller(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@PostMapping("/getst")
	public ResponseEntity<TradeManagementDTO> getCardSt(@RequestBody Map<String, String> tr_cd) {

		System.out.println(tr_cd);

		TradeManagementDTO stCard = acc1012Service.getCardSt(tr_cd.get("tr_cd"));
		System.out.println(stCard);

		return ResponseEntity.ok(stCard);
	}

	/* 검색한 값들만 카드리스트로 보여주기 - (거래처구분, 거래처코드, 거래처명) */
	@GetMapping("/getSearchData")
	public ResponseEntity<List<TradeManagementDTO>> getSearchData(@RequestParam(required = false) String tr_cd,
			@RequestParam(required = false) String tr_nm, @RequestParam(required = false) String tr_fg) {

		if (tr_cd == null & tr_cd.isEmpty()) {
			tr_cd = null;
		}
		if (tr_nm == null & tr_nm.isEmpty()) {
			tr_nm = null;
		}
		if (tr_fg == null & tr_nm.isEmpty()) {
			tr_fg = null;
		}
		TradeManagementDTO dto = new TradeManagementDTO();
		dto.setTr_cd(tr_cd);
		dto.setTr_fg(tr_fg);
		dto.setTr_nm(tr_nm);

		List<TradeManagementDTO> searchDataList = acc1012Service.getSearchData(dto);
		System.out.println("/tradeManagement/getSearchData  실행!!!!!!");
		System.out.println(searchDataList);

		return ResponseEntity.ok().body(searchDataList);
	}

	/* 카드리스트 데이터 보내기 */
	@GetMapping
	public ResponseEntity<List<TradeManagementDTO>> getCardStList() {

		List<TradeManagementDTO> stCardlist = acc1012Service.getCardStList();
		System.out.println(stCardlist);

		return ResponseEntity.ok(stCardlist);
	}

	/* 거래처관리 - 기본등록사항 저장 - INSERT */
	@PostMapping("/insertSt")
	public ResponseEntity<Object> insertSt(@RequestBody TradeManagementDTO tradeManagementDTO) {
		System.out.println("/tradeManagement/insertSt 실행됨");

		String maxTrcd = acc1012Service.getMaxTrcd();
		System.out.println(maxTrcd);
		int value;
		try {
			value = Integer.parseInt(maxTrcd);
			value++;
			// value 변수에 정수값으로 변환된 결과가 저장됨
		} catch (NumberFormatException e) {
			// 숫자로 변환할 수 없는 경우 예외 처리
			return ResponseEntity.badRequest().body("Invalid input format.");
		}
		maxTrcd = String.format("%010d", value);
		System.out.println(maxTrcd);

		tradeManagementDTO.setTr_cd(maxTrcd);
		tradeManagementDTO.setCo_cd("1000");

		int result = acc1012Service.insertStData(tradeManagementDTO);

		System.out.println(result);
		return (result == 1) ? ResponseEntity.ok(tradeManagementDTO)
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	/* 거래처관리 - 기본등록사항 삭제 - DELETE */
	@DeleteMapping("/deleteSt/{tr_cd}")
	public ResponseEntity<Object> deleteSt(@PathVariable String tr_cd) {
		System.out.println("/tradeManagement/deleteSt 실행됨");
		acc1012Service.deleteStData(tr_cd);

		return ResponseEntity.ok().build();
	}

	/* 거래처관리 - 기본등록사항 수정 - UPDATE */
	@PutMapping("/updateSt")
	public ResponseEntity<Object> updateSt(@RequestBody TradeManagementDTO tradeManagementDTO) {
		System.out.println("/tradeManagement/updateSt 실행됨");
		acc1012Service.updateStData(tradeManagementDTO);

		return ResponseEntity.ok().build();
	}
}
