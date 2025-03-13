package com.demo.app.resource;

import lombok.Data;

@Data
public class MortgageCalculationCheckResponse {
	
	private Boolean isMortgageFeasible;
	private Double monthlyCosts= 0.0d;
	
	public MortgageCalculationCheckResponse() {
		
	}
	
	public Boolean getIsMortgageFeasible() {
		return isMortgageFeasible;
	}

	public void setIsMortgageFeasible(Boolean isMortgageFeasible) {
		this.isMortgageFeasible = isMortgageFeasible;
	}

	public Double getMonthlyCosts() {
		return monthlyCosts;
	}

	public void setMonthlyCosts(Double monthlyCosts) {
		this.monthlyCosts = monthlyCosts;
	}

	public MortgageCalculationCheckResponse(Boolean isMortgageFeasible, Double monthlyCosts) {
		// TODO Auto-generated constructor stub
		this.isMortgageFeasible= isMortgageFeasible;
		this.monthlyCosts= monthlyCosts;
	}
}
