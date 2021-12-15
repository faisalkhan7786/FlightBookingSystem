package com.booking.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booking.entity.UserDetails;

@Repository
public interface UserRepository extends MongoRepository<UserDetails, Integer>
{

}