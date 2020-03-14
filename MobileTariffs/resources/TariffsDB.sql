DROP DATABASE IF EXISTS mobile_tariffs;
CREATE DATABASE mobile_tariffs CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

SET GLOBAL time_zone = '+02:00';

CREATE TABLE mobile_tariffs.tariffs
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tariff_name VARCHAR(64) NOT NULL,
operator_name VARCHAR(64) NOT NULL,
payroll DOUBLE NOT NULL,
sms_price DOUBLE NOT NULL
);

CREATE TABLE mobile_tariffs.call_prices
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
withing_network DOUBLE NOT NULL,
outside_network DOUBLE NOT NULL,
stationary_phones DOUBLE NOT NULL,
FOREIGN KEY (id) REFERENCES tariffs(id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE mobile_tariffs.parameters
(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
favourite_numbers VARCHAR(16),
tariffing VARCHAR(16),
tariffing_connection_fee VARCHAR(16),
FOREIGN KEY (id) REFERENCES tariffs(id) ON DELETE CASCADE ON UPDATE NO ACTION
);

DELIMITER //
CREATE PROCEDURE mobile_tariffs.add_tariff(tariff_n VARCHAR(64), operator_n VARCHAR(64), pay DOUBLE, 
	price_sms DOUBLE, price_wn DOUBLE, price_on DOUBLE, price_sp DOUBLE,
	parameter_fn VARCHAR(16), parameter_t VARCHAR(16), parameter_tcf VARCHAR(16))
BEGIN
	INSERT INTO tariffs (tariff_name, operator_name, payroll, sms_price) 
		VALUES (tariff_n, operator_n, pay, price_sms);
	INSERT INTO call_prices(id, withing_network, outside_network, stationary_phones) 
		VALUES(last_insert_id(), price_wn, price_on, price_sp);
	INSERT INTO parameters(id, favourite_numbers, tariffing, tariffing_connection_fee) 
		VALUES(last_insert_id(), parameter_fn, parameter_t, parameter_tcf);
END //
DELIMITER ;

