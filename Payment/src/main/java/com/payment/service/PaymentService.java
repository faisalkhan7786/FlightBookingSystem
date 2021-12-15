package com.payment.service;
import java.util.List;

import com.payment.entity.PaymentDetails;

public interface PaymentService 
{
	public List<PaymentDetails> getAll();
	public String proceedToPay(PaymentDetails payment);
	public String deletePayment(long pnrNo);
	public void updateUserPaymentDetails(long pnrNo);
}
