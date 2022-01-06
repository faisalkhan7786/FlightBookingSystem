package com.checkin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.repository.CheckinRepository;
import com.checkin.entity.CheckinDetails;
@Service
public class CheckinServiceImpl implements CheckinService {
	
	@Autowired
	private CheckinRepository checkinRepo;
	long id;
    
	@Override
	public List<CheckinDetails> getAllCheckins() {
		List<CheckinDetails> checkinDetails = new ArrayList<CheckinDetails>();
		checkinRepo.findAll().forEach(checkinDetails1 -> checkinDetails.add(checkinDetails1));
		return checkinDetails;
	}
	@Override
	public CheckinDetails findByPnrNo(long pnrNo){
		return checkinRepo.findByPnrNo(pnrNo);
		
	}

	@Override
	public void addDetails(CheckinDetails cd) {
		checkinRepo.save(cd);
		
	}

}