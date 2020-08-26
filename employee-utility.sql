CREATE TABLE `bank_master` (
  `bank_id` int NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `address` varchar(2555) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `ifsc_code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Bank Master table';

CREATE TABLE `emp_details` (
  `emp_id` int NOT NULL,
  `emp_name` varchar(100) DEFAULT NULL,
  `emp_address` varchar(200) DEFAULT NULL,
  `emp_role` varchar(20) DEFAULT NULL,
  `doj` datetime DEFAULT NULL,
  `bank_id` int NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `bank_id_idx` (`bank_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `emp_login` (
  `emp_id` int NOT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `emp_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `emp_salary_details` (
  `account_no` varchar(20) NOT NULL,
  `bank_id` int DEFAULT NULL,
  `year_month` varchar(6) DEFAULT NULL,
  `gross_salary` float DEFAULT NULL,
  `net_Salary` float DEFAULT NULL,
  `tax_component` float DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  PRIMARY KEY (`account_no`),
  KEY `bank_id_idx` (`bank_id`),
  KEY `bank_id_idx_1` (`bank_id`) /*!80000 INVISIBLE */,
  KEY `bank_id_idx1` (`bank_id`) /*!80000 INVISIBLE */,
  KEY `emp_id_idx` (`emp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

###Insertion starting

insert into bank_master values(1,'HDFC Bank Ltd','Nungambakkam','Nungambakkam','Chennai','HDFC0000082');
insert into bank_master values(2, 'HDFC Bank Ltd','Delhi1','Connaught','New Delhi','HDFC0000001');
insert into bank_master values(3, 'ICICI Bank Pvt Ltd','Boriveli','Borivel','Mumbai','ICI000100');
insert into bank_master values(4, 'State Bank of India','Kolkatta','Kolkatta','Kolkatta','SBI0030010');
insert into bank_master values(5, 'State Bank of India','GandhiNagar','GandhiNagar','Gujarat','SBI0010416');
commit;
#---
insert into emp_details values(1000001,'Ganapathi','Chennai','ASSC','2010-06-10',1);
insert into emp_details values(1000002,'Murari','Kolkatta','ASSC','2010-12-29',4);
insert into emp_details values(1000003,'Dilpreet','New Delhi','AST','2014-01-04',2);
insert into emp_details values(1000004,'Murugesh','Mumbai','ITA','2016-09-17',1);
insert into emp_details values(1000005,'Ramcharan','Ahemedabad','ASE','2019-03-13',5);
commit;
#----
insert into emp_salary_details values('12367670002312',1,'202008',100000,80000,20000,1000001);
insert into emp_salary_details values('4556234234',1,'202008',100000,70000,30000,1000002);
insert into emp_salary_details values('5642342342344',1,'202008',110000,80000,30000,1000003);
insert into emp_salary_details values('8978455664',1,'202008',200000,170000,30000,1000004);
insert into emp_salary_details values('23424323400',1,'202008',2200000,190000,30000,1000005);
commit;
#-----
insert into emp_login values(1000001,'Ganapathi','ganapathi','active');
insert into emp_login values(1000002,'Murari','murari','active');
insert into emp_login values(1000003,'Dilpreet','dilpreet','active');
insert into emp_login values(1000004,'Murugesh','murugesh','active');
insert into emp_login values(1000005,'Ramcharan','ramcharan','active');
commit;
#---
#select * from emp_login;

#select d.emp_id,d.emp_name,d.emp_address,d.emp_role,d.doj,b.bank_name,s.account_no,s.year_month,s.gross_salary,s.net_salary,s.tax_component,e.login_name,e.password from emp_details d,emp_salary_details s,emp_login e,bank_master b where d.emp_id=s.emp_id and d.emp_id=e.emp_id and s.bank_id=b.bank_id;
DELIMITER //
CREATE PROCEDURE FIND_EMPLOYEE_BY_ID(IN emp_id_in INT)
BEGIN 
    select d.emp_id,d.emp_name,d.emp_address,d.emp_role,d.doj,
    b.bank_name,s.account_no,s.year_month,
    s.gross_salary,s.net_salary,s.tax_component,
    e.login_name,e.password,b.ifsc_code from 
    emp_details d,emp_salary_details s,
    emp_login e,bank_master b 
    where d.emp_id=s.emp_id 
    and d.emp_id=e.emp_id 
    and s.bank_id=b.bank_id
    and e.emp_id = emp_id_in;
END //
DELIMITER ;