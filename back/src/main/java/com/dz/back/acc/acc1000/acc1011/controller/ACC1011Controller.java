package com.dz.back.acc.acc1000.acc1011.controller;

import java.util.List;
import java.util.Map;

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

import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1011.service.ACC1011Service;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/depmanagement")
public class ACC1011Controller {

	@Autowired
	private ACC1011Service deptService;

	// 모든 카드리스트 목록 가져오기
	@GetMapping
	public ResponseEntity<List<DeptDTO>> getCardDeptList() {

		List<DeptDTO> deptCardlist = deptService.getCardDeptList();

		return ResponseEntity.ok(deptCardlist);
	}
	
	@GetMapping("/deptsearch")
    public ResponseEntity<List<DeptDTO>> deptSearch(@RequestParam(required = false) String company,
            @RequestParam(required = false) String status) {

        List<DeptDTO> deptSearchList;
        if (company == "" && status == "") {
            deptSearchList = deptService.getCardDeptList();
        } else {
            if (company != null && company.isEmpty()) {
                company = null;
            }


            if (status != null) {
                if (status.isEmpty()) {
                    status = null;
                }else if (status.equals("account")) {
                    status = "회계과";

                } else if (status.equals("humanresource")) {
                    status = "인사과";
                }else if (status.equals("planning")) {
                    status = "기획과";
                }else if (status.equals("sales")) {
                    status = "영업과";
            }}

            DeptDTO deptSearch = new DeptDTO();
            deptSearch.setCo_cd(company);
            deptSearch.setDept_st(status);
            deptSearchList = deptService.deptSearch(deptSearch);
        }
        return ResponseEntity.ok().body(deptSearchList);
    }
	
	
//	카드 클릭시 정보가져오기
	@PostMapping("/getdept")
	public ResponseEntity<DeptDTO> getCardDept(@RequestBody Map<String, String> dept_cd) {

		System.out.println(dept_cd);

		DeptDTO deptCard = deptService.getCardDept(dept_cd.get("dept_cd"));
		System.out.println(deptCard);

		return ResponseEntity.ok(deptCard);
	}
//카드 추가
	@PostMapping("/adddept")
	public ResponseEntity<DeptDTO> addCardDept(@RequestBody DeptDTO dto) {

		int result = deptService.addDept(dto);
		System.out.println(result);
		if (result == 1) {
			System.out.println(dto);
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	//카드 삭제
	@DeleteMapping("/deletedept/{dept_cd}")
	public void deleteCardDept(@PathVariable String dept_cd) {
		deptService.deleteDept(dept_cd);
	}
	
	//체크박스가 선택되었을때 한꺼번에 삭제하기
	 @DeleteMapping("/deletedept")
	    public void deleteCheckedDept(@RequestBody List<DeptDTO> deptList) {
	        for (DeptDTO dept : deptList) {
	        	System.out.println(dept.getDept_cd());
	            deptService.deleteDept(dept.getDept_cd());
	        }
	    }
	
	
	
	
	@PutMapping("/updatedept")
    public ResponseEntity<DeptDTO> updateCardDept(@RequestBody DeptDTO dto) {
        System.out.println(dto);

        int result = deptService.updateDept(dto);
        System.out.println(result);
        if (result == 1) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

	
}
