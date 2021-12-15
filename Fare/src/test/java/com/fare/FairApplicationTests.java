package com.fare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.fare.entity.FlightDetails;
import com.fare.repository.FareRepository;
import com.fare.service.FareServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class FareApplicationTests {

	@Autowired
	private FareServiceImpl fareService;
	@MockBean
	private FareRepository fareRepo;

	@Test
	@DisplayName("Testing whether flight details database is empty")
	public void getAllDetailsTest1() {
		List<FlightDetails> details = fareService.getAllDetails();
		assertTrue(details.isEmpty());
	}

	@Test
	@DisplayName("Testing whether getAllDetails method is returning the records of db")
	public void getAllDetailsTest2() { // Added flight details
		List<FlightDetails> detailsList = new ArrayList<FlightDetails>();
		FlightDetails details = new FlightDetails(123, "Mumbai", "Pune", "9:00AM", "5:00PM", "8H", 50, 1000, 750, 500,
				"1-JAN-2022");
		detailsList.add(details);
// checking whether it returns correct values
		when(fareRepo.findAll()).thenReturn(detailsList);
		List<FlightDetails> detailsListNew = fareService.getAllDetails();
		assertEquals(1, detailsListNew.size());
	}

	@Test
	@DisplayName("Testing addFlightDetails method")
	public void addFlightDetailsTest1() {
// Added flight details
		FlightDetails details = new FlightDetails(124, "Delhi", "Banglore", "9:00AM", "5:00PM", "8H", 51, 2000, 1750, 5300,
				"2-JAN-2022");
		fareService.addFlightDetails(details);
// checking whether flight details are added or not
		verify(fareRepo, times(1)).save(details);
	}
	
}