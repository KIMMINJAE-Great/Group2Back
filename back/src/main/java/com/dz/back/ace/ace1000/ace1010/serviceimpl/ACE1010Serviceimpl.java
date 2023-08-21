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
	public List<AbizCarPersonDTO> findallbycar(String car_cd, String startDate, String endDate) {
		System.out.println("�Ⱓ�� �����Ϻ� ��ȸ");
		System.out.println("car_cd : " + car_cd);
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
		List<AbizCarPersonDTO> dtoForMaxUsedto = findallbycar(dto.getCar_cd());

		AbizCarPersonDTO checkFinalInsertUseDtAndStartTime = new AbizCarPersonDTO();

		String checkInsertUseDt = "";

//		���� ������ �������� ��������
		if (!dtoForMaxUsedto.isEmpty()) {
			checkFinalInsertUseDtAndStartTime = dtoForMaxUsedto.get(dtoForMaxUsedto.size() - 1);
			checkInsertUseDt = checkFinalInsertUseDtAndStartTime.getUse_dt();
		}

		if (dto.getSeq_nb() > 0) { // ����

			// seq_nb�� ��ġ�ϴ� ��ü ã��
			Optional<AbizCarPersonDTO> matchedDtoOpt = dtoForMaxUsedto.stream()
					.filter(d -> Objects.equals(d.getSeq_nb(), dto.getSeq_nb())).findFirst();

			if (matchedDtoOpt.isPresent()) {
				AbizCarPersonDTO matchedDto = matchedDtoOpt.get();

				// insertUseDt�� matchedDto�� use_dt�� ��
				if (Objects.equals(insertUseDt, matchedDto.getUse_dt())) {
					// ���⼭ ������ �����մϴ�.
					System.out.println("���� ����");
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
		} else { // �ű� �Է�

			if (dtoForMaxUsedto == null || dtoForMaxUsedto.isEmpty()) {
				return "ok";
			} else {
				System.out.println("�ð�Ȯ�ο� DTO");
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
//		�����ϵ� ����
			System.out.println("������ DTO ����Ʈ ���");
			System.out.println(dto.toString());
		
			dao.deleteAbizcarPerson(dto);
				
				
//		������ �������� �̸����̰�  �ּ� seq_nb �������� �������� �ؼ� �迭�� ��������
			List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.get(0).getCar_cd());
			System.out.println("������ �������� �̸����̰�  �ּ� seq_nb �������� �������� �ؼ� �迭�� ������");
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
			System.out.println("������ ����� ���� �����Ϻ�");
			System.out.println(listDTO.toString());
			
//			������ �������� ���� �����Ϻ��� ����Ÿ� ���
			int result = dao.updateMileageForeach(listDTO);
	
		return result;

	}

	
	
	@Override
	public int updateAutoCalcMileage(AutoCalcMileageDTO dto) {
		System.out.println("updateAutoCalcMileage service����");
		
//		���� �ش� �������� ����Ÿ� ����
		updateOnlyOneMileage(dto);
//		�ش� ������ ����Ÿ� ������ �̸����� �����Ϻθ� seq_nb�� ������������ �� ������
		List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.getCar_cd());
		
		
// �ٸ� �������� ������, ���� �� ����
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
		System.out.println("�ϳ��� update service����");
		dao.updateOnlyOneMileage(dto);
		
	}

//	�Ⱥп� ���� ���ʰŸ� ��������
	@Override
	public int getstartaccfordivision(String car_cd) {
		int result = dao.getstartaccfordivision(car_cd);
		return result;
	}

	@Override
	public int savedivisiondistance(List<AutoCalcMileageDTO> dto) {
//		1. �Ⱥп��� �ٲ� �͵��� �� ����
//		2. �̸����� ������ �ٽ� ���� ���� �ڵ���� �κ��� ����ϸ� ��
		dao.savedivisiondistance(dto);
		
		List<AbizCarPersonDTO> listDTO = dao.findAllSeqNbNotSendY(dto.get(0).getCar_cd());
		System.out.println("������ �������� �̸����̰�  �ּ� seq_nb �������� �������� �ؼ� �迭�� ������");
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