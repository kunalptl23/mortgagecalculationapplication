package com.demo.app.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.demo.app.exception.MortgageCalculationException;
import com.demo.app.resource.MortgageCalculationCheckRequest;

/**
 * This is the class which validates the input of the rest operation
 */
@Component
public class MortgageCalculationValidator {

	/**
	 * This method validates the input of the MortgageCalculationCheckRequest
	 * 
	 * @param mortgageCalculationCheckRequest : object of type
	 *                                        MortgageCalculationCheckRequest
	 */
	public void validateInputs(MortgageCalculationCheckRequest mortgageCalculationCheckRequest) {
		if (mortgageCalculationCheckRequest != null) {
			validateIncome(mortgageCalculationCheckRequest.getIncome());
			validateMaturityPeriod(mortgageCalculationCheckRequest.getMaturityPeriod());
			validateLoanValue(mortgageCalculationCheckRequest.getLoanValue());
			validateHomeValue(mortgageCalculationCheckRequest.getHomeValue());
		}
	}

	/**
	 * @param homeValue : homeValue
	 */
	public void validateHomeValue(Double homeValue) {
		
		if (homeValue==null) {
			throw new MortgageCalculationException("HOME_VALUE_MISSING", HttpStatus.BAD_REQUEST,
					"Home value is missing");
		}
		if (homeValue!= null && homeValue <= 0) {
			throw new MortgageCalculationException("HOME_VALUE_INVALID", HttpStatus.BAD_REQUEST,
					"Home value is not valid");
		}
	}

	/**
	 * @param loanValue : loanValue
	 */
	public void validateLoanValue(Double loanValue) {
		
		if (loanValue==null) {
			throw new MortgageCalculationException("LOAN_VALUE_MISSING", HttpStatus.BAD_REQUEST,
					"Loan value is missing");
		}
		if (loanValue!= null && loanValue <= 0) {
			throw new MortgageCalculationException("LOAN_VALUE_INVALID", HttpStatus.BAD_REQUEST,
					"Loan value is not valid");
		}
	}

	/**
	 * @param maturityPeriod : maturityPeriod
	 */
	public void validateMaturityPeriod(Integer maturityPeriod) {
		if (maturityPeriod==null) {
			throw new MortgageCalculationException("MATURITY_PERIOD_MISSING", HttpStatus.BAD_REQUEST,
					"Maturity Period is missing");
		}
		
		if (maturityPeriod!=null && maturityPeriod <= 0) {
			throw new MortgageCalculationException("MATURITY_PERIOD_INVALID", HttpStatus.BAD_REQUEST,
					"Maturity Period is not valid");
		}
	}

	/**
	 * @param income : income
	 */
	public void validateIncome(Double income) {
		if (income==null) {
			throw new MortgageCalculationException("INCOME_MISSING", HttpStatus.BAD_REQUEST,
					"Income is missing");
		}
		
		if (income!=null && income <= 0) {
			throw new MortgageCalculationException("INCOME_INVALID", HttpStatus.BAD_REQUEST, "Income is not valid");
		}
	}
}
