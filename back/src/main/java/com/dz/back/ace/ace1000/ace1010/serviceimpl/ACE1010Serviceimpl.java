package com.dz.back.ace.ace1000.ace1010.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.back.ace.ace1000.ace1010.dao.ACE1010DAO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarBookmarkDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AutoCalcMileageDTO;
import com.dz.back.ace.ace1000.ace1010.dto.DeleteRequestAbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.KmFgDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AperStartaccInfoDTO;
import com.dz.back.ace.ace1000.ace1010.dto.SendYnDTO;
import com.dz.back.ace.ace1000.ace1010.dto.StartEndFgDTO;
import com.dz.back.ace.ace1000.ace1010.dto.UseFgDTO;
import com.dz.back.ace.ace1000.ace1010.service.ACE1010Service;

@Service
public class ACE1010Serviceimpl implements ACE1010Service {

	@Autowired
	ACE1010DAO dao;

	@Override
	public List<AbizCarPersonDTO> getallcars() {

		return dao.getallcars();
	}

	@Override
	public List<UseFgDTO> usefg() {

		return dao.usefg();
	}

	@Override
	public List<SendYnDTO> sendyn() {
		return dao.sendyn();
	}

	@Override
	public List<StartEndFgDTO> startendfg() {
		return dao.startendfg();
	}

	@Override
	public int insertAbizCarPerson(AbizCarPersonDTO dto) {

		return dao.insertAbizCarPerson(dto);
	}

//	占쏙옙占쏙옙占쏙옙 占쌍댐옙 seq_nb占쏙옙 占쏙옙占쏙옙占승댐옙.
	@Override
	public Integer findMaxSeqNb(String car_cd) {

		return dao.findMaxSeqNb(car_cd);
	}

	@Override
	public List<AbizCarPersonDTO> findallbycar(String car_cd, String startDate, String endDate) {
		System.out.println("car_cd : " + car_cd);
		// TODO Auto-generated method stub
		return dao.findallbycar(car_cd, startDate, endDate);
	}

	@Override
	public List<AbizCarPersonDTO> findallbycar(String car_cd) {

		return dao.findallbycarByCarCd(car_cd);
	}

	@Override
	public int updateAbizCarPerson(AbizCarPersonDTO dto) {

		return dao.updateAbizCarPerson(dto);
	}

	@Override
	public String checkUseDtAndStartTime(AbizCarPersonDTO dto) {

		String insertUseDt = dto.getUse_dt();

		if (insertUseDt != null && insertUseDt.length() >= 10) {
			insertUseDt = insertUseDt.substring(0, 10);
			dto.setUse_dt(insertUseDt);
		}
		System.out.println("占쏙옙占쏙옙占쏙옙 use_dt 占쏙옙占쏙옙 확占쏙옙");
		System.out.println(insertUseDt);

		List<AbizCarPersonDTO> dtoForMaxUsedto = findallbycar(dto.getCar_cd());

		AbizCarPersonDTO checkFinalInsertUseDtAndStartTime = new AbizCarPersonDTO();

		String checkInsertUseDt = "";

		if (!dtoForMaxUsedto.isEmpty()) {
			checkFinalInsertUseDtAndStartTime = dtoForMaxUsedto.get(dtoForMaxUsedto.size() - 1);
			checkInsertUseDt = checkFinalInsertUseDtAndStartTime.getUse_dt();
		}

		if (dto.getSeq_nb() > 0) {

			Optional<AbizCarPersonDTO> matchedDtoOpt = dtoForMaxUsedto.stream()
					.filter(d -> Objects.equals(d.getSeq_nb(), dto.getSeq_nb())).findFirst();

			if (matchedDtoOpt.isPresent()) {
				AbizCarPersonDTO matchedDto = matchedDtoOpt.get();

				if (Objects.equals(insertUseDt, matchedDto.getUse_dt())) {

					int updateTimeCheckResult = updateTimeCheck(dto);
					System.out.println(updateTimeCheckResult);
					if (updateTimeCheckResult > 0) {
						return "same time exist at working row";
					} else {
						return "ok";
					}
				} else if (LocalDate.parse(insertUseDt).isBefore(LocalDate.parse(checkInsertUseDt))) {
					return "before data exist";
				}
			}
		} else { // 占신깍옙 占쌉뤄옙

			if (dtoForMaxUsedto == null || dtoForMaxUsedto.isEmpty()) {
				return "ok";
			} else {
				System.out.println("占시곤옙확占싸울옙 DTO");
				System.out.println(checkFinalInsertUseDtAndStartTime.toString());

				int insertStartTime;
				int checkInsertStartTime;

				if (LocalDate.parse(insertUseDt).isBefore(LocalDate.parse(checkInsertUseDt))) {
					return "before data exist";
				}

				if (dto.getStart_time() != null && checkFinalInsertUseDtAndStartTime.getStart_time() != null) {
					checkInsertStartTime = Integer.parseInt(checkFinalInsertUseDtAndStartTime.getStart_time());
					insertStartTime = Integer.parseInt(dto.getStart_time());
					if (insertUseDt.equals(checkInsertUseDt)) {
						if (insertStartTime <= checkInsertStartTime) {
							return "same time data exist";
						}
					}
				}
			}

		}

		return "ok";
	}

	@Override
	public int updateTimeCheck(AbizCarPersonDTO dto) {

		return dao.updateTimeCheck(dto);
	}

	@Override
	public int insertStartaccKm(AperStartaccInfoDTO aperStartaccInfoDTO) {
		return dao.insertStartaccKm(aperStartaccInfoDTO);
	}

	@Override
	public int checkAperStart(AperStartaccInfoDTO aperStartaccInfoDTO) {
		return dao.checkAperStart(aperStartaccInfoDTO);
	}

	@Override
	public int updateStartaccKm(AperStartaccInfoDTO aperStartaccInfoDTO) {
		return dao.updateStartaccKm(aperStartaccInfoDTO);
	}

	@Override
	public String selectStartaccKm(String car_cd) {
		return dao.selectStartaccKm(car_cd);
	}

	@Override
	@Transactional
	public int deleteAbizcarPerson(List<DeleteRequestAbizCarPersonDTO> dto) {
		System.out.println("占쏙옙占쏙옙占쏙옙 DTO 占쏙옙占쏙옙트 占쏙옙占�");
		System.out.println(dto.toString());

		dao.deleteAbizcarPerson(dto);

// 삭제된 운행기록의 제일 첫요소의 seq_nb를 기준으로 다시 그 이상의 기록들을 검색한다.
		List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.get(0).getSeq_nb(), dto.get(0).getCar_cd());
//		삭제된 운행기록의 제일 첫요소의 이전 기록중 after_km를 가져온다. 없다면 기초거리를 가져온다.
		int km = dao.selectAfterKmThanBeforeSeqNb(dto.get(0).getSeq_nb(), dto.get(0).getCar_cd());

		if (listDTO.size() == 0) {
			return 1;
		}

		for (int i = 0; i < listDTO.size(); i++) {
			if (i == 0) {
				AbizCarPersonDTO currentDTO = listDTO.get(i);

				currentDTO.setBefore_km(km);
				currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km());
			} else {
				AbizCarPersonDTO currentDTO = listDTO.get(i);
				AbizCarPersonDTO previousDTO = listDTO.get(i - 1);

				currentDTO.setBefore_km(previousDTO.getAfter_km());
				currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km());
			}

		}

		System.out.println(listDTO.toString());

//			占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹븝옙占쏙옙 占쏙옙占쏙옙타占� 占쏙옙占�
		int result = dao.updateMileageForeach(listDTO);

		return result;

	}

	@Override
	public int updateAutoCalcMileage(AutoCalcMileageDTO dto) {

		updateOnlyOneMileage(dto);

		List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.getSeq_nb()-1, dto.getCar_cd());

		

		if (listDTO.size() == 0) {
			return 1;
		}

		for (int i = 0; i < listDTO.size(); i++) {
			if (i == 0) {
				
			} else {
				AbizCarPersonDTO currentDTO = listDTO.get(i);
				AbizCarPersonDTO previousDTO = listDTO.get(i - 1);

				currentDTO.setBefore_km(previousDTO.getAfter_km());
				currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km());
			}

		}

		System.out.println(listDTO.toString());

//					占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹븝옙占쏙옙 占쏙옙占쏙옙타占� 占쏙옙占�
		int result = dao.updateMileageForeach(listDTO);
		return result;
		
	}

	@Override
	public void updateOnlyOneMileage(AutoCalcMileageDTO dto) {
		System.out.println("占싹놂옙占쏙옙 update service占쏙옙占쏙옙");
		dao.updateOnlyOneMileage(dto);

	}

//	占싫분울옙 占쏙옙占쏙옙 占쏙옙占십거몌옙 占쏙옙占쏙옙占쏙옙占쏙옙
	@Override
	public int getstartaccfordivision(String car_cd) {
		int result = dao.getstartaccfordivision(car_cd);
		return result;
	}

	@Override
	public int savedivisiondistance(List<AutoCalcMileageDTO> dto) {

		dao.savedivisiondistance(dto);

		List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.get(0).getSeq_nb()-1, dto.get(0).getCar_cd());

		int km = dao.selectAfterKmThanBeforeSeqNb(dto.get(0).getSeq_nb(), dto.get(0).getCar_cd());

		if (listDTO.size() == 0) {
			return 1;
		}

		for (int i = 0; i < listDTO.size(); i++) {
			if (i == 0) {
				AbizCarPersonDTO currentDTO = listDTO.get(i);

				currentDTO.setBefore_km(km);
				currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km());
			} else {
				AbizCarPersonDTO currentDTO = listDTO.get(i);
				AbizCarPersonDTO previousDTO = listDTO.get(i - 1);

				currentDTO.setBefore_km(previousDTO.getAfter_km());
				currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km());
			}

		}

		System.out.println(listDTO.toString());

//					占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹븝옙占쏙옙 占쏙옙占쏙옙타占� 占쏙옙占�
		int result = dao.updateMileageForeach(listDTO);
		return result;
	}

	@Override
	public List<AbizCarBookmarkDTO> findallbookmark(String emp_cd) {

		return dao.findallbookmark(emp_cd);
	}

	@Override
	public int insertBookmark(List<AbizCarBookmarkDTO> bookmarks) {

		return dao.insertbookmark(bookmarks);
	}

	@Override
	public int updateBookmark(AbizCarBookmarkDTO cdto) {

		return dao.updatebookmark(cdto);
	}

	@Override
	public AbizCarBookmarkDTO bookmarkstartfg(String emp_cd, String co_cd, String start_fg) {
		return dao.bookmarkstartfg(emp_cd, co_cd, start_fg);
	}

	@Override
	public AbizCarBookmarkDTO bookmarkendfg(String emp_cd, String co_cd, String end_fg) {
		return dao.bookmarkendfg(emp_cd, co_cd, end_fg);
	}

	@Override
	public KmFgDTO selectLastAfterKm(AbizCarPersonDTO dto) {
		return dao.selectLastAfterKm(dto);
	}

	@Override
	public String findLastSeqNbWithSendYn(AbizCarPersonDTO abizCarPersonDTO) {

		return dao.findLastSeqNbWithSendYn(abizCarPersonDTO);
	}

	@Override
	public void selectedCopy(List<AbizCarPersonDTO> requestData) {
		
		int seqnb = findMaxSeqNb(requestData.get(0).getCar_cd());
		int forotherseqnb = seqnb;
	    for (AbizCarPersonDTO dto : requestData) {
        
        seqnb++;
        dto.setSeq_nb(seqnb);

        System.out.println("seqnb : " + seqnb);
        
        String datetimeString = dto.getUse_dt();
        if (datetimeString != null && datetimeString.length() >= 10) {
        	String dateString = datetimeString.substring(0, 10);
            dto.setUse_dt(dateString);
            System.out.println("dateString : " + dateString);
        } else {
            System.out.println("null 이 나올수가 없음@@@@@@@@@");
        }

        int result = insertAbizCarPerson(dto);
       
    }
	    
	    List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(forotherseqnb-1, requestData.get(0).getCar_cd());
	    System.out.println("...........여기");
	    System.out.println(listDTO.toString());
	    for (int i = 0; i < listDTO.size(); i++) {
			if (i == 0) {
			} else {
				AbizCarPersonDTO currentDTO = listDTO.get(i);
				AbizCarPersonDTO previousDTO = listDTO.get(i - 1);

				currentDTO.setBefore_km(previousDTO.getAfter_km());
				currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km());
			}

		}
	    
	    System.out.println("반복문 계산 끝나고 listDTo");
	    System.out.println(listDTO.toString());
	    int result = dao.updateMileageForeach(listDTO);
		
	}

}