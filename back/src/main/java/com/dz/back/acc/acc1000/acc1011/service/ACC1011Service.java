package com.dz.back.acc.acc1000.acc1011.service;

import java.util.List;

import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;

public interface ACC1011Service {
	
	List<DeptDTO> getCardDeptList();//ī�帮��Ʈ ��������
	DeptDTO getCardDept(String dept_cd); //ī�� �� ��������
	int addDept(DeptDTO dto);            // ī�� �߰�
	void deleteDept(String dept_cd);     // ī�� ����
//	void updateDept
	

}
