package com.dz.back.ace.ace1000.ace1010.service;

import java.util.List;

import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AperStartaccInfoDTO;
import com.dz.back.ace.ace1000.ace1010.dto.SendYnDTO;
import com.dz.back.ace.ace1000.ace1010.dto.StartEndFgDTO;
import com.dz.back.ace.ace1000.ace1010.dto.UseFgDTO;

public interface ACE1010Service {

	public List<AbizCarPersonDTO> getallcars();

	public List<UseFgDTO> usefg();

	public List<SendYnDTO> sendyn();

	public List<StartEndFgDTO> startendfg();

	public int insertAbizCarPerson(AbizCarPersonDTO dto);

	public Integer findMaxSeqNb(String car_cd);
// ��¥ ���� �����Ϻ� �˻�
	public List<AbizCarPersonDTO> findallbycar(String car_cd,String startDate, String endDate);
//	car_cd�θ� �����Ϻ� �˻�
	public List<AbizCarPersonDTO> findallbycar(String car_cd);

	public int updateAbizCarPerson(AbizCarPersonDTO dto);
	
	public String checkUseDtAndStartTime (AbizCarPersonDTO dto);
	
	public int updateTimeCheck(AbizCarPersonDTO dto);

	public int insertStartaccKm(AperStartaccInfoDTO aperStartaccInfoDTO);

	public int checkAperStart(AperStartaccInfoDTO aperStartaccInfoDTO);

	public int updateStartaccKm(AperStartaccInfoDTO aperStartaccInfoDTO);
	
	public String selectStartaccKm (String car_cd);

}
