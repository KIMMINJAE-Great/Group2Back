package com.dz.back.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.dto.ComDTO;
import com.dz.back.mapper.ComRegMapper;

@Repository
public class ComRegDAO {

	@Autowired
	SqlSession sqlSession;
	//Test �ڵ� select �̴�. co_cd�� co_nm ã�� �ڵ�
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {
		System.out.println(co_cd+"DAO..");
		return sqlSession.getMapper(ComRegMapper.class).getComRegInfoByCocd(co_cd);
	}
	//save ���� ��ư�� ������ �Է��� �ؽ�Ʈ�ʵ忡�ִ� ������ ����Ǵ� �ڵ�
	public void saveComRegInfo(ComDTO comDTO) {			
		sqlSession.getMapper(ComRegMapper.class).saveComRegInfo(comDTO);		
	}
	
	//delete ���� // ȸ���ڵ带 �Է��ϰ� ���� ��ư�� ������ �����Ǵ� �ڵ�
	public void deleteComRegInfoByCocd(String co_cd) {
		System.out.println("���� DAO������");
		sqlSession.getMapper(ComRegMapper.class).deleteComRegInfoByCocd(co_cd);
	}
	
	//��� ������ �� �������� �ڵ�
	public List<ComDTO> getAllComRegInfo() {
		return sqlSession.getMapper(ComRegMapper.class).getAllComRegInfo();
	}
}
