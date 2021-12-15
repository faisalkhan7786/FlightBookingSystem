package com.search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.search.repository.SearchRepository;
import com.search.service.SearchServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchApplicationTests 
{
	@Autowired
	private SearchServiceImpl searchService;
	@MockBean
	private SearchRepository searchRepo;
	
	@Test
	@DisplayName("Testing whether flight details database is empty")
	public void getAllDetailsTest1() {
		List<com.search.entity.FlightDetails> details = searchService.getAllDetails();
		assertTrue(details.isEmpty());
	}
	
	/*
	 * @Test
	 * 
	 * @DisplayName("Testing whether flight details database is empty") public void
	 * getDetailsByFlightNoTest2() { List<com.search.entity.FlightDetails> details =
	 * searchService.getDetailsByFlightNo(); assertTrue(details.isEmpty()); }
	 */
}