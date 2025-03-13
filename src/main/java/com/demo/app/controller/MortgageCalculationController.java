package com.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.resource.MortgageCalculationCheckRequest;
import com.demo.app.resource.MortgageCalculationCheckResponse;
import com.demo.app.resource.MortgageRate;
import com.demo.app.service.MortgageCalculationService;
import com.demo.app.validator.MortgageCalculationValidator;

/**
* This is the rest controller of the mortgage calculation application.
* It helps to retrieve the interest rates or perform mortgage check.
*/
@RestController
@RequestMapping("/api")
public class MortgageCalculationController {

	@Autowired
	private MortgageCalculationService mortgageCalculationService;
	
	@Autowired
	private MortgageCalculationValidator mortgageCalculationValidator;
	
	/**
	 * This method helps to retrieve the interest rates applicable for the mortgage.
	 * @return Response entity object.
	 */
	@GetMapping("/interest-rates")
	public ResponseEntity<List<MortgageRate>> getInterestRates() {
		return ResponseEntity.ok(mortgageCalculationService.getInterestRates());
	}
	
	/**
	 * This method helps to perform the mortgage calculation check.
	 * @param mortgageCalculationCheckRequest : request object of type MortgageCalculationCheckRequest
	 * @return Response entity object.
	 */
	@PostMapping("/mortgage-check")
	public ResponseEntity<MortgageCalculationCheckResponse> checkMortgage(@RequestBody MortgageCalculationCheckRequest mortgageCalculationCheckRequest){
		mortgageCalculationValidator.validateInputs(mortgageCalculationCheckRequest);
		return ResponseEntity.ok(mortgageCalculationService.checkMortgage(mortgageCalculationCheckRequest));
	}
}
