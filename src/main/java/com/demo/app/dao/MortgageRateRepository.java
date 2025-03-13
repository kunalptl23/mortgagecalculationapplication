package com.demo.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.app.resource.MortgageRate;

/**
* This is the repository class which connects with H2 database and search the data.
*/
@Repository
public interface MortgageRateRepository extends JpaRepository<MortgageRate, Long> {
	Optional<MortgageRate> findByMaturityPeriod(int maturityPeriod);
}
