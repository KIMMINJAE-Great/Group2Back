package com.dz.back.acc.acc1000.acc1011.service;

import java.util.List;

import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;

public interface ACC1011Service {
	
	List<DeptDTO> getCardDeptList();//카드리스트 가져오기
    DeptDTO getCardDept(String dept_cd); //카드 값 가져오기
    int addDept(DeptDTO dto);            // 카드 추가
    void deleteDept(String dept_cd);     // 카드 삭제
    int updateDept(DeptDTO dto); //카드 수정
    List<DeptDTO> deptSearch(DeptDTO deptSearch);
	

}
