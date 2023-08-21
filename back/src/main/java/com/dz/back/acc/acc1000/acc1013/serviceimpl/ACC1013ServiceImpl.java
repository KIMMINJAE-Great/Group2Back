package com.dz.back.acc.acc1000.acc1013.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1013.dao.ACC1013DAO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;


@Service
public class ACC1013ServiceImpl {

	@Autowired
	private ACC1013DAO acc1013dao;

	//회사코드로 회사이름 가져오기
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {	
		return acc1013dao.getComRegInfoByCocd(co_cd);
	}
	
	//저장코드!!!! (저장/업데이트) (회사코드가 비어있다는것은 아무것도 입력안했을 때..라고 가정)
	public boolean saveComRegInfo(ComDTO comDTO) {
		try {
			acc1013dao.saveComRegInfo(comDTO);
			return true;
			//데이터무결성 위반시
		} catch (DataIntegrityViolationException e) {
			return false;
		}
		
		
		
	}
	
	//삭제코드!!!
	public void deleteComRegInfoByCocd(String co_cd) {
		acc1013dao.deleteComRegInfoByCocd(co_cd);
	}
	
	
	//회사정보 다가져오기
	public List<ComDTO> getAllComRegInfo() {		
		return acc1013dao.getAllComRegInfo();
	}
	
	public void updateComRegInfoByCocd(ComDTO comDTO) {
		acc1013dao.updateComRegInfoByCocd(comDTO);
	}
	
	//부서등록 카피 코드
	public ComDTO getCardSt(String co_cd) {
		System.out.println(co_cd);
		return acc1013dao.getStByCode(co_cd);
	}

}
