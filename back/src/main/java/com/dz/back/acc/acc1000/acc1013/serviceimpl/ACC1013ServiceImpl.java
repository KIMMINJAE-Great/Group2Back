package com.dz.back.acc.acc1000.acc1013.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1013.dao.ACC1013DAO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acc.acc1000.acc1013.service.ACC1013Service;

@Service
public class ACC1013ServiceImpl implements ACC1013Service{

	@Autowired
	private ACC1013DAO comRegDAO;

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
