package com.dz.back.commons.codepicker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acc.acc1000.acc1012.dto.TradeManagementDTO;
import com.dz.back.acc.acc1000.acc1013.dto.ComDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;



public interface CodePickerMapper {
	//company
	List<ComDTO> CompanyfindByName(@Param("name") String name);
    List<ComDTO> CompanyfindByCode(@Param("code") Integer code);
    //trade
    List<TradeManagementDTO> TradefindByName(@Param("name") String name);
    List<TradeManagementDTO> TradefindByCode(@Param("code") Integer code);
    //car
    List<CarDTO> RegCarfindByName(@Param("name") String name);
    //dept
    List<DeptDTO> DeptfindByName(@Param("name") String name);    
    //emp
    List<ACC1010EmpDTO> EmpfindByName(@Param("name") String name);
}
