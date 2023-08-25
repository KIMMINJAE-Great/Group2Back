package com.dz.back.ace.ace1000.ace1010.service;

import java.util.List;

import com.dz.back.ace.ace1000.ace1010.dto.AbizCarBookmarkDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AutoCalcMileageDTO;
import com.dz.back.ace.ace1000.ace1010.dto.DeleteRequestAbizCarPersonDTO;
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

// 占쏙옙짜 占쏙옙占쏙옙 占쏙옙占쏙옙占싹븝옙 占싯삼옙
	public List<AbizCarPersonDTO> findallbycar(String car_cd, String startDate, String endDate);

//	car_cd占싸몌옙 占쏙옙占쏙옙占싹븝옙 占싯삼옙
	public List<AbizCarPersonDTO> findallbycar(String car_cd);

	public int updateAbizCarPerson(AbizCarPersonDTO dto);

	public String checkUseDtAndStartTime(AbizCarPersonDTO dto);

	public int updateTimeCheck(AbizCarPersonDTO dto);

	public int deleteAbizcarPerson(List<DeleteRequestAbizCarPersonDTO> dto);
	
//	占쌤쇽옙 占쏙옙占쏙옙타占� 占쏙옙占쏙옙
	public void updateOnlyOneMileage(AutoCalcMileageDTO dto);
	
// 占쏙옙占쏙옙타占쏙옙占� 占쌘듸옙 占쏙옙占실댐옙 service
	public int updateAutoCalcMileage(AutoCalcMileageDTO dto);
	
// 占쌉력듸옙 占썅보占쏙옙 seq_nb占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 service
//	public List<AbizCarPersonDTO> selectByCarCdAndSeqNbGreaterThan(AutoCalcMileageDTO dto);
	

	public int getstartaccfordivision(String car_cd);

	public int savedivisiondistance(List<AutoCalcMileageDTO> dto);
	public int insertStartaccKm(AperStartaccInfoDTO aperStartaccInfoDTO);

	public int checkAperStart(AperStartaccInfoDTO aperStartaccInfoDTO);

	public int updateStartaccKm(AperStartaccInfoDTO aperStartaccInfoDTO);
	
	public String selectStartaccKm (String car_cd);
	
	public String findLastSeqNbWithSendYn(AbizCarPersonDTO dto);
	
	
	
	// �α����� emp_cd�� ���ã�� ��ȸ
		public List<AbizCarBookmarkDTO> findallbookmark(String emp_cd);
	// ���ã�� ����
		public int insertBookmark(List<AbizCarBookmarkDTO> bookmarks);
	// ���ã�� ����
		public int updateBookmark(AbizCarBookmarkDTO cdto);

		public AbizCarBookmarkDTO bookmarkstartfg(String emp_cd,String co_cd,String start_fg);
		
		public AbizCarBookmarkDTO bookmarkendfg(String emp_cd,String co_cd,String end_fg);
		

}
