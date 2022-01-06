package com.payment.controller;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.PaymentDetails;
import com.payment.repository.UserPaymentRepository;
import com.payment.service.PaymentService;
import com.payment.service.PaymentServiceImpl;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/pay")
public class PaymentController 
{
	@Autowired
	PaymentService payService;
	
	@GetMapping("/all")
	@ApiOperation(value="Get all users who completed payment")
	public List<PaymentDetails> getAll()
	{
		return payService.getAll();
	}
	
	 @PostMapping("/add") 
	 @ApiOperation(value="Inorder to proceed to payment")
	 public String addPaymentDetails(@Valid @RequestBody PaymentDetails payment) 
	 { 
		long pnrNo=payment.getPnrNo();
		payService.proceedToPay(payment); 
		payService.updateUserPaymentDetails(payment.getPnrNo());
		String sentMsg="Your payment is successful";
		return sentMsg;  
	 }
	 //Deleting flightTicket
	 @RequestMapping(value = "/cancel/{pnrNo}", method = { RequestMethod.GET, RequestMethod.DELETE })
	 @ApiOperation(value = "Inorder to cancel your payment")
	 public String deletePaymentDetails(@PathVariable long pnrNo) {
	 return payService.deletePayment(pnrNo);
	 }

}