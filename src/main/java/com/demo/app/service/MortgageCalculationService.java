package com.demo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.app.dao.MortgageRateRepository;
import com.demo.app.exception.MortgageCalculationException;
import com.demo.app.resource.MortgageCalculationCheckRequest;
import com.demo.app.resource.MortgageCalculationCheckResponse;
import com.demo.app.resource.MortgageRate;

/**
* This is the service class which contains the business logic of the application.
*/
@Service
public class MortgageCalculationService {

	@Autowired
	private MortgageRateRepository mortgageRateRepository;

	/**
	 * This method helps to retrieve the interest rates applicable for the mortgage.
	 * @return List of Mortgage Rate
	 */
	public List<MortgageRate> getInterestRates() {
		return (List<MortgageRate>) mortgageRateRepository.findAll();
	}
	
	/**
	 * This method helps to perform the mortgage calculation check.
	 * @param mortgageCalculationCheckRequest : request object of type MortgageCalculationCheckRequest
	 * @return MortgageCalculationCheckResponse : response object of type MortgageCalculationCheckResponse
	 */
	public MortgageCalculationCheckResponse checkMortgage(MortgageCalculationCheckRequest mortgageCalculationCheckRequest) {
		MortgageCalculationCheckResponse mortgageCalculationCheckResponse = null;
		
		List<MortgageRate> mortgageRates = (List<MortgageRate>) mortgageRateRepository.findAll();
	
        Double loanValue = mortgageCalculationCheckRequest.getLoanValue();
        Double homeValue = mortgageCalculationCheckRequest.getHomeValue();
        Double income= mortgageCalculationCheckRequest.getIncome();
        Integer maturityPeriod = mortgageCalculationCheckRequest.getMaturityPeriod();

        if (loanValue <= 4 * income  && loanValue <= homeValue) {
        	mortgageCalculationCheckResponse = responseWhenMortgageIsFeasible(mortgageRates, loanValue, maturityPeriod);
        }else {
        	return responseWhenMortgageIsNotFeasible();
        }
        return mortgageCalculationCheckResponse;
		
	}

	/**
	 * This method performs the calculation and prepare response when mortgage is feasible based on conditions
	 * @param mortgageRates : list of mortgage rates
	 * @param loanValue : loan value amount
	 * @param maturityPeriod : maturity period
	 * @return MortgageCalculationCheckResponse : response object of type MortgageCalculationCheckResponse
	 */
	private MortgageCalculationCheckResponse responseWhenMortgageIsFeasible(List<MortgageRate> mortgageRates,
			Double loanValue, Integer maturityPeriod) {
		MortgageCalculationCheckResponse mortgageCalculationCheckResponse= new MortgageCalculationCheckResponse();
		mortgageCalculationCheckResponse.setIsMortgageFeasible(Boolean.TRUE);
		
		Double interestRate = mortgageRates.stream()
		        .filter(rate -> rate.getMaturityPeriod() == maturityPeriod)
		        .findFirst()
		        .orElseThrow(() -> new MortgageCalculationException("INTEREST_RATE_NOT_FOUND",HttpStatus.BAD_REQUEST,"Interest rate not found for this period."))
		        .getInterestRate();

		// Calculate monthly cost for provided loan value, interest rate and applicable maturity Period
		Double calculatedMonthlyCosts = (loanValue * interestRate * maturityPeriod / 100) / 12;
		mortgageCalculationCheckResponse.setMonthlyCosts(calculatedMonthlyCosts);
		return mortgageCalculationCheckResponse;
	}

	/**
	 * This method generates the response when mortgage is not feasible
	 * @return MortgageCalculationCheckResponse : response object of type MortgageCalculationCheckResponse
	 */
	private MortgageCalculationCheckResponse responseWhenMortgageIsNotFeasible() {
		MortgageCalculationCheckResponse mortgageCalculationCheckResponse= new MortgageCalculationCheckResponse();
		mortgageCalculationCheckResponse.setIsMortgageFeasible(Boolean.FALSE);
		return mortgageCalculationCheckResponse;
	}
}
