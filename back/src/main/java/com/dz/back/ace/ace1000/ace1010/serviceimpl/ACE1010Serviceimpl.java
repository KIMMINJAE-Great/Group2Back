package com.dz.back.ace.ace1000.ace1010.serviceimpl;

import java.util.List;

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

}
