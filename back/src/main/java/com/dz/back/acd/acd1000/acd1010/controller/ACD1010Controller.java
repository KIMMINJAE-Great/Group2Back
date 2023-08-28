package com.dz.back.acd.acd1000.acd1010.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.back.acc.acc1000.acc1010.dto.ACC1010EmpDTO;
import com.dz.back.acc.acc1000.acc1011.dto.DeptDTO;
import com.dz.back.acd.acd1000.acd1010.dto.CarDTO;
import com.dz.back.acd.acd1000.acd1010.serviceImpl.ACD1010ServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/regcar")
public class ACD1010Controller {

   @Autowired
   ACD1010ServiceImpl regcarService;

   @GetMapping("/cardlist")
   public ResponseEntity<List<CarDTO>> getCardCarList() {
      List<CarDTO> carCardList = regcarService.getCardCarList();
      System.out.println(carCardList);
      return ResponseEntity.ok(carCardList);
   }

   @GetMapping("/carsearch")
   public ResponseEntity<List<CarDTO>> carSearch(@RequestParam(required = false) String lease_yn, 
                                    @RequestParam(required = false) String car_cd ) {

      List<CarDTO> carSearchList;
      
      
      if (lease_yn.equals("all")) {
         carSearchList = regcarService.getCardCarList();
      } else {
         if (lease_yn != null && lease_yn.isEmpty()) {
            lease_yn = null;
         }
         if (car_cd == null & car_cd.isEmpty()) {
            car_cd = null;
         }

         if (lease_yn != null) {
            if (lease_yn.isEmpty()) {
               lease_yn = null;
            } else if (lease_yn.equals("owned")) {
               lease_yn = "1";
            } else if (lease_yn.equals("rented")) {
               lease_yn = "2";
            } else if (lease_yn.equals("leased")) {
               lease_yn = "3";
            }
         }

         CarDTO carSearch = new CarDTO();
         carSearch.setLease_yn(lease_yn);
         carSearch.setCar_cd(car_cd);
         carSearchList = regcarService.carSearch(carSearch);
      }
      return ResponseEntity.ok().body(carSearchList);
   }

//   카占쏙옙 클占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
   @PostMapping("/getRegcarCard")
   public ResponseEntity<CarDTO> getEmpCard(@RequestBody Map<String, String> car_cd) {
      CarDTO dto = regcarService.getRegcarCard(car_cd.get("car_cd"));
      return ResponseEntity.ok().body(dto);

   }

   @PostMapping("/getCarsInfo")
   public ResponseEntity<String> getCarsInfo(@RequestBody Map<String, String> requestData) {
       String carCd = requestData.get("car_cd");
       System.out.println("carCd 첫 번째 : " + carCd);

       try {
           CarDTO carDTO = regcarService.findCar(carCd); // regcarService에서 데이터 조회
           System.out.println("carCd 두 번째 : " + carCd);

           if (carDTO != null) {
               String abizcarNBNM = carDTO.getCar_nb() + '.' + carDTO.getCar_nm();
               System.out.println("abizcarNBNM : " + abizcarNBNM);
               System.out.println("carDTO.getCar_nb() : " + carDTO.getCar_nb());
               System.out.println("carDTO.getCar_nm() : " + carDTO.getCar_nm());
               System.out.println("carDTO : " + carDTO);

               return ResponseEntity.ok().body(abizcarNBNM);
           } else {
               return ResponseEntity.notFound().build();
           }
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
   }


   // 차량 정보 추가
   @PostMapping("/addcar")
   public ResponseEntity<CarDTO> addRegCar(@RequestBody CarDTO dto) {
      
      
      String GetDt = dto.getGet_dt().substring(0, 10);
      
      if(dto.getLease_yn().equals("1")) {
         dto.setGet_dt(GetDt);
      } else {
      // 원본형식에서 처음부터 10자리까지만 잘라서
      String DisposalDt = "";
      String LfrDt = "";
      String LtoDt = "";

      if (dto.getDisposal_dt() != null || dto.getLfr_dt() != null || dto.getLto_dt() != null) {
         DisposalDt = dto.getDisposal_dt().substring(0, 10);
         dto.setDisposal_dt(DisposalDt);
         LfrDt = dto.getLfr_dt().substring(0, 10);
         LtoDt = dto.getLto_dt().substring(0, 10);
         dto.setLfr_dt(LfrDt);
         dto.setLto_dt(LtoDt);
      }

      String IfrDt = dto.getIfr_dt().substring(0, 10);
      String ItoDt = dto.getIto_dt().substring(0, 10);

      // 날짜를 자른 값으로 DTO 수정
      dto.setGet_dt(GetDt);
      dto.setIfr_dt(IfrDt);
      dto.setIto_dt(ItoDt);
      }
      int result = regcarService.addRegCar(dto);
      System.out.println(result);
      if (result == 1) {
         System.out.println(dto);
         return ResponseEntity.ok(dto);
      } else {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }

   // 차량 수정
   @PutMapping("/updatecar")
   public ResponseEntity<CarDTO> updateRegCar(@RequestBody CarDTO dto) {
      
      
      
      
String GetDt = dto.getGet_dt().substring(0, 10);
      
      if(dto.getLease_yn().equals("2")) {
         dto.setGet_dt(GetDt);
      } else {
      // 원본형식에서 처음부터 10자리까지만 잘라서
      String DisposalDt = "";
      String LfrDt = "";
      String LtoDt = "";

      if (dto.getDisposal_dt() != null || dto.getLfr_dt() != null || dto.getLto_dt() != null) {
         DisposalDt = dto.getDisposal_dt().substring(0, 10);
         dto.setDisposal_dt(DisposalDt);
         LfrDt = dto.getLfr_dt().substring(0, 10);
         LtoDt = dto.getLto_dt().substring(0, 10);
         dto.setLfr_dt(LfrDt);
         dto.setLto_dt(LtoDt);
      }

      String IfrDt = dto.getIfr_dt().substring(0, 10);
      String ItoDt = dto.getIto_dt().substring(0, 10);

      // 날짜를 자른 값으로 DTO 수정
      dto.setGet_dt(GetDt);
      dto.setIfr_dt(IfrDt);
      dto.setIto_dt(ItoDt);
      }

      int result = regcarService.updateRegCar(dto);
      System.out.println(result);
      if (result == 1) {
         System.out.println(dto);
         return ResponseEntity.ok(dto);
      } else {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }

   // 차량 삭제
   @DeleteMapping("/deletecar/{car_cd}")
   public void deleteRegCar(@PathVariable String car_cd) {
      regcarService.deleteRegCar(car_cd);
   }

   // 체크박스가 선택되었을때 한꺼번에 삭제하기
   @DeleteMapping("/deletecar")
   public void deleteCheckedCar(@RequestBody List<CarDTO> CarList) {
      for (CarDTO car : CarList) {

         regcarService.deleteRegCar(car.getCar_cd());
      }
   }

}