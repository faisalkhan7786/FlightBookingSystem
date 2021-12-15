package com.search.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.search.entity.FlightDetails;

@Repository
public interface SearchRepository extends MongoRepository<FlightDetails, Integer>
{

	FlightDetails findByFlightNo(int flightNo);
	public List<FlightDetails> findByStartPointAndEndPointAndFlightDate(String startPoint, String endPoint,String flightDate);
}
