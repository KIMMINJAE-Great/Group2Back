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

	//ȸ���ڵ�� ȸ���̸� ��������
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {	
		return comRegDAO.getComRegInfoByCocd(co_cd);
	}
	
	//�����ڵ�!!!! (����/������Ʈ) (ȸ���ڵ尡 ����ִٴ°��� �ƹ��͵� �Է¾����� ��..��� ����)
	public void saveComRegInfo(ComDTO comDTO) {
		String co_cd = comDTO.getCo_cd();
		List<ComDTO> comRegInfoExist = comRegDAO.getComRegInfoByCocd(co_cd); 
		System.out.println("�������Ŀ�::"+co_cd);
		System.out.println("comRegInfoExist"+comRegInfoExist);
		if(comRegInfoExist !=null && !comRegInfoExist.isEmpty()) {  // ȸ�� ������ �����ϸ� ������Ʈ
			
			comRegDAO.updateComRegInfoByCocd(comDTO);
			System.out.println("�ٲ���???:"+comDTO);
			
		} else { // ȸ�� ������ �������� ������ ����
			comRegDAO.saveComRegInfo(comDTO);
		}
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
