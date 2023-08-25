package com.dz.back.ace.ace1000.ace1010.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dz.back.ace.ace1000.ace1010.dto.AbizCarBookmarkDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AutoCalcMileageDTO;
import com.dz.back.ace.ace1000.ace1010.dto.DeleteRequestAbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AperStartaccInfoDTO;
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

	public int deleteAbizcarPerson(List<DeleteRequestAbizCarPersonDTO> dto);
	
	public int updateMileageForeach(List<AbizCarPersonDTO> dto);
	
	public List<AbizCarPersonDTO> findAllSeqNbNotSendY (String car_cd);
	
	public void updateOnlyOneMileage(AutoCalcMileageDTO dto);
	
//	public int updateAutoCalcMileage(List<AbizCarPersonDTO> dto);
	
//	public List<AbizCarPersonDTO> selectByCarCdAndSeqNbGreaterThan(AutoCalcMileageDTO dto);

	public int getstartaccfordivision(String car_cd);

	public void savedivisiondistance(List<AutoCalcMileageDTO> dto);
	public int insertStartaccKm(AperStartaccInfoDTO aperStartaccInfoDTO);

	public int checkAperStart(AperStartaccInfoDTO aperStartaccInfoDTO);

	public int updateStartaccKm(AperStartaccInfoDTO aperStartaccInfoDTO);
	
	public String selectStartaccKm(String car_cd);
	
	public List<AbizCarBookmarkDTO> findallbookmark(String emp_cd);

	public int insertbookmark(List<AbizCarBookmarkDTO> bookmarks);

	public int updatebookmark(AbizCarBookmarkDTO cdto);

	public AbizCarBookmarkDTO bookmarkstartfg1(@Param("emp_cd") String emp_cd, @Param("co_cd") String co_cd, @Param("start_fg") String start_fg);
	
	public AbizCarBookmarkDTO bookmarkstartfg2(@Param("emp_cd") String emp_cd, @Param("co_cd") String co_cd, @Param("start_fg") String start_fg);
	
    public AbizCarBookmarkDTO bookmarkendfg1(@Param("emp_cd") String emp_cd, @Param("co_cd") String co_cd, @Param("end_fg") String end_fg);
	
	public AbizCarBookmarkDTO bookmarkendfg2(@Param("emp_cd") String emp_cd, @Param("co_cd") String co_cd, @Param("end_fg") String end_fg);

	public String findLastSeqNbWithSendYn(AbizCarPersonDTO dto);
	

}
