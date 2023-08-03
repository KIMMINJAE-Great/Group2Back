package com.dz.back.acc.acc1000.acc1012.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1010.mapper.ACC1010Mapper;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1012.mapper.ACC1012Mapper;

@Repository
public class ACC1012DAO {

	@Autowired
	SqlSession sqlSession;

	public List<TradeManagementDTO> getStList() {
		return sqlSession.getMapper(ACC1012Mapper.class).getStList();
	}

	public TradeManagementDTO getStByCode(String tr_cd) {
		System.out.println(tr_cd);
		return sqlSession.getMapper(ACC1012Mapper.class).getStByCode(tr_cd);
	}

	public int insertStData(TradeManagementDTO tradeManagementDTO) {
		return sqlSession.getMapper(ACC1012Mapper.class).insertStData(tradeManagementDTO);
	}

	public void deleteStData(String tr_cd) {
		sqlSession.getMapper(ACC1012Mapper.class).deleteStData(tr_cd);
	}

	public void updateStData(TradeManagementDTO tradeManagementDTO) {
		sqlSession.getMapper(ACC1012Mapper.class).updateStData(tradeManagementDTO);
	}

	public String getMaxTrcd() {
		return sqlSession.getMapper(ACC1012Mapper.class).getMaxTrcd();
	}

	public List<TradeManagementDTO> getSearchData(TradeManagementDTO dto) {
		return (List<TradeManagementDTO>) sqlSession.getMapper(ACC1012Mapper.class).getSearchData(dto);
	}

}
