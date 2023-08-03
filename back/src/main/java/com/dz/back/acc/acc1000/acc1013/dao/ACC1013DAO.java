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
	//Test 코드 select 이다. co_cd로 co_nm 찾는 코드// 리스트로 받는군...
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {
		System.out.println(co_cd+"DAO..");
		return sqlSession.getMapper(ACC1013Mapper.class).getComRegInfoByCocd(co_cd);
	}
	
	//코드로 회사이름 찾는 코드  //안씀 없음 XML에도.
	public ComDTO selectCompanyByCoCd(String co_cd) {
        return sqlSession.selectOne("ComRegMapper.selectCompanyByCoCd", co_cd);
    }
	
	
	//save 저장 버튼을 누르면 입력한 텍스트필드에있는 값들이 저장되는 코드
	public void saveComRegInfo(ComDTO comDTO) {		
		System.out.println("회사등록 정보 저장 실행됨!");
		sqlSession.getMapper(ACC1013Mapper.class).saveComRegInfo(comDTO);		
	}
	
	//delete 삭제 // 회사코드를 입력하고 삭제 버튼을 누르면 삭제되는 코드
	public void deleteComRegInfoByCocd(String co_cd) {
		System.out.println("삭제 DAO접근함");
		sqlSession.getMapper(ACC1013Mapper.class).deleteComRegInfoByCocd(co_cd);
	}
	
	//모든 데이터 다 가져오는 코드
	public List<ComDTO> getAllComRegInfo() {
		return sqlSession.getMapper(ACC1013Mapper.class).getAllComRegInfo();
	}
	
	
	//회사코드로 회사 정보 업데이트 (해당 회사코드의 데이터열)
	public void updateComRegInfoByCocd(ComDTO comDTO) {
		System.out.println("회사 등록 정보 업데이트 실행됨!!!");

		sqlSession.getMapper(ACC1013Mapper.class).updateComRegInfoByCocd(comDTO);
	}
}
