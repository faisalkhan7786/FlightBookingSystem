package com.fare.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fare.entity.FlightDetails;
import com.fare.service.FareService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class FareController 
{
	@Autowired
	private FareService fareService;	

	@GetMapping("/all")
	@ApiOperation(value="Get all Flight details")
	public List<FlightDetails> getAllDetails()
	{
		return fareService.getAllDetails();
	}
	

	@GetMapping("/{flightNo}")
	@ApiOperation(value="Get all Flight details by flight Number")
	public FlightDetails getDetailsByFlightNo(@PathVariable Integer flightNo) 
	{
		return fareService.findByFlightNo(flightNo);
	}
	

	@PostMapping("/add")
	@ApiOperation(value="Add new Flight details to flight database")
	public String addFlightDetails(@Valid @RequestBody FlightDetails flightDetails)
	{
		fareService.addFlightDetails(flightDetails);
		return ("Added flight details with flightNumber - "+flightDetails.getFlightNo()+" successfully..!!");
	}
	

	@PutMapping("/update/{flightNo}")
	@ApiOperation(value="Update flight details in flight database by flight Number")
	public FlightDetails updateFlightDetails(@PathVariable Integer flightNo,@Valid @RequestBody FlightDetails flightDetails)
	{
		return fareService.updateFlightDetails(flightNo,flightDetails);
	}
	

	@DeleteMapping("/delete/{flightNo}")
	@ApiOperation(value="Delete flight details in Flight database by flightNumber")
	public ResponseEntity<FlightDetails> deleteFlightDetails(@PathVariable Integer flightNo)
	{
		return fareService.deleteFlightDetails(flightNo);
	}
	
	//update the no of seats based on the no of passengers that booked ticket
	@GetMapping("/updateSeats/{flightNo}/{noOfPassengers}")
	public void updateSeats(@PathVariable int flightNo,@PathVariable int noOfPassengers)
	{
		FlightDetails currentflight=fareService.findByFlightNo(flightNo);
		int initialSeats=currentflight.getNoOfSeats();
		int finalSeats=initialSeats-noOfPassengers;
		currentflight.setNoOfSeats(finalSeats);
		fareService.updateFlightDetails(flightNo, currentflight);
	}
}