package com.dz.back.acc.acc1000.acc1013.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1012.mapper.ACC1012Mapper;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acc.acc1000.acc1013.mapper.ACC1013Mapper;



@Repository
public class ACC1013DAO {

	@Autowired
	SqlSession sqlSession;
	//Test �ڵ� select �̴�. co_cd�� co_nm ã�� �ڵ�// ����Ʈ�� �޴±�...
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {
		System.out.println(co_cd+"DAO..");
		return sqlSession.getMapper(ACC1013Mapper.class).getComRegInfoByCocd(co_cd);
	}
	
	//�ڵ�� ȸ���̸� ã�� �ڵ�  //�Ⱦ� ���� XML����.
	public ComDTO selectCompanyByCoCd(String co_cd) {
        return sqlSession.selectOne("ComRegMapper.selectCompanyByCoCd", co_cd);
    }
	
	
	//save ���� ��ư�� ������ �Է��� �ؽ�Ʈ�ʵ忡�ִ� ������ ����Ǵ� �ڵ�
	public void saveComRegInfo(ComDTO comDTO) {		
		System.out.println("ȸ���� ���� ���� �����!");
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
	
	
	//ȸ���ڵ�� ȸ�� ���� ������Ʈ (�ش� ȸ���ڵ��� �����Ϳ�)
	public void updateComRegInfoByCocd(ComDTO comDTO) {
		System.out.println("ȸ�� ��� ���� ������Ʈ �����!!!");

		sqlSession.getMapper(ACC1013Mapper.class).updateComRegInfoByCocd(comDTO);
	}
	
	//�μ���� ī���ڵ�
	public ComDTO getStByCode(String co_cd) {
		System.out.println(co_cd);
		return sqlSession.getMapper(ACC1013Mapper.class).getStByCode(co_cd);
	}
}
