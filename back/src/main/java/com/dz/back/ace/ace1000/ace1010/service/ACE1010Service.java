package com.dz.back.ace.ace1000.ace1010.service;

import java.util.List;

import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AutoCalcMileageDTO;
import com.dz.back.ace.ace1000.ace1010.dto.DeleteRequestAbizCarPersonDTO;
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

// 날짜 포함 운행기록부 검색
	public List<AbizCarPersonDTO> findallbycar(String car_cd, String startDate, String endDate);

//	car_cd로만 운행기록부 검색
	public List<AbizCarPersonDTO> findallbycar(String car_cd);

	public int updateAbizCarPerson(AbizCarPersonDTO dto);

	public String checkUseDtAndStartTime(AbizCarPersonDTO dto);

	public int updateTimeCheck(AbizCarPersonDTO dto);

	public int deleteAbizcarPerson(List<DeleteRequestAbizCarPersonDTO> dto);
	
//	단순 주행거리 저장
	public void updateOnlyOneMileage(AutoCalcMileageDTO dto);
	
// 주행거리가 자동 계산되는 service
	public int updateAutoCalcMileage(AutoCalcMileageDTO dto);
	
// 입력된 행보다 seq_nb가 높은 데이터 가져오는 service
//	public List<AbizCarPersonDTO> selectByCarCdAndSeqNbGreaterThan(AutoCalcMileageDTO dto);
	

	public int getstartaccfordivision(String car_cd);

	public int savedivisiondistance(List<AutoCalcMileageDTO> dto);
}
