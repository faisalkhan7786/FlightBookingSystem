package com.search.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.search.entity.FlightDetails;
import com.search.entity.PaymentDetails;
import com.search.repository.SearchRepository;
import com.search.repository.UserPaymentRepository;


@Service
public class SearchServiceImpl implements SearchService
{
	@Autowired
	private SearchRepository searchRepo;
	
	@Autowired
	private UserPaymentRepository userPayRepo;
	
	@Override
	public List<FlightDetails> getAllDetails() {
		List<FlightDetails> FlightDetails=new ArrayList<FlightDetails>();
		searchRepo.findAll().forEach(FlightDetails1 -> FlightDetails.add(FlightDetails1));
		return FlightDetails;
	}
	
	@Override
	public String pnrStatus(long pnrNo) {
		Random rand = new Random();
		List<String> status=new ArrayList<String>();
		status.add("Confirm");
		status.add("Waiting list");
		List<PaymentDetails> paymentList=userPayRepo.findAll();
		for(PaymentDetails det:paymentList) {
			if(det.getPnrNo()==pnrNo) {
				return status.get(rand.nextInt(status.size()));
			}
		}
		return "Ticket is not booked with PNR Number "+pnrNo;
	}
	

	public FlightDetails getDetailsByFlightNo(int flightNo) {
		return searchRepo.findByFlightNo(flightNo);
		//.orElseThrow(()->new ResourceNotFoundException("flight not found with flightNumber : "+ flightNo));
	}
	
	public List<FlightDetails> findByStartPointAndEndPointAndFlightDate(String startPoint, String endPoint,String flightDate) {
		return searchRepo.findByStartPointAndEndPointAndFlightDate(startPoint, endPoint, flightDate);
		
	}

}