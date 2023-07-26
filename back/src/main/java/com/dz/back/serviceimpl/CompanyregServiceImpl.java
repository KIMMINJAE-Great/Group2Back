package com.dz.back.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.dao.ComRegDAO;
import com.dz.back.dto.ComDTO;

@Service
public class CompanyregServiceImpl {

	@Autowired
	private ComRegDAO comRegDAO;

	//회사코드로 회사이름 가져오기
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {	
		return comRegDAO.getComRegInfoByCocd(co_cd);
	}
	
	//저장코드!!!!
	public void saveComRegInfo(ComDTO comDTO) {
		comRegDAO.saveComRegInfo(comDTO);
	}
	
	//삭제코드!!!
	public void deleteComRegInfoByCocd(String co_cd) {
		comRegDAO.deleteComRegInfoByCocd(co_cd);
	}
	
	//회사정보 다가져오기
	public List<ComDTO> getAllComRegInfo() {		
		return comRegDAO.getAllComRegInfo();
	}
}
