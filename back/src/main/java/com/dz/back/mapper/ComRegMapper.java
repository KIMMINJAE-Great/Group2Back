package com.dz.back.mapper;

import java.util.List;

import com.dz.back.dto.ComDTO;



public interface ComRegMapper {
	//���� �ڵ� ���÷� ����ϱ�
//	void login();
//	void register(EmpDTO empDTO);
//	EmpDTO getEmpByUsername(String username);
//	public EmpDTO read(String username);
//	List<MauthDTO> readMauthList(String emp_cd);
	
	// ȸ���ڵ带 �ְ� ������ ������ ȸ�������� �����Ǵ� �ڵ�
	void deleteComRegInfoByCocd(String co_cd);
	
	// �ؽ�Ʈ�ʵ忡 �Է��� ���� ���θ� SCO ���̺� �����ϴ� �ڵ�
	void saveComRegInfo(ComDTO comDTO);
	
	//�ڵ� �̸����� ȸ������ ���� �������� �ڵ�
	List<ComDTO> getComRegInfoByCocd(String co_cd); // ȸ�� �̸��� ȸ���ڵ�� �������� 
	
	//select ȸ�翡 �ִ� ���̺� ���� �� �ҷ���
	List<ComDTO> getAllComRegInfo();
}
