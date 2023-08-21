package com.dz.back.ace.ace1000.ace1010.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.back.ace.ace1000.ace1010.dao.ACE1010DAO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
import com.dz.back.ace.ace1000.ace1010.dto.AutoCalcMileageDTO;
import com.dz.back.ace.ace1000.ace1010.dto.DeleteRequestAbizCarPersonDTO;
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

//	차량의 최대 seq_nb를 가져온다.
	@Override
	public Integer findMaxSeqNb(String car_cd) {

		return dao.findMaxSeqNb(car_cd);
	}

	@Override
	public List<AbizCarPersonDTO> findallbycar(String car_cd, String startDate, String endDate) {
		System.out.println("기간들어간 운행기록부 조회");
		System.out.println("car_cd : " + car_cd);
		// TODO Auto-generated method stub
		return dao.findallbycar(car_cd, startDate, endDate);
	}

	@Override
	public List<AbizCarPersonDTO> findallbycar(String car_cd) {
		System.out.println("기간이 안들어간 운행기록부 조회");
		// TODO Auto-generated method stub
		return dao.findallbycarByCarCd(car_cd);
	}

	@Override
	public int updateAbizCarPerson(AbizCarPersonDTO dto) {

		return dao.updateAbizCarPerson(dto);
	}

	@Override
	public String checkUseDtAndStartTime(AbizCarPersonDTO dto) {

//		시간 10자리로 맞추기
		String insertUseDt = dto.getUse_dt();

		if (insertUseDt != null && insertUseDt.length() >= 10) {
			insertUseDt = insertUseDt.substring(0, 10);
			dto.setUse_dt(insertUseDt);
		}
		System.out.println("수정시 use_dt 형태 확인");
		System.out.println(insertUseDt);

//		입력시 시간 확인 
		List<AbizCarPersonDTO> dtoForMaxUsedto = findallbycar(dto.getCar_cd());

		AbizCarPersonDTO checkFinalInsertUseDtAndStartTime = new AbizCarPersonDTO();

		String checkInsertUseDt = "";

//		제일 마지막 운행일자 가져오기
		if (!dtoForMaxUsedto.isEmpty()) {
			checkFinalInsertUseDtAndStartTime = dtoForMaxUsedto.get(dtoForMaxUsedto.size() - 1);
			checkInsertUseDt = checkFinalInsertUseDtAndStartTime.getUse_dt();
		}

		if (dto.getSeq_nb() > 0) { // 수정

			// seq_nb가 일치하는 객체 찾기
			Optional<AbizCarPersonDTO> matchedDtoOpt = dtoForMaxUsedto.stream()
					.filter(d -> Objects.equals(d.getSeq_nb(), dto.getSeq_nb())).findFirst();

			if (matchedDtoOpt.isPresent()) {
				AbizCarPersonDTO matchedDto = matchedDtoOpt.get();

				// insertUseDt와 matchedDto의 use_dt를 비교
				if (Objects.equals(insertUseDt, matchedDto.getUse_dt())) {
					// 여기서 수정을 진행합니다.
					System.out.println("수정 시작");
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
		} else { // 신규 입력

			if (dtoForMaxUsedto == null || dtoForMaxUsedto.isEmpty()) {
				return "ok";
			} else {
				System.out.println("시간확인용 DTO");
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
	@Transactional
	public int deleteAbizcarPerson(List<DeleteRequestAbizCarPersonDTO> dto) {
//		운행기록들 삭제
			System.out.println("삭제될 DTO 리스트 출력");
			System.out.println(dto.toString());
		
			dao.deleteAbizcarPerson(dto);
				
				
//		삭제된 운행기록중 미마감이고  최소 seq_nb 기준으로 오름차순 해서 배열로 가져오기
			List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.get(0).getCar_cd());
			System.out.println("삭제된 운행기록중 미마감이고  최소 seq_nb 기준으로 오름차순 해서 배열로 가져오");
			System.out.println(listDTO.toString());

			int startacc = getstartaccfordivision(dto.get(0).getCar_cd());
			
			if(listDTO.size() == 0) {
				return 1;
			}
			
			for (int i = 0; i < listDTO.size(); i++) { 
				if(i==0 &&listDTO.get(i).getSeq_nb() !=1 ) {
					 AbizCarPersonDTO currentDTO = listDTO.get(i);
					    
					 currentDTO.setBefore_km(startacc); 
					 currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km()); 
				} else {
					AbizCarPersonDTO currentDTO = listDTO.get(i);
				    AbizCarPersonDTO previousDTO = listDTO.get(i - 1);
				    
				    currentDTO.setBefore_km(previousDTO.getAfter_km()); 
				    currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km()); 
				}
			    
			}
			System.out.println("삭제후 계산이 끝난 운행기록부");
			System.out.println(listDTO.toString());
			
//			마지막 삭제되지 않은 운행기록부의 주행거리 계산
			int result = dao.updateMileageForeach(listDTO);
	
		return result;

	}

	
	
	@Override
	public int updateAutoCalcMileage(AutoCalcMileageDTO dto) {
		System.out.println("updateAutoCalcMileage service시작");
		
//		먼저 해당 운행기록의 주행거리 저장
		updateOnlyOneMileage(dto);
//		해당 운행기록 주행거리 변경후 미마감인 운행기록부를 seq_nb의 오름차순으로 다 가져옴
		List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.getCar_cd());
		
		
// 다른 운행기록의 주행전, 주행 후 수정
		if(listDTO.size() == 0) {
			return 1;
		}
		
		for (int i = 1; i < listDTO.size(); i++) { 
		    AbizCarPersonDTO currentDTO = listDTO.get(i);
		    AbizCarPersonDTO previousDTO = listDTO.get(i - 1);
		    
		    currentDTO.setBefore_km(previousDTO.getAfter_km()); 
		    currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km()); 
		}
		
		int result = dao.updateMileageForeach(listDTO);
		
		
		return result;
		
	
	}

	
	@Override
	public void updateOnlyOneMileage(AutoCalcMileageDTO dto) {
		System.out.println("하나만 update service시작");
		dao.updateOnlyOneMileage(dto);
		
	}

//	안분에 사용될 기초거리 가져오기
	@Override
	public int getstartaccfordivision(String car_cd) {
		int result = dao.getstartaccfordivision(car_cd);
		return result;
	}

	@Override
	public int savedivisiondistance(List<AutoCalcMileageDTO> dto) {
//		1. 안분에서 바뀐 것들을 다 수정
//		2. 미마감된 정보를 다시 수정 위의 자동계산 부분을 사용하면 됨
		dao.savedivisiondistance(dto);
		
		List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.get(0).getCar_cd());
		System.out.println("삭제된 운행기록중 미마감이고  최소 seq_nb 기준으로 오름차순 해서 배열로 가져오");
		System.out.println(listDTO.toString());

		int startacc = getstartaccfordivision(dto.get(0).getCar_cd());
		
		if(listDTO.size() == 0) {
			return 1;
		}
		
		for (int i = 0; i < listDTO.size(); i++) { 
			if(i==0 &&listDTO.get(i).getSeq_nb() !=1 ) {
				 AbizCarPersonDTO currentDTO = listDTO.get(i);
				    
				 currentDTO.setBefore_km(startacc); 
				 currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km()); 
			} else if(i==0 &&listDTO.get(i).getSeq_nb() == 1){
				
				AbizCarPersonDTO currentDTO = listDTO.get(i);
			  
			    //
			    currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km()); 
			    
			} else {
				AbizCarPersonDTO currentDTO = listDTO.get(i);
			    AbizCarPersonDTO previousDTO = listDTO.get(i - 1);
			    
			    currentDTO.setBefore_km(previousDTO.getAfter_km()); 
			    currentDTO.setAfter_km(currentDTO.getBefore_km() + currentDTO.getMileage_km()); 
			}
		    
		}
				int result = dao.updateMileageForeach(listDTO);
				
		return result;
	}


}