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

	//ȸ���ڵ�� ȸ���̸� ��������
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {	
		return comRegDAO.getComRegInfoByCocd(co_cd);
	}
	
	//�����ڵ�!!!!
	public void saveComRegInfo(ComDTO comDTO) {
		comRegDAO.saveComRegInfo(comDTO);
	}
	
	//�����ڵ�!!!
	public void deleteComRegInfoByCocd(String co_cd) {
		comRegDAO.deleteComRegInfoByCocd(co_cd);
	}
	
	//ȸ������ �ٰ�������
	public List<ComDTO> getAllComRegInfo() {		
		return comRegDAO.getAllComRegInfo();
	}
}
