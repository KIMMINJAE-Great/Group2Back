package com.dz.back.acc.acc1000.acc1013.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acc.acc1000.acc1013.mapper.ACC1013Mapper;

@Repository
public class ACC1013DAO {

	@Autowired
	SqlSession sqlSession;
	//Test �ڵ� select �̴�. co_cd�� co_nm ã�� �ڵ�
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {
		System.out.println(co_cd+"DAO..");
		return sqlSession.getMapper(ACC1013Mapper.class).getComRegInfoByCocd(co_cd);
	}
	//save ���� ��ư�� ������ �Է��� �ؽ�Ʈ�ʵ忡�ִ� ������ ����Ǵ� �ڵ�
	public void saveComRegInfo(ComDTO comDTO) {			
		sqlSession.getMapper(ACC1013Mapper.class).saveComRegInfo(comDTO);		
	}
	
	//delete ���� // ȸ���ڵ带 �Է��ϰ� ���� ��ư�� ������ �����Ǵ� �ڵ�
	public void deleteComRegInfoByCocd(String co_cd) {
		System.out.println("���� DAO������");
		sqlSession.getMapper(ACC1013Mapper.class).deleteComRegInfoByCocd(co_cd);
	}
	
	//��� ������ �� �������� �ڵ�
	public List<ComDTO> getAllComRegInfo() {
		return sqlSession.getMapper(ACC1013Mapper.class).getAllComRegInfo();
	}
}
