-- insert a new record in the vendors table - all columns are specified
insert into Vendors values (1000, 'Intel');

-- insert inth the vendors table - only the name column is specified (id is autoincrement)
insert into Vendors(Name) values ('NVidia');

-- insert into the vendors table using select
insert into Vendors(Name) (select 'Google' );


-- why can not insert into certificates table ???
insert into certificates (name, VendorId) values ('SQL',1234)

-- why can not insert into employees table ???
insert into employees (name) values ('Hristo Topuzov')


-- update vendor with ID = 1000
update Vendors SET Name = CONCAT(Name, ' %') where Id = 1000;

-- delete vendor with name 'NVidia'
delete from Vendors where Name = 'NVidia';

-- Insert a new employee with name 'Richard Stone', e-mail 'rstone@outlook.com', titleid 16 ,departmentid 1, phone 123456789, salary 1000 and hiredate 2014-01-01
insert into employees (name, titleid,departmentid,email,phone, salary,hiredate) values ('Richard Stone',16,1,'rstone@outlook.com',123456789,1000,'2014-01-01')

-- Change the e-mail of the employee 'Richard Stone' to 'rstone@sample.com'
update employees
set email = 'rstone@gmail.com'
where name = 'Richard Stone'

-- Delete all employees whose family name starts with 'Rich'
delete from employees 
where name like 'Rich%'

-- Increase the salary with 20% of all Senior Quality Assurance Engineer heared before '2010-01-01'
update employees e
join titles t on t.Id = e.TitleId 
set salary = e.salary*1.2
where t.name = 'Quality Assurance Engineer'
and hiredate < '2015-01-01'

-- why can not delete employee with id = 1 ???
delete from employees
where id = 1

-- why can not update employeeId into employee_skills table???
update employee_skills
set employeeid = 1000
where id = 1


-- creating the Locations1 ( Id PRIMARY KEY,  City  UNIQUE,  Country default 'Bulgaria',  DateAdded ,  Status ,  ManagerId FOREIGN KEY) table with unnamed constraints as part of the column definitions
create table locations1 (
  Id INT PRIMARY KEY,
  City VARCHAR(100) NOT NULL UNIQUE,
  Country VARCHAR(100)  default 'Bulgaria',
  DateAdded DATE,
  Status VARCHAR(10) ,
  ManagerId INT REFERENCES Employees(Id)
);

-- creating the locations2  ( Id PRIMARY KEY,  City  UNIQUE,  Country default 'Bulgaria',  DateAdded ,  Status ,  ManagerId FOREIGN KEY) table with constraints as part of the table definition
create table locations2 (
  Id INT,
  City VARCHAR(100) NOT NULL,
  Country VARCHAR(100) DEFAULT 'Bulgaria',
  DateAdded DATE,
  Status VARCHAR(10),
  ManagerId INT,
  CONSTRAINT c_locations2_PK PRIMARY KEY(Id),
  CONSTRAINT c_locations2_City_Unq UNIQUE (City),
  CONSTRAINT loc2_fk_empl FOREIGN KEY(ManagerId) REFERENCES Employees(Id)
);

-- creating the locations3 ( Id PRIMARY KEY,  City  UNIQUE,  Country default 'Bulgaria',  DateAdded ,  Status ,  ManagerId FOREIGN KEY) table with constraints outside of the table definition
create table locations3 (
  Id INT,
  City VARCHAR(100),
  Country VARCHAR(100) DEFAULT 'Bulgaria',
  DateAdded DATE,
  Status VARCHAR(10),
  ManagerId INT
);

alter table Locations3 add constraint c_locations3_PK PRIMARY KEY(Id);
alter table Locations3 add constraint c_locations3_City_Unq UNIQUE (City);
alter table Locations3 add constraint c_locations3_fk FOREIGN KEY(ManagerId) REFERENCES Employees(Id);
alter table Locations3 modify City varchar(100) NOT NULL;

-- drop UNIQUE constraint from the Locations3 table
alter table Locations3 drop index c_locations3_City_Unq;


-- drop FOREIGN KEY constraint from the Locations3 table
alter table Locations3 drop FOREIGN KEY c_locations3_fk;


-- add a new column Capacity to Locations3
alter table Locations3 add Capacity INT;

-- change the type of the Capacity in Locations2
alter table Locations3 modify Capacity DOUBLE(5, 2);

-- drop the BuildingCapacity column
alter table Locations3 drop column BuildingCapacity;

-- dropping tables
drop table locations1;
drop table locations2;
drop table locations3;

