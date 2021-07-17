-- create a simple view on the Certificates table that 
-- retrieves all Certificates that have 'Java' in their name
create view java_certificates as
select * from certificates
where Name like '%Java%';

-- try to insert the following record in the above view:
 insert into java_certificates(Name, VendorId) values ('MCP C#.NET', 2);
-- it is inserted but not visible from the view


-- create a view on the Certificates and Employees table that 
-- retrieves all Employyees that have certificate "Microsoft SQL Server 2008 Certified T-SQL Developer"
create view V_employees_certificates as
select e.id EmployeeID ,e.name EmployeeName, c.name  CertificateName
from certificates c
join employee_certificates ec on c.id = ec.CertificateId
join employees e on e.Id = ec.EmployeeId
where c.Name like 'Microsoft SQL Server 2008 Certified T-SQL Developer';


-- try to insert the following record in the above view:
 insert into employees_certificates(EmployeeName, CertificateName) values ('Teodor Jivkov','Microsoft SQL Server 2008 Certified T-SQL Developer');


-- create a simple view on the Certificates, Employees and Vacantions tables that 
-- retrieves all Employyees that have certificate "Microsoft SQL Server 2008 Certified T-SQL Developer" and requestdate of last approved vacantion

create view employees_certificates_vacantions as
select ec.EmployeeID ,ec.EmployeeName, ec.CertificateName, max(v.requestdate)
from V_employees_certificates ec
join vacations v on v.employeeid = ec.employeeid
where v.Status = 'APPROVED'
group by ec.EmployeeID ,ec.EmployeeName, ec.CertificateName


-- drop previous views




-- creating a BEFORE trigger on update operations on the Vendors table
create table messages(msg text);

delimiter \\
create trigger trigger1 after update on Vendors
FOR EACH ROW
begin
  insert into messages(msg) select concat('trigger1 executed', old.id, new.id);
end \\

-- try to insert into the Vendors table
 insert into Vendors(Id, Name) values (10011, 'SampleVendor');

-- try to update a row into the Vendors table
update Vendors
set name = 'SampleVendor1'
where id = 10011

-- creating a BEFORE trigger on DML operations on the Vendors table for each row that 
-- has an ID greater than 10
delimiter \\
create trigger trigger2 before update on Vendors
for each row
begin
	if (New.Id > 10) then
		insert into messages(msg) select concat('trigger2 executed', new.id);
	end if;
end \\

-- try to update the Vendors table
 update Vendors set Name = 'SampleVendor11' where Id = 1001


-- drop previous triggers
drop trigger trigger1;
drop trigger trigger2;



-- create sample table person(  id ,  name )
CREATE TABLE person
(
  id INT,
  name varchar(20)
)

-- create sample table old_person(  id ,  name, modified )
CREATE TABLE old_person
(
  id INT,
  name varchar(20),
  modified DATETIME
)

-- create trigger to populate in old_person the value of person before it actually changes
delimiter \\
CREATE TRIGGER Person_Trigger before update on person
FOR EACH ROW BEGIN
  INSERT INTO old_person(id, name, modified) 
  VALUES (OLD.id, OLD.name, NOW());
END\\



-- insert a row into person table 
INSERT INTO person VALUES (1,'TADA');

-- update all row in person table
UPDATE person SET name = 'FOO';


-- drop triggers
drop trigger Person_Trigger;




-- insert 3 000 000 rows into employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'1'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'2'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'3'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'4'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'5'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'6'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'7'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'8'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'9'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

 insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'a1'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'a2'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'a3'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'a4'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'a5'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'a6'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'a7'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees

    insert into employees (Name,TitleId, DepartmentId,Email,Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId)
select Name,TitleId, DepartmentId,concat(Email,'a8'),Phone,Salary,CV,HireDate,EndDate,ReferrerId,ManagerId
from employees



-- select * from employees where salary = 2000
select *
from employees
where salary = 2000

-- create index salary_ind on Employees(Salary);
create index salary_ind on Employees(Salary);


-- select * from employees where salary = 2000
select *
from employees
where salary = 2000


-- unique index on the Name and Alias columns from the Titles table
create unique index name_alias_ind on titles(name, alias);

-- drop the salary index;
drop index salary_ind on Employees;




-- simple stored procedure that prints a text
DELIMITER //
create procedure print_text()
begin
  select 'Anonymous block executed.';
end//

-- stored procedure with IN, OUT and INOUT parameters
DELIMITER //
CREATE PROCEDURE sample(IN param1 INT, 
                        OUT param2 INT, 
                        INOUT param3 INT)
BEGIN
    set param1 = 1;
    set param2 = 2;
    set param3 = 3;    
END//

-- set 3 user variables to 0
set @var1 = 0;
set @var2 = 0;
set @var3 = 0;
-- call stored routine 'sample'
call sample(@var1, @var2, @var3);

-- print value of variables
select @var1;
select @var2;
select @var3;




-- creating stored procedure SP_CHECK_DATE
DELIMITER //
CREATE PROCEDURE sp_check_date(p_date datetime, out p_state varchar(100))
begin

  set @v_hour = hour(p_date);
  set @v_day_of_week = weekday(p_date);
  if @v_hour between 8 and 18
    and @v_day_of_week in (1, 2, 3, 4, 5)
  then
    set p_state = 'office hours';
  else
    set p_state = 'out of office hours';
  end if;
end//

-- call the SP_CHECK_DATE procedure and print the value of @result

call sp_check_date(now(), @result);
select @result;


-- example of a CASE statement inside a stored procedure
DELIMITER //
CREATE PROCEDURE check_language(p_country_name varchar(100))
begin
 
  case p_country_name
    when 'Bulgaria' then
      set @v_alphabet = 'Cyrillic';
    when 'Romania' then
      set @v_alphabet = 'Cyrillic';
    when 'United States' then
      set @v_alphabet = 'Latin';
    else
      set @v_alphabet = 'Other';
  end case;
  select @v_alphabet;
end//

-- call the 'check_language' procedure
call check_language('Bulgaria');



-- Other examples
-- 1. create a trigger that inserts deleted records from the employees table into another table called 
-- 'employees_archive'
create table employees_archive (
name  VARCHAR(100) not null,
titleid INT(11) not null,
departmentid INT(11) not null,
email VARCHAR(254) not null,
phone VARCHAR(20) not null,
salary INT(11) not null,
hiredate DATE not null,
modified DATETIME not null
);

alter table employees_archive modify modified DATETIME not null;

delimiter \\
create trigger trigger_emp_archive after delete on employees
for each row
begin
insert into employees_archive(name, titleid, departmentid, email, phone, salary, hiredate, modified)
values (old.name, old.titleid, old.departmentid, old.email, old.phone, old.salary, old.hiredate, now());
end \\

insert into employees (name,titleid,departmentid,email,phone,salary,hiredate) 
values ('Dani Tsaribrodski',16,1,'rstone@outlook.com',565656565,3000,'2014-01-01');

delete from employees
where name like 'Dani Tsaribrodski';

drop trigger trigger_emp_archive;

-- 2. Create a one time event that changes the status of all vacations requested in 2012 from PENDING to APPROVED
CREATE TABLE `NEW_vacations` (
	`Id` INT(11) NOT NULL,
	`EmployeeId` INT(11) NOT NULL,
	`Status` VARCHAR(10) NOT NULL,
	`RequestDate` DATE NOT NULL,
	`FromDate` DATE NOT NULL,
	`ToDate` DATE NOT NULL
);

INSERT INTO new_vacations
SELECT * FROM vacations;

update new_vacations
set `Status` = 'APPROVED'
where `Status` = 'PENDING' and (RequestDate > '2011-12-31' and RequestDate < '2013-01-01');

-- 3. Create a repeatable event that is triggered every minute and increases the salary of the employee 
-- with name 'Ivan Ivanov' by 1.
DELIMITER //
CREATE PROCEDURE procedure_salary_up(in p_minute timestamp)
begin
set 
update employees_archive 
set salary = salary + 1 
where name = 'Dani Tsaribrodski';
end//

call procedure_salary_up(+ 1 minute);

drop procedure procedure_salary_up;

-- 4. Create proper indexes that improve the execution of the following SELECT queries:

--	SELECT NAME, EMAIL FROM EMPLOYEES
--	WHERE SALARY BETWEEN 1000 and 2000

create index index_salary on employees (salary);

--	SELECT * FROM CERTIFICATES
--	ORDER BY NAME

create unique index index_name on certificates (name);

--	SELECT `STATUS`, COUNT(*) FROM VACATIONS
--	GROUP BY `STATUS`

create index index_status on vacations (`status`);

--	SELECT E.NAME as EmpName, D.NAME as DepName FROM EMPLOYEES E
--	JOIN DEPARTMENTS D ON E.DEPARTMENTID = D.ID

create unique index index_name on departments (name);


-- 5. List all tables in the HRM database that start with 'D' or 'S'.
show tables
where tables_in_hrm like 's%' or tables_in_hrm like 'd%';

-- 6. List the number of columns in the Vacations table that are of VARCHAR type.
DESCRIBE vacations;

SHOW COLUMNS from vacations where type like 'varchar%';

SELECT count(*)
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'vacations' and DATA_TYPE = 'varchar';
