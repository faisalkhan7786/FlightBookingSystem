package com.search.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.search.entity.FlightDetails;
import com.search.service.SearchService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@Component
@RestController
@RequestMapping("/search")
public class SearchController 
{
	@Autowired
	private SearchService adminService;
	
	@GetMapping("/allflights")
	@ApiOperation(value="Get all flight details")
	public List<FlightDetails> getAllDetails()
	{
		return adminService.getAllDetails();
	}
	
	@GetMapping("/status/")
	@ApiOperation(value="Get status of your booking by Pnr Number")
	public String getStatus(@RequestParam long pnrNo)
	{
		return adminService.pnrStatus(pnrNo);
	}
	
	@GetMapping("/flightNo/")
	@ApiOperation(value="Get flight details by flight Number")
	public FlightDetails getDetailsByflightNo(@RequestParam int flightNo) 
	{
		return adminService.getDetailsByFlightNo(flightNo);
	}
	
	@GetMapping("/findBy/{startPoint}/{endPoint}/{flightDate}")
	@ApiOperation(value="Get Flight details by giving startPoint and endPoint locations and date")
	public FlightDetails[] getFlightDetailsByStartPointAndEndPointAndFlightDate(@PathVariable String startPoint,@PathVariable  String endPoint,@PathVariable String flightDate)
	{
		RestTemplate restTemplate=new RestTemplate();
		FlightDetails[] response=restTemplate.getForObject("http://localhost:8081/fare/findBy/"+startPoint +"/"+endPoint+"/"+flightDate,FlightDetails[].class);
		return response;
		
	}
}