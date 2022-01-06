package com.fare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fare.entity.AdminDetails;
import com.fare.entity.FlightDetails;

@Repository
public interface AdminRepository extends MongoRepository<AdminDetails,Integer> {


}