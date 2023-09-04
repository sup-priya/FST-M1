REM   Script: SQL_Activity1_2_3
REM   SQL Activity 1 to Activity 3

DROP TABLE salesman;

CREATE TABLE salesman (salesman_id int PRIMARY KEY,salesman_name varchar2(32) UNIQUE NOT NULL,salesman_city varchar2(32) NOT NULL,commission int);

DESCRIBE salesman


INSERT INTO salesman VALUES(5001,'James Hoog','New York',15);

INSERT ALL 
    INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris' AND commission>12;

SELECT * FROM salesman WHERE commission BETWEEN 11 AND 13 or salesman_city = 'New York';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

