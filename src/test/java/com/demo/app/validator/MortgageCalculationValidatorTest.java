package com.demo.app.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.demo.app.exception.MortgageCalculationException;
import com.demo.app.resource.MortgageCalculationCheckRequest;

class MortgageCalculationValidatorTest {
	
	@InjectMocks
	MortgageCalculationValidator underTest;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidateInputs() {
		MortgageCalculationCheckRequest calculationCheckRequest= new MortgageCalculationCheckRequest();
		calculationCheckRequest.setHomeValue(500000d);
		calculationCheckRequest.setIncome(100000d);
		calculationCheckRequest.setMaturityPeriod(5);
		calculationCheckRequest.setLoanValue(300000d);
		underTest.validateInputs(calculationCheckRequest);
	}
	
	@Test
	void testValidateHomeValueInvalid() {
		assertThrows(MortgageCalculationException.class, () -> underTest.validateHomeValue(0d));
	}
	
	@Test
	void testValidateIncomeInvalid() {
		assertThrows(MortgageCalculationException.class, () -> underTest.validateIncome(0d));
	}
	
	@Test
	void testValidateMaturityPeriodInvalid() {
		assertThrows(MortgageCalculationException.class, () -> underTest.validateMaturityPeriod(0));
	}
	
	@Test
	void testValidateLoanValueInvalid() {
		assertThrows(MortgageCalculationException.class, () -> underTest.validateLoanValue(0d));
	}

	@Test
	void testValidateHomeValueNull() {
		assertThrows(MortgageCalculationException.class, () -> underTest.validateHomeValue(null));
	}
	
	@Test
	void testValidateIncomeNull() {
		assertThrows(MortgageCalculationException.class, () -> underTest.validateIncome(null));
	}
	
	@Test
	void testValidateMaturityPeriodNull() {
		assertThrows(MortgageCalculationException.class, () -> underTest.validateMaturityPeriod(null));
	}
	
	@Test
	void testValidateLoanValueNull() {
		assertThrows(MortgageCalculationException.class, () -> underTest.validateLoanValue(null));
	}
}
