package com.payment.service;
import java.nio.charset.StandardCharsets;
import java.util.List;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.payment.entity.PaymentDetails;
import com.payment.entity.UserDetails;
import com.payment.exception.ResourceNotFoundException;
import com.payment.repository.UserPaymentRepository;
import com.payment.repository.UserRepository;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Service
public class PaymentServiceImpl implements PaymentService
{
	int id;

	@Autowired
	public EmailService emailService;
	
	@Autowired
	UserPaymentRepository userPayRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<PaymentDetails> getAll() {
		List<PaymentDetails> payDetails=userPayRepo.findAll();
		return payDetails;
	}
	
	@Override
	public String proceedToPay(PaymentDetails payment)
	{
		long pnrNo=payment.getPnrNo();
		List<UserDetails> det=userRepo.findAll();
		 for(UserDetails x:det) {
				if(x.getPnrNo()==pnrNo) {
					id=x.getId();
				}	
		}
		userRepo.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("Cannot proceed the payment request as booking is not done with PNR Number : "+pnrNo));
		userPayRepo.save(payment); 
		//For email notification after successful payment
		try { sendEmail(payment); } catch (AddressException e) { 
			 e.printStackTrace(); }
		return ("Your payment for PNR Number "+payment.getPnrNo()+" is Successful...!!!");
		 
	}
	
	@Override
	public String deletePayment(long pnrNo) {
		userPayRepo.deleteById(pnrNo);
		return "You payment for "+pnrNo+ " will be credited to your account within 7 days..";
	}
	
	//to update payment field in user details after successful payment
	@Override
	 public void updateUserPaymentDetails(long pnrNo)
	 {
		  List<UserDetails> details=userRepo.findAll();
		  for(UserDetails x:details) {
			  //System.out.println(x);
				if(x.getPnrNo()==pnrNo) {
					x.setPayment("Successful");
					userRepo.save(x);
				}
		  }
	  }
	  
	//For email notification after successful payment
	public void sendEmail(PaymentDetails payment) throws AddressException{
		final Email email = DefaultEmail.builder()
			      .from(new InternetAddress("shahfaisher@gmail.com"))
			      .replyTo(new InternetAddress("shahfaisher@gmail.com"))
			      .to(Lists.newArrayList(new InternetAddress("shahfaisher@gmail.com")))
			      .subject("Payment is Successful")
			      .body("Your payment for PNR Number "+payment.getPnrNo()+" is Successful...!!!")
			      .encoding("UTF-8")
			      .build();
			 emailService.send(email);
	}
}
	
	
