package com.dz.back.ace.ace1000.ace1010.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.mapper.ACC1010Mapper;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AutoCalcMileageDTO;
import com.dz.back.ace.ace1000.ace1010.dto.DeleteRequestAbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.SendYnDTO;
import com.dz.back.ace.ace1000.ace1010.dto.StartEndFgDTO;
import com.dz.back.ace.ace1000.ace1010.dto.UseFgDTO;
import com.dz.back.ace.ace1000.ace1010.mapper.ACE1010Mapper;

@Repository
public class ACE1010DAO {
	@Autowired
	SqlSession sqlSession;
	
	
	public List<AbizCarPersonDTO> getallcars(){
		
		return sqlSession.getMapper(ACE1010Mapper.class).getallcars();
	};

	public List<UseFgDTO> usefg() {
	
		return sqlSession.getMapper(ACE1010Mapper.class).usefg();
	};


	public List<SendYnDTO> sendyn() {
		
		return sqlSession.getMapper(ACE1010Mapper.class).sendyn();
	};


	public List<StartEndFgDTO> startendfg() {
		
		return sqlSession.getMapper(ACE1010Mapper.class).startendfg();
	};

// Test 운행기록부 저장 
	public int insertAbizCarPerson(AbizCarPersonDTO dto) {
		
		 return sqlSession.getMapper(ACE1010Mapper.class).insertAbizCarPerson(dto);
	};


	public Integer findMaxSeqNb(String car_cd) {
		
		return sqlSession.getMapper(ACE1010Mapper.class).findMaxSeqNb(car_cd);
	};


	public List<AbizCarPersonDTO> findallbycar(@Param("car_cd") String car_cd, @Param("startDate") String startDate, @Param("endDate") String endDate) {
		return sqlSession.getMapper(ACE1010Mapper.class).findallbycar(car_cd,startDate, endDate);
	};
	
	public List<AbizCarPersonDTO> findallbycarByCarCd(String car_cd) {
		return sqlSession.getMapper(ACE1010Mapper.class).findallbycarByCarCd(car_cd);
	};


	public int updateAbizCarPerson(AbizCarPersonDTO dto) {
		System.out.println(dto.toString());
		return sqlSession.getMapper(ACE1010Mapper.class).updateAbizCarPerson(dto);
	};


	public int updateTimeCheck(AbizCarPersonDTO dto) {
		
		return sqlSession.getMapper(ACE1010Mapper.class).updateTimeCheck(dto);
	};


	public int deleteAbizcarPerson(List<DeleteRequestAbizCarPersonDTO> dto) {
		
		return sqlSession.getMapper(ACE1010Mapper.class).deleteAbizcarPerson(dto);
	};
	
	public int updateMileageForeach(List<AbizCarPersonDTO> dto) {
		return sqlSession.getMapper(ACE1010Mapper.class).updateMileageForeach(dto);
	};
	
	
	public List<AbizCarPersonDTO> findAllSeqNbNotSendY (String car_cd){
		return sqlSession.getMapper(ACE1010Mapper.class).findAllSeqNbNotSendY(car_cd);
	};

//	
//	단순 주행거리 저장
	public void updateOnlyOneMileage(AutoCalcMileageDTO dto) {
		System.out.println("단일 저장 DAO 시작 updateOnlyOneMileage");
		System.out.println(dto.toString());
		sqlSession.getMapper(ACE1010Mapper.class).updateOnlyOneMileage(dto);
	};
	// 주행거리가 자동 계산되는 dao
//	public int updateAutoCalcMileage(List<AbizCarPersonDTO> dto) {
//		return sqlSession.getMapper(ACE1010Mapper.class).updateAutoCalcMileage(dto);
//	};
	// 입력된 행보다 seq_nb가 높은 데이터 가져오는 dao
//	public List<AbizCarPersonDTO> selectByCarCdAndSeqNbGreaterThan(AutoCalcMileageDTO dto){
//		return sqlSession.getMapper(ACE1010Mapper.class).selectByCarCdAndSeqNbGreaterThan(dto);
//	}

	public int getstartaccfordivision(String car_cd) {
		
		return sqlSession.getMapper(ACE1010Mapper.class).getstartaccfordivision(car_cd);
	}

	public void savedivisiondistance(List<AutoCalcMileageDTO> dto) {
		sqlSession.getMapper(ACE1010Mapper.class).savedivisiondistance(dto);
		
	};
	
}
