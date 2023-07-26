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
	//Test 코드 select 이다. co_cd로 co_nm 찾는 코드
	public List<ComDTO> getComRegInfoByCocd(String co_cd) {
		System.out.println(co_cd+"DAO..");
		return sqlSession.getMapper(ComRegMapper.class).getComRegInfoByCocd(co_cd);
	}
	//save 저장 버튼을 누르면 입력한 텍스트필드에있는 값들이 저장되는 코드
	public void saveComRegInfo(ComDTO comDTO) {			
		sqlSession.getMapper(ComRegMapper.class).saveComRegInfo(comDTO);		
	}
	
	//delete 삭제 // 회사코드를 입력하고 삭제 버튼을 누르면 삭제되는 코드
	public void deleteComRegInfoByCocd(String co_cd) {
		System.out.println("삭제 DAO접근함");
		sqlSession.getMapper(ComRegMapper.class).deleteComRegInfoByCocd(co_cd);
	}
	
	//모든 데이터 다 가져오는 코드
	public List<ComDTO> getAllComRegInfo() {
		return sqlSession.getMapper(ComRegMapper.class).getAllComRegInfo();
	}
}
