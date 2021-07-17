
-- 1. select all rows from the Department table
select *
from departments;

-- 2. select only the Name and ParentId column from the Departments table
select d.Name,d.ParentId
from departments as d;

-- 3. select all employee names from the Employees table and rename the column in the result to Employee_Name
select e.Name as 'Employee_Name'
from employees as e;

-- 4. select name from employee and add 300 to the Salary column as the Increased_Salary column
select e.Name,e.Salary+300 as 'Increased_Salary'
from employees as e;

-- 5. select only the distinct values from the JobPositionId column in the Job_Candidate table
select distinct j.JobPositionId
from job_candidates as j;

-- 6. retrieve the Name and Email  of all employees - combine the result in a single column with name 
-- 'record' in the format 'Name:Email'
select concat(e.Name,' : ',e.Email) as 'record'
from employees as e;

-- 7. select all rows from the Department table where the name is 'Software Engineering'
select *
from departments as d
where d.Name = 'Software Engineering';

-- 8. select all employees with salary higher than 2000 and hired after '2010-01-01'
select *
from employees as e
where e.Salary>2000 and e.HireDate>'2010-01-01';

-- 9. Write an SQL query to find the names of all employees whose salary is in the range [1000...2000].
select e.Name,e.Salary
from employees as e
where e.Salary between 1000 and 2000
order by e.Salary;

-- 10. select all employees with a salary of 2000, 2500 or 3000
select e.Name,e.Salary
from employees as e
where e.Salary in(2000,2500,3000);

-- 11. select all employee whose name starts with 'St'
select e.Name
from employees as e
where e.Name like 'St%';

-- 12. select all employee whose name does not contains the character sequence 'St'
select e.Name
from employees as e
where e.Name <> 'St%';

-- 13. select all employees that don't have a manager
select e.Name
from employees as e
where e.ManagerId is null;

-- 14. select all employees that have a manager
select e.Name
from employees as e
where e.ManagerId is not null;

-- 15. select all employees ordered in ascending order by salary
select e.Name,e.Salary
from employees as e
order by e.Salary asc;

-- 16. select all employees ordered in descending order by name and ascending order by salary
select e.Name,e.Salary
from employees as e
order by e.Name desc, e.Salary asc;

-- 17. select top 5 employees by highest salary
select *
from employees as e
order by e.Salary desc
limit 5;

-- 18. retrieve the Name, Email and HireDate of all employees that have hired in 2008 - combine 
-- the result in a single column with name 'record' in the format 'Name:Email:HireDate'
select concat(e.Name,' : ',e.Email,' : ',e.HireDate)
from employees as e
where e.HireDate between '2008-01-01' and '2008-12-31';