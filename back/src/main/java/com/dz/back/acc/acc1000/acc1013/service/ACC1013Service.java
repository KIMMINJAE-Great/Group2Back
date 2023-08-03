package com.dz.back.acc.acc1000.acc1013.service;

import java.util.List;

import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;

public interface ACC1013Service {
	//회사코드로 회사이름 가져오기
		 List<ComDTO> getComRegInfoByCocd(String co_cd) ;
		
		//저장코드!!!!
		 void saveComRegInfo(ComDTO comDTO);
			
		//삭제코드!!!
		void deleteComRegInfoByCocd(String co_cd);
		
		
		//회사정보 다가져오기
		 List<ComDTO> getAllComRegInfo();
		
}
