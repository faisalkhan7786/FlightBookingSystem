package com.fare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fare.entity.FlightDetails;
import com.fare.repository.FareRepository;



@Service
public class FareServiceImpl implements FareService
{
	@Autowired
	private FareRepository fareRepo;
	
	public List<FlightDetails> getAllDetails()
	{
		List<FlightDetails> FlightDetails=new ArrayList<FlightDetails>();
		fareRepo.findAll().forEach(FlightDetails1 -> FlightDetails.add(FlightDetails1));
		//To check while testing..
		//System.out.println(FlightDetails);
		return FlightDetails;
	}
	
	public void addFlightDetails(FlightDetails flightDetails)
	{
		fareRepo.save(flightDetails);
	}
	
	public FlightDetails updateFlightDetails(int flightNo,FlightDetails flightDetails)
	{
		FlightDetails existingDetails=fareRepo.findByFlightNo(flightNo);
		existingDetails.setFlightNo(flightDetails.getFlightNo());
		existingDetails.setStartPoint(flightDetails.getStartPoint());
		existingDetails.setEndPoint(flightDetails.getEndPoint());
		existingDetails.setArrivalTime(flightDetails.getArrivalTime());
		existingDetails.setDeptTime(flightDetails.getDeptTime());
		existingDetails.setDuration(flightDetails.getDuration());
		existingDetails.setNoOfSeats(flightDetails.getNoOfSeats());
		existingDetails.setEconomyClass(flightDetails.getEconomyClass());
		existingDetails.setPremiumEconomy(flightDetails.getPremiumEconomy());
		existingDetails.setPremiumEconomy(flightDetails.getPremiumEconomy());
		return fareRepo.save(existingDetails);
	}
	
	@Override
	public ResponseEntity<FlightDetails> deleteFlightDetails(int flightNo) {
		FlightDetails existingDetails=fareRepo.findByFlightNo(flightNo);
		fareRepo.delete(existingDetails);
		//fareRepo.deleteById(flightNo);
		return ResponseEntity.ok().build();
	}

	@Override
	public FlightDetails findByFlightNo(int flightNo) {
		// TODO Auto-generated method stub
		return fareRepo.findByFlightNo(flightNo);
	}
}