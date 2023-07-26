package com.dz.back.mapper;

import java.util.List;

import com.dz.back.dto.DeptDTO;

public interface DeptMapper {
	List<DeptDTO> getDeptList();

	DeptDTO getDeptByCode(String dept_cd);

	int insertDept(DeptDTO dto);

	void deleteDept(String dept_cd);

//	DeptDTO updateDept(DeptDTO dto);
//
}
