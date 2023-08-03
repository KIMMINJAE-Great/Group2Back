package com.dz.back.acc.acc1000.acc1011.mapper;

import java.util.List;

import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;

public interface ACC1011Mapper {
	List<DeptDTO> getDeptList();

	DeptDTO getDeptByCode(String dept_cd);

	int insertDept(DeptDTO dto);

	void deleteDept(String dept_cd);

	int updateDept(DeptDTO dto);
	
	List<DeptDTO> deptSearch(DeptDTO deptSearch);
//
}
