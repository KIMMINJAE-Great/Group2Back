package com.dz.back.service;

import java.util.List;

import com.dz.back.dto.DeptDTO;

public interface DeptService {
	
	List<DeptDTO> getCardDeptList();//카드리스트 가져오기
	DeptDTO getCardDept(String dept_cd); //카드 값 가져오기
	int addDept(DeptDTO dto);            // 카드 추가
	void deleteDept(String dept_cd);     // 카드 삭제
//	void updateDept
	

}
