package com.dz.back.acc.acc1000.acc1013.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1013.dao.ACC1013DAO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;


@Service
public class ACC1013ServiceImpl {

	@Autowired
	private ACC1013DAO acc1013dao;

	//ȸ���ڵ�� ȸ���̸� ��������
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {	
		return acc1013dao.getComRegInfoByCocd(co_cd);
	}
	
	//�����ڵ�!!!! (����/������Ʈ) (ȸ���ڵ尡 ����ִٴ°��� �ƹ��͵� �Է¾����� ��..��� ����)
	public void saveComRegInfo(ComDTO comDTO) {

		
		acc1013dao.saveComRegInfo(comDTO);
		
	}
	
	//�����ڵ�!!!
	public void deleteComRegInfoByCocd(String co_cd) {
		acc1013dao.deleteComRegInfoByCocd(co_cd);
	}
	
	
	//ȸ������ �ٰ�������
	public List<ComDTO> getAllComRegInfo() {		
		return acc1013dao.getAllComRegInfo();
	}
	
	public void updateComRegInfoByCocd(ComDTO comDTO) {
		acc1013dao.updateComRegInfoByCocd(comDTO);
	}
	
	//�μ���� ī�� �ڵ�
	public ComDTO getCardSt(String co_cd) {
		System.out.println(co_cd);
		return acc1013dao.getStByCode(co_cd);
	}

}
