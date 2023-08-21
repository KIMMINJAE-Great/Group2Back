package com.dz.back.ace.ace1000.ace1010.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dz.back.ace.ace1000.ace1010.dao.ACE1010DAO;
import com.dz.back.ace.ace1000.ace1010.dto.AbizCarPersonDTO;
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
	
//	������ �ִ� seq_nb�� �����´�.
	@Override
	public Integer findMaxSeqNb(String car_cd) {
		
		return dao.findMaxSeqNb(car_cd);
	}
	@Override
	public List<AbizCarPersonDTO> findallbycar(String car_cd,String startDate, String endDate) {
		System.out.println("�Ⱓ�� �����Ϻ� ��ȸ");
		System.out.println("car_cd : "+ car_cd);
		// TODO Auto-generated method stub
		return dao.findallbycar(car_cd, startDate, endDate);
	}
	@Override
	public List<AbizCarPersonDTO> findallbycar(String car_cd) {
		System.out.println("�Ⱓ�� �ȵ� �����Ϻ� ��ȸ");
		// TODO Auto-generated method stub
		return dao.findallbycarByCarCd(car_cd);
	}
	
	@Override
	public int updateAbizCarPerson(AbizCarPersonDTO dto) {
		
		return dao.updateAbizCarPerson(dto);
	}
	@Override
	public String checkUseDtAndStartTime(AbizCarPersonDTO dto) {
		
//		�ð� 10�ڸ��� ���߱�
		String insertUseDt = dto.getUse_dt();
		
		if (insertUseDt != null && insertUseDt.length() >= 10) {
			 insertUseDt = insertUseDt.substring(0, 10);
			 dto.setUse_dt(insertUseDt);
		}
		System.out.println("������ use_dt ���� Ȯ��");
		System.out.println(insertUseDt);
		
//		�Է½� �ð� Ȯ�� 
		List<AbizCarPersonDTO> dtoForMaxUsedto  = findallbycar(dto.getCar_cd());
		
		AbizCarPersonDTO checkFinalInsertUseDtAndStartTime = new AbizCarPersonDTO();
		
		String checkInsertUseDt ="";
		
//		���� ������ �������� ��������
		if(!dtoForMaxUsedto.isEmpty()) {
			checkFinalInsertUseDtAndStartTime = dtoForMaxUsedto.get(dtoForMaxUsedto.size() -1);
			checkInsertUseDt=checkFinalInsertUseDtAndStartTime.getUse_dt();
		} 
		
		
		if(dto.getSeq_nb() > 0) { //����
			
			// seq_nb�� ��ġ�ϴ� ��ü ã��
	        Optional<AbizCarPersonDTO> matchedDtoOpt = dtoForMaxUsedto.stream()
	            .filter(d -> Objects.equals(d.getSeq_nb(), dto.getSeq_nb()))
	            .findFirst();
	        
	        if (matchedDtoOpt.isPresent()) {
	            AbizCarPersonDTO matchedDto = matchedDtoOpt.get();
	            
	            // insertUseDt�� matchedDto�� use_dt�� ��
	            if (Objects.equals(insertUseDt, matchedDto.getUse_dt())) {
	                // ���⼭ ������ �����մϴ�.
	                System.out.println("���� ����");
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
		} else { //�ű� �Է�
			

			if(dtoForMaxUsedto == null ||dtoForMaxUsedto.isEmpty()) {
				return "ok";
			} else {
				System.out.println("�ð�Ȯ�ο� DTO");
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

}
