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
	List<ComDTO> searchCompanyByKeyword(@Param("keyword") String keyword);
    //trade
    List<TradeManagementDTO> searchTradeByKeyword(@Param("keyword") String keyword);
    //car
    List<CarDTO> searchCarByKeyword(@Param("keyword") String keyword);

//    //dept
//    List<DeptDTO> DeptfindByName(@Param("name") String name);  
//    List<DeptDTO> DeptfindByCode(@Param("code") Integer code);   
//    //emp
//    List<ACC1010EmpDTO> EmpfindByName(@Param("name") String name);
    
}
