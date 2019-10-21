INSERT INTO Employees (id, first_name, last_name, email) values (1001, 'Mickey', 'Mouse', 'Mickey@gmail.com');
INSERT INTO Employees (id, first_name, last_name, email) values (1002, 'Minnie', 'Mouse', 'Minnie@gmail.com');

INSERT INTO EmployeeAddress (id,empid, county, city, state) values (1,1001, 'West County', 'St. Louis', 'MO');
INSERT INTO EmployeeAddress (id,empid, county, city, state) values (2,1002, 'North County', 'St. Louis', 'MO');

INSERT INTO STUDENTS (BRANCHID,STUDENTID,FIRSTNAME,LASTNAME,DOB) values ('B00',101,'Joe','k','2000-10-15');
INSERT INTO STUDENTS (BRANCHID,STUDENTID,FIRSTNAME,LASTNAME,DOB) values ('B00',102,'Rose','G','1990-05-30');
INSERT INTO STUDENTS (BRANCHID,STUDENTID,FIRSTNAME,LASTNAME,DOB) values ('B01',101,'John','k','1980-02-11');


INSERT INTO FULLTIMESTUDENTS (STUDENTID,FIRSTNAME,LASTNAME,DOB,EMAIL,ATTENDANCE) values (101,'John','k','1980-02-11','John@abc.in',65);
INSERT INTO FULLTIMESTUDENTS (STUDENTID,FIRSTNAME,LASTNAME,DOB,EMAIL,ATTENDANCE) values (102,'Kate','k','1990-02-11','Kate@abc.in',60);
INSERT INTO FULLTIMESTUDENTS (STUDENTID,FIRSTNAME,LASTNAME,DOB,EMAIL,ATTENDANCE) values (103,'Emma','k','1970-02-11','Emma@abc.in',62);

INSERT INTO PARTTIMESTUDENTS (STUDENTID,FIRSTNAME,LASTNAME,DOB,EMAIL,placeOfWork) values (104,'Rose','k','1970-02-11','Emma@abc.in','Accenture');

INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (101,'DEEP','123456',1);
INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (102,'SHAMILI','123456',1);
INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (103,'MICKEY','123456',1);

INSERT INTO USER_ROLE (USER_ID, ROLE) VALUES (101,'ROLE_USER');
INSERT INTO USER_ROLE (USER_ID, ROLE) VALUES (102,'ROLE_USER');
INSERT INTO USER_ROLE (USER_ID, ROLE) VALUES (103,'ROLE_ADMIN');
INSERT INTO USER_ROLE (USER_ID, ROLE) VALUES (102,'ROLE_ADMIN');

INSERT INTO BankAccount (id,empid, accNo, bankName, branch) values (1,1001, 'SBI100100', 'SBI', 'Hyderabad');
INSERT INTO BankAccount (id,empid, accNo, bankName, branch) values (2,1001, 'SBI100101', 'SBI', 'Mysore');
INSERT INTO BankAccount (id,empid, accNo, bankName, branch) values (3,1002, 'SBI100102', 'SBI', 'Hyderabad');
INSERT INTO BankAccount (id,empid, accNo, bankName, branch) values (4,1002, 'SBI100103', 'SBI', 'Hyderabad');

INSERT INTO Department (departmentId, departmentName) values (9001, 'Sales');
INSERT INTO Department (departmentId, departmentName) values (9002, 'Finance');
INSERT INTO Department (departmentId, departmentName) values (9003, 'Cultural');
INSERT INTO Department (departmentId, departmentName) values (9004, 'Security');

INSERT INTO Employee_Department (empid, departmentid) values (1001,9001);
INSERT INTO Employee_Department (empid, departmentid) values (1002,9002);
INSERT INTO Employee_Department (empid, departmentid) values (1001,9002);
INSERT INTO Employee_Department (empid, departmentid) values (1002,9003);
INSERT INTO Employee_Department (empid, departmentid) values (1001,9004);


INSERT INTO XDepartment (xdepartmentId, xdepartmentName, xdepartmentType) values (9001, 'Sales', 'Sales');
INSERT INTO XDepartment (xdepartmentId, xdepartmentName, xdepartmentType) values (9002, 'Sales Infy', 'Sales');
INSERT INTO XDepartment (xdepartmentId, xdepartmentName, xdepartmentType) values (9003, 'Security', 'Security');
INSERT INTO XDepartment (xdepartmentId, xdepartmentName, xdepartmentType) values (9004, 'Security Infy', 'Security');


INSERT INTO SalesDepartment (xdepartmentId, monthlySales) values (9001, 500);
INSERT INTO SalesDepartment (xdepartmentId, monthlySales) values (9002, 20);
INSERT INTO SecurityDepartment (xdepartmentId, securityBreechCount) values (9003, 26);
INSERT INTO SecurityDepartment (xdepartmentId, securityBreechCount) values (9004, 46);
