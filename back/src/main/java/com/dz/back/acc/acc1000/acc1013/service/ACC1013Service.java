package com.dz.back.acc.acc1000.acc1013.service;

import java.util.List;

import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;

public interface ACC1013Service {
	//ȸ���ڵ�� ȸ���̸� ��������
		 List<ComDTO> getComRegInfoByCocd(String co_cd) ;
		
		//�����ڵ�!!!!
		 void saveComRegInfo(ComDTO comDTO);
			
		//�����ڵ�!!!
		void deleteComRegInfoByCocd(String co_cd);
		
		
		//ȸ������ �ٰ�������
		 List<ComDTO> getAllComRegInfo();
		
}
