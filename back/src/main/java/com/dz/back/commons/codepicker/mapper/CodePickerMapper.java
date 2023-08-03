package com.dz.back.commons.codepicker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;



public interface CodePickerMapper {
	List<ComDTO> CompanyfindByName(@Param("name") String name);
    List<ComDTO> CompanyfindByCode(@Param("code") Integer code);
    List<CarDTO> RegCarfindByName(@Param("name") String name);
}
