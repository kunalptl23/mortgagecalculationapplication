package com.demo.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.demo.app.dao.MortgageRateRepository;
import com.demo.app.exception.MortgageCalculationException;
import com.demo.app.resource.MortgageCalculationCheckRequest;
import com.demo.app.resource.MortgageCalculationCheckResponse;
import com.demo.app.resource.MortgageRate;

class MortgageCalculationServiceTest {

	@InjectMocks
	MortgageCalculationService underTest;
	
	@Mock
	MortgageRateRepository mortgageRateRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetInterestRates() {
		List<MortgageRate> mortgageRates = new ArrayList<>();
		
		MortgageRate mortgageRate= new MortgageRate();
		mortgageRate.setInterestRate(2.5);
		mortgageRate.setLastUpdate("2025-03-13 19:25:27.236967+01");
		mortgageRate.setMaturityPeriod(5);
	
		mortgageRates.add(mortgageRate);
		
		Mockito.when(mortgageRateRepository.findAll()).thenReturn(mortgageRates);
		assertNotNull(underTest.getInterestRates());
	}

	@Test
	void testCheckMortgage() {
		List<MortgageRate> mortgageRates = new ArrayList<>();
		
		MortgageRate mortgageRate= new MortgageRate();
		mortgageRate.setInterestRate(2.5);
		mortgageRate.setLastUpdate("2025-03-13 19:25:27.236967+01");
		mortgageRate.setMaturityPeriod(15);
	
		mortgageRates.add(mortgageRate);
		
		MortgageCalculationCheckRequest calculationCheckRequest= new MortgageCalculationCheckRequest();
		calculationCheckRequest.setHomeValue(500000d);
		calculationCheckRequest.setIncome(100000d);
		calculationCheckRequest.setMaturityPeriod(15);
		calculationCheckRequest.setLoanValue(300000d);
		
		MortgageCalculationCheckResponse calculationCheckResponse= new MortgageCalculationCheckResponse();
		calculationCheckResponse.setIsMortgageFeasible(Boolean.TRUE);
		calculationCheckResponse.setMonthlyCosts(9375d);
		
		Mockito.when(mortgageRateRepository.findAll()).thenReturn(mortgageRates);
		assertNotNull(underTest.checkMortgage(calculationCheckRequest));
	}
	
	@Test
	void testCheckMortgage_exception() {
		List<MortgageRate> mortgageRates = new ArrayList<>();
		
		MortgageRate mortgageRate= new MortgageRate();
		mortgageRate.setInterestRate(2.5);
		mortgageRate.setLastUpdate("2025-03-13 19:25:27.236967+01");
		mortgageRate.setMaturityPeriod(15);
	
		mortgageRates.add(mortgageRate);
		
		MortgageCalculationCheckRequest calculationCheckRequest= new MortgageCalculationCheckRequest();
		calculationCheckRequest.setHomeValue(500000d);
		calculationCheckRequest.setIncome(100000d);
		calculationCheckRequest.setMaturityPeriod(5);
		calculationCheckRequest.setLoanValue(300000d);
		
		Mockito.when(mortgageRateRepository.findAll()).thenReturn(mortgageRates);
		assertThrows(MortgageCalculationException.class, () -> underTest.checkMortgage(calculationCheckRequest));
	}

}
