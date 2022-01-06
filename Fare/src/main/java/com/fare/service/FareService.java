package com.fare.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.fare.entity.AdminDetails;
import com.fare.entity.FlightDetails;

public interface FareService {

public List<FlightDetails> getAllDetails();
	
	public void addFlightDetails(FlightDetails flightDetails);
	
	public FlightDetails updateFlightDetails(int flightNo,FlightDetails flightDetails);
	
	public ResponseEntity<FlightDetails> deleteFlightDetails(int flightNo);

	public FlightDetails findByFlightNo(int flightNo);

	public FlightDetails[] findByStartPointAndEndPointAndFlightDate(String startPoint, String endPoint,
			String flightDate);

	public void addAdmin(AdminDetails adminDetails) ;

}
