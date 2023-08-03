package com.dz.back.acc.acc1000.acc1013.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1013.dao.ACC1013DAO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acc.acc1000.acc1013.service.ACC1013Service;

@Service
public class ACC1013ServiceImpl {

	@Autowired
	private ACC1013DAO comRegDAO;

	//회사코드로 회사이름 가져오기
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {	
		return comRegDAO.getComRegInfoByCocd(co_cd);
	}
	
	//저장코드!!!! (저장/업데이트) (회사코드가 비어있다는것은 아무것도 입력안했을 때..라고 가정)
	public void saveComRegInfo(ComDTO comDTO) {
		String co_cd = comDTO.getCo_cd();
		List<ComDTO> comRegInfoExist = comRegDAO.getComRegInfoByCocd(co_cd); 
		System.out.println("저장이후에::"+co_cd);
		System.out.println("comRegInfoExist"+comRegInfoExist);
		if(comRegInfoExist !=null && !comRegInfoExist.isEmpty()) {  // 회사 정보가 존재하면 업데이트
			
			comRegDAO.updateComRegInfoByCocd(comDTO);
			System.out.println("바꾼후???:"+comDTO);
			
		} else { // 회사 정보가 존재하지 않으면 저장
			comRegDAO.saveComRegInfo(comDTO);
		}
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
