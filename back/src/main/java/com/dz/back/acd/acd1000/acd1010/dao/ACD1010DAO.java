package com.dz.back.acd.acd1000.acd1010.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.acd.acd1000.acd1010.mapper.ACD1010Mapper;


@Repository
public class ACD1010DAO {

	
	@Autowired
	SqlSession sqlSession;
	
	//모든 데이터 다 가져오는 코드
		public List<CarDTO> getCarList() {
			return sqlSession.getMapper(ACD1010Mapper.class).getCarList();
		}

		public CarDTO getRegcarCard(String car_cd) {
			
			return sqlSession.getMapper(ACD1010Mapper.class).getRegcarCard(car_cd);
		}

		public int addRegCar(CarDTO dto) {
			
			return  sqlSession.getMapper(ACD1010Mapper.class).addRegCar(dto);
		}

		public int updateRegCar(CarDTO dto) {
			
			return sqlSession.getMapper(ACD1010Mapper.class).updateRegCar(dto);
		}

		public void deleteRegCar(String car_cd) {
			
			sqlSession.getMapper(ACD1010Mapper.class).deleteRegCar(car_cd);
			
		}
}
