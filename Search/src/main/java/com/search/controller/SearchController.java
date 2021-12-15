package com.search.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.entity.FlightDetails;
import com.search.service.SearchService;
import com.search.service.SearchServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
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
	
	@GetMapping("/status/{pnrNo}")
	@ApiOperation(value="Get status of your booking by Pnr Number")
	public String getStatus(@PathVariable long pnrNo)
	{
		return adminService.pnrStatus(pnrNo);
	}
	
	@GetMapping("/flightNo/{flightNo}")
	@ApiOperation(value="Get flight details by flight Number")
	public FlightDetails getDetailsByflightNo(@PathVariable int flightNo) 
	{
		return adminService.getDetailsByFlightNo(flightNo);
	}
	
	@GetMapping("/{startPoint}/{endPoint}")
	@ApiOperation(value="Get Flight details by giving startPoint and endPoint locations and date")
	public List<FlightDetails> getFlightDetailsByStartStation(@RequestParam String startPoint,@RequestParam  String endPoint,@RequestParam  String flightDate)
	{
		return adminService.findByStartPointAndEndPointAndFlightDate(startPoint, endPoint, flightDate);
	}
}