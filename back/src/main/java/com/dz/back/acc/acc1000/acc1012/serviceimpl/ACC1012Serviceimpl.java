package com.dz.back.acc.acc1000.acc1012.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dz.back.acc.acc1000.acc1012.dao.ACC1012DAO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;

@Service
public class ACC1012Serviceimpl {

	@Autowired
	private ACC1012DAO acc1012DAO;

	/* 거래처 관리 SELECT 카드의 정보 전체 가져오기 */
	public List<TradeManagementDTO> getCardStList() {
		return acc1012DAO.getStList();
	}

	/* 거래처 관리 SELECT 카드의 정보 1개만 가져오기 */
	public TradeManagementDTO getCardSt(String tr_cd) {
		System.out.println(tr_cd);
		return acc1012DAO.getStByCode(tr_cd);
	}

	/* 거래처 관리 INSERT DATA */
	public int insertStData(TradeManagementDTO tradeManagementDTO) {
		return acc1012DAO.insertStData(tradeManagementDTO);
	}

	/* 거래처 관리 DELETE DATA */
	public void deleteStData(String tr_cd) {
		acc1012DAO.deleteStData(tr_cd);
	}

	/* 거래처 관리 UPDATE DATA */
	public void updateStData(TradeManagementDTO tradeManagementDTO) {
		acc1012DAO.updateStData(tradeManagementDTO);
	}

	/* 거래처 관리 - 거래처 코드 자동채번 ex) 0000000001 */
	public String getMaxTrcd() {
		return acc1012DAO.getMaxTrcd();
	}

	/* 거래처 관리 SELECT 카드의 정보 겁색한 값만 가져오기 */
	public List<TradeManagementDTO> getSearchData(TradeManagementDTO dto) {
		return acc1012DAO.getSearchData(dto);
	}

}
