package com.fare.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fare.entity.FlightDetails;

@Repository
public interface FareRepository extends MongoRepository<FlightDetails, Integer>
{
	public FlightDetails findByFlightNo(int flightNo);
}
