package com.demo.app.resource;

import lombok.Data;

@Data
public class MortgageCalculationCheckRequest {
	
	private Double income;
	private Integer maturityPeriod;
	private Double loanValue;
	private Double homeValue;
	
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Integer getMaturityPeriod() {
		return maturityPeriod;
	}
	public void setMaturityPeriod(Integer maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}
	public Double getLoanValue() {
		return loanValue;
	}
	public void setLoanValue(Double loanValue) {
		this.loanValue = loanValue;
	}
	public Double getHomeValue() {
		return homeValue;
	}
	public void setHomeValue(Double homeValue) {
		this.homeValue = homeValue;
	}
	
}
