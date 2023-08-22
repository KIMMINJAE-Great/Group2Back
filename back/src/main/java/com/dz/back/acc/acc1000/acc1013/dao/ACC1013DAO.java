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
	// co_cd로 회사 정보 전체를 받는 코드 유효성을 위해 만듦
	public ComDTO getComRegInfoByCocd(String co_cd) {
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
	
	//부서등록 카피코드
	public ComDTO getStByCode(String co_cd) {
		System.out.println(co_cd);
		return sqlSession.getMapper(ACC1013Mapper.class).getStByCode(co_cd);
	}
	
	public List<ComDTO> getSearchData(ComDTO dto) {
		return (List<ComDTO>) sqlSession.getMapper(ACC1013Mapper.class).getSearchData(dto);
	}
}
