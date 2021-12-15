package com.search.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.search.entity.PaymentDetails;

@Repository
public interface UserPaymentRepository extends MongoRepository<PaymentDetails, Long>
{

}
