package com.dz.back.acc.acc1000.acc1013.mapper;

import java.util.List;

import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;



public interface ACC1013Mapper {
	//민재 코드 예시로 사용하기
//	void login();
//	void register(EmpDTO empDTO);
//	EmpDTO getEmpByUsername(String username);
//	public EmpDTO read(String username);
//	List<MauthDTO> readMauthList(String emp_cd);
	
		// 회사코드를 넣고 삭제를 누르면 회사정보가 삭제되는 코드
		void deleteComRegInfoByCocd(String co_cd);
		
		// 텍스트필드에 입력한 값들 전부를 SCO 테이블에 저장하는 코드
		void saveComRegInfo(ComDTO comDTO);
		
		//코드 이름으로 회사정보 전부 가져오는 코드
		List<ComDTO> getComRegInfoByCocd(String co_cd); // 회사 이름을 회사코드로 가져오는 
		
		//select 회사에 있는 테이블 정보 다 불러옴
		List<ComDTO> getAllComRegInfo();
		
		//update co_cd로 where co_cd = 회사코드 로 전부 업데이트 
		void updateComRegInfoByCocd(ComDTO comDTO);
		
		//부서코드카피
		ComDTO getStByCode(String co_cd);
}
