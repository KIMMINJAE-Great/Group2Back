package com.dz.back.acc.acc1000.acc1012.mapper;

import java.util.List;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;

public interface ACC1012Mapper {

	List<TradeManagementDTO> getStList();

	TradeManagementDTO getStByCode(String tr_cd);

	int insertStData(TradeManagementDTO tradeManagementDTO);

	void updateStData(TradeManagementDTO tradeManagementDTO);

	void deleteStData(String tr_cd);

	String getMaxTrcd();

	List<TradeManagementDTO> getSearchData(TradeManagementDTO dto);
}
