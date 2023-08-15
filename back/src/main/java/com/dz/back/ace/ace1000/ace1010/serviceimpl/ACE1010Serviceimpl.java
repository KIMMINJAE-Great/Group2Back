package com.dz.back.ace.ace1000.ace1010.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dz.back.ace.ace1000.ace1010.dao.ACE1010DAO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
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
	public List<AbizCarPersonDTO> findallbycar(String car_cd,String startDate, String endDate) {
		System.out.println("기간들어간 운행기록부 조회");
		System.out.println("car_cd : "+ car_cd);
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
		List<AbizCarPersonDTO> dtoForMaxUsedto  = findallbycar(dto.getCar_cd());
		
		AbizCarPersonDTO checkFinalInsertUseDtAndStartTime = new AbizCarPersonDTO();
		
		String checkInsertUseDt ="";
		
//		제일 마지막 운행일자 가져오기
		if(!dtoForMaxUsedto.isEmpty()) {
			checkFinalInsertUseDtAndStartTime = dtoForMaxUsedto.get(dtoForMaxUsedto.size() -1);
			checkInsertUseDt=checkFinalInsertUseDtAndStartTime.getUse_dt();
		} 
		
		
		if(dto.getSeq_nb() > 0) { //수정
			
			// seq_nb가 일치하는 객체 찾기
	        Optional<AbizCarPersonDTO> matchedDtoOpt = dtoForMaxUsedto.stream()
	            .filter(d -> Objects.equals(d.getSeq_nb(), dto.getSeq_nb()))
	            .findFirst();
	        
	        if (matchedDtoOpt.isPresent()) {
	            AbizCarPersonDTO matchedDto = matchedDtoOpt.get();
	            
	            // insertUseDt와 matchedDto의 use_dt를 비교
	            if (Objects.equals(insertUseDt, matchedDto.getUse_dt())) {
	                // 여기서 수정을 진행합니다.
	                System.out.println("수정 시작");
	                int updateTimeCheckResult = updateTimeCheck(dto);
	                System.out.println(updateTimeCheckResult);
	                if(updateTimeCheckResult > 0) {
	                    return "same time exist at working row";
	                } else {
	                    return "ok";
	                }
	            } else if(LocalDate.parse(insertUseDt).isBefore(LocalDate.parse(checkInsertUseDt))){
	                return "before data exist";
	            }
	        } 
		} else { //신규 입력
			

			if(dtoForMaxUsedto == null ||dtoForMaxUsedto.isEmpty()) {
				return "ok";
			} else {
				System.out.println("시간확인용 DTO");
				System.out.println(checkFinalInsertUseDtAndStartTime.toString());
				
				
				
				
				int insertStartTime;
				int checkInsertStartTime;
				
				if (LocalDate.parse(insertUseDt).isBefore(LocalDate.parse(checkInsertUseDt))) {
					return "before data exist";
				}
				
				if(dto.getStart_time() != null &&checkFinalInsertUseDtAndStartTime.getStart_time() !=null) {
					checkInsertStartTime = Integer.parseInt( checkFinalInsertUseDtAndStartTime.getStart_time());
					insertStartTime =  Integer.parseInt(dto.getStart_time());
					if(insertUseDt.equals(checkInsertUseDt)) {
						if(insertStartTime <= checkInsertStartTime) {
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
	

}
