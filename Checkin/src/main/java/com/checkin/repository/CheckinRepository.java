package com.checkin.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.checkin.entity.CheckinDetails;

@Repository
public interface CheckinRepository extends MongoRepository<CheckinDetails, Integer> {
	public CheckinDetails findByPnrNo(long pnrNo); 
}
