package com.checkin.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.checkin.entity.CheckinDetails;
import com.checkin.entity.FlightDetails;
import com.checkin.entity.UserDetails;
import com.checkin.service.CheckinService;

import io.swagger.annotations.ApiOperation;
@Component
@RestController
@RequestMapping("/checkIn")
public class CheckinController {
	
	@Autowired
	private CheckinService checkinService;
	
	 @PostMapping("/get/checkin/{pnrNo}")
	 @ApiOperation(value="Get Checkin") 
	 public CheckinDetails addCheckinDetails(@PathVariable long pnrNo) {
		 RestTemplate restTemplate=new RestTemplate();
		 UserDetails user=restTemplate.getForObject("http://localhost:8082/user/get/"+ pnrNo, UserDetails.class);
		 long pnr =user.getPnrNo();
		 int fNo=user.getFlightNo();
		 String sPoint=user.getStartPoint();
		 String ePoint=user.getEndPoint();
		 String cType=user.getClassType();
		 String uName=user.getName();
		 String sex=user.getSex();
		 String pay=user.getPayment();
		 
		 
		 FlightDetails fDetails=restTemplate.getForObject("http://localhost:8081/admin/"+ fNo, FlightDetails.class);
		 String  dTime=fDetails.getDeptTime();
		 String  duration=fDetails.getDuration();
		 String  date=fDetails.getFlightDate();
		
		 CheckinDetails cd= new CheckinDetails();
		 cd.setPnrNo(pnr);
		 cd.setFlightNo(fNo);
		 cd.setStartPoint(sPoint);
		 cd.setEndPoint(ePoint);
		 cd.setClassType(cType);
		 cd.setDeptTime(dTime);
		 cd.setName(uName);
		 cd.setSex(sex);
		 cd.setPayment(pay);
		 cd.setDuration(duration);
		 cd.setFlightDate(date);
		 cd.setSeatNo();
		 checkinService.addDetails(cd);
		 return checkinService.findByPnrNo(pnrNo);
		
		 
	 }
	

}
