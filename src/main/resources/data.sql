CREATE TABLE IF NOT EXISTS mortgage_rates (id BIGINT AUTO_INCREMENT PRIMARY KEY, maturity_period INT NOT NULL, interest_rate DECIMAL(5,2) NOT NULL, last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO mortgage_rates (maturity_period, interest_rate, last_update) VALUES (5, 2.7, CURRENT_TIMESTAMP);
INSERT INTO mortgage_rates (maturity_period, interest_rate, last_update) VALUES (10, 2.6, CURRENT_TIMESTAMP);
INSERT INTO mortgage_rates (maturity_period, interest_rate, last_update) VALUES (15, 2.5, CURRENT_TIMESTAMP);
INSERT INTO mortgage_rates (maturity_period, interest_rate, last_update) VALUES (20, 2.4, CURRENT_TIMESTAMP);
INSERT INTO mortgage_rates (maturity_period, interest_rate, last_update) VALUES (25, 2.3, CURRENT_TIMESTAMP);