package com.dz.back.service;

import java.util.List;

import com.dz.back.dto.DeptDTO;

public interface DeptService {
	
	List<DeptDTO> getCardDeptList();//ī�帮��Ʈ ��������
	DeptDTO getCardDept(String dept_cd); //ī�� �� ��������
	int addDept(DeptDTO dto);            // ī�� �߰�
	void deleteDept(String dept_cd);     // ī�� ����
//	void updateDept
	

}
