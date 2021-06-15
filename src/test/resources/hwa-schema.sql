drop table if exists car CASCADE;
drop table if exists modification CASCADE;

create table car 
(
	`car_id` integer AUTO_INCREMENT PRIMARY KEY, 
	`bhp` integer, 
	`bought_mileage` bigint, 
	`colour` varchar(255), 
	`fuel` varchar(255), 
	`make` varchar(255), 
	`model` varchar(255), 
	`trans` varchar(255), 
	`year` integer, 
	primary key (`car_id`)
);

create table modification 
(
	`mod_id` integer AUTO_INCREMENT PRIMARY KEY, 
	`install_date` varchar(255), 
	`install_mileage` bigint, 
	`mod_desc` varchar(255), 
	`mod_name` varchar(255), 
	`mod_price` double, 
	`car_car_id` integer, 
	primary key (`mod_id`)
);
