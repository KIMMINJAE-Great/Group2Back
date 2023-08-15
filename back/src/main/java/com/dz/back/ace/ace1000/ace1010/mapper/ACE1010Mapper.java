package com.dz.back.ace.ace1000.ace1010.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.SendYnDTO;
import com.dz.back.ace.ace1000.ace1010.dto.StartEndFgDTO;
import com.dz.back.ace.ace1000.ace1010.dto.UseFgDTO;

public interface ACE1010Mapper {
	
	public List<AbizCarPersonDTO> getallcars();

	public List<UseFgDTO> usefg();

	public List<SendYnDTO> sendyn();

	public List<StartEndFgDTO> startendfg();

	public int insertAbizCarPerson(AbizCarPersonDTO dto);

	public Integer findMaxSeqNb(String car_cd);

	public List<AbizCarPersonDTO> findallbycar(@Param("car_cd") String car_cd, @Param("startDate") String startDate, @Param("endDate") String endDate);

	public List<AbizCarPersonDTO> findallbycarByCarCd(String car_cd);
	
	public int updateAbizCarPerson(AbizCarPersonDTO dto);

	public int updateTimeCheck(AbizCarPersonDTO dto);

}
