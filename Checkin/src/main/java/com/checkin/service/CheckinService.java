package com.checkin.service;

import java.util.List;

import com.checkin.entity.CheckinDetails;

public interface CheckinService {
	
	public List<CheckinDetails> getAllCheckins(); 
	public void addDetails(CheckinDetails userDetails);
	public CheckinDetails findByPnrNo(long pnrNo);
}
