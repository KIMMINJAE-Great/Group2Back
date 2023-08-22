package com.dz.back.acc.acc1000.acc1013.mapper;

import java.util.List;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;



public interface ACC1013Mapper {


	// ȸ���ڵ带 �ְ� ������ ������ ȸ�������� �����Ǵ� �ڵ�
	void deleteComRegInfoByCocd(String co_cd);
	
	// �ؽ�Ʈ�ʵ忡 �Է��� ���� ���θ� SCO ���̺� �����ϴ� �ڵ�
	void saveComRegInfo(ComDTO comDTO);
	
	//�ڵ� �̸����� ȸ������ ���� �������� �ڵ�
	ComDTO getComRegInfoByCocd(String co_cd); // ȸ�� �̸��� ȸ���ڵ�� �������� 
	
	//select ȸ�翡 �ִ� ���̺� ���� �� �ҷ���
	List<ComDTO> getAllComRegInfo();
	
	//update co_cd�� where co_cd = ȸ���ڵ� �� ���� ������Ʈ 
	void updateComRegInfoByCocd(ComDTO comDTO);
	
	//�μ��ڵ�ī��
	ComDTO getStByCode(String co_cd);
	//�˻�
	List<ComDTO> getSearchData(ComDTO dto);
}
