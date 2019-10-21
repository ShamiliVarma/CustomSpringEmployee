CREATE TABLE Employees (
  id int(10) NOT NULL AUTO_INCREMENT,
  first_name varchar(20) NOT NULL,
  last_name varchar(15) NOT NULL,
  email varchar(100) NOT NULL,
  PRIMARY KEY (id),
);
CREATE TABLE EmployeeAddress (
  id int(10) NOT NULL AUTO_INCREMENT,
  empid int(10) NOT NULL,
  county varchar(30) NOT NULL,
  city varchar(30) NOT NULL,
  state varchar(30) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (empid) REFERENCES Employees(id)
);

CREATE TABLE BankAccount (
  id int(10) NOT NULL AUTO_INCREMENT,
  empid int(10) NOT NULL,
  accNo varchar(20) NOT NULL,
  bankName varchar(30) NOT NULL,
  branch varchar(30) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (empid) REFERENCES Employees(id)
);

CREATE TABLE Department (
  departmentId int(10) NOT NULL AUTO_INCREMENT,
  departmentName varchar(30) NOT NULL,
  PRIMARY KEY (departmentId),
);

CREATE TABLE Employee_Department (
  empId int(10) NOT NULL,
  departmentId int(10) NOT NULL,
  PRIMARY KEY (empId,departmentId),
  FOREIGN KEY (empid) REFERENCES Employees(id),
  FOREIGN KEY (departmentId) REFERENCES Department(departmentId)
);


CREATE TABLE USERS (
  id int(10) NOT NULL AUTO_INCREMENT,
  USERNAME varchar(30) NOT NULL,
  PASSWORD varchar(30) NOT NULL,
  ENABLED int(1) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE USER_ROLE (
  USER_ID int(10) NOT NULL,
  ROLE varchar(30) NOT NULL,
  FOREIGN KEY (USER_ID) REFERENCES USERS(id)
);


CREATE TABLE STUDENTS (
  BRANCHID varchar(10) NOT NULL,
  STUDENTID int(10) NOT NULL,
  FIRSTNAME varchar(30) NOT NULL,
  LASTNAME varchar(30) NOT NULL,
  DOB DATE NOT NULL,
  PRIMARY KEY (BRANCHID,STUDENTID)
);


CREATE TABLE FULLTIMESTUDENTS (
  STUDENTID int(10) NOT NULL,
  FIRSTNAME varchar(30) NOT NULL,
  LASTNAME varchar(30) NOT NULL,
  email varchar(100) NOT NULL,
  DOB DATE NOT NULL,
  ATTENDANCE int(10) NOT NULL,
  PRIMARY KEY (STUDENTID)
);
CREATE TABLE PARTTIMESTUDENTS (
  STUDENTID int(10) NOT NULL,
  FIRSTNAME varchar(30) NOT NULL,
  LASTNAME varchar(30) NOT NULL,
  email varchar(100) NOT NULL,
  DOB DATE NOT NULL,
  PlaceOfWork varchar(30) NOT NULL,
  PRIMARY KEY (STUDENTID)
);


CREATE TABLE XDepartment(
xdepartmentId int(10) NOT NULL AUTO_INCREMENT,
  xdepartmentName varchar(30) NOT NULL,
  xdepartmentType varchar(30) NOT NULL,
  PRIMARY KEY (xdepartmentId)
);

CREATE TABLE SalesDepartment(
xdepartmentId int(10) NOT NULL,
monthlySales int(10) NOT NULL,
 FOREIGN KEY (xdepartmentId) REFERENCES XDepartment(xdepartmentId)
);
CREATE TABLE SecurityDepartment(
xdepartmentId int(10) NOT NULL,
securityBreechCount int(10) NOT NULL,
 FOREIGN KEY (xdepartmentId) REFERENCES XDepartment(xdepartmentId)
);