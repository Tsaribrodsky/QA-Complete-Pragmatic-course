-- 1. retrieve the name and phone of all employees combined in the column Name_Phone in the format 'name:phone 
-- and select from column salary values which are between 100-999, 1000-5000 and more than 5000 put the result 
-- in new column named SalaryRange 
select concat(e.Name,' : ', e.Phone) as 'Name_Phone',
 case
  when e.Salary between 100 and 999 then '100-999'
  when e.Salary between 1000 and 5000 then '1000-5000'
  when e.Salary > 5000 then 'more than 5000'
 end SalaryRange 
from employees as e;

-- 2. retrieve name and salary increased by 10% of all employees whose name starts with 'Bo'
select e.Name, e.Salary*1.1
from employees as e
where e.Name like 'Bo%';

-- 3. select all titles that have a parent
select t.Name
from titles as t
where t.ParentId is not null;

-- 4. retrieve all vacations with a status of 'PENDING' and requested before '2014-01-06'
select *
from vacations as v
where v.`Status` like 'PENDING' and v.RequestDate < '2014-01-06';

-- 5. select only the distinct values from the Status column in the vacations table whose Status not finished with 'ed'
select distinct v.`Status`
from vacations as v
where v.`Status` not like '%ed';

-- 6. retrieve the names of the last 2 employees that joined the company in period '2012-05-01' - '2013-12-01'
select e.Name
from employees as e
where e.HireDate > '2012-05-01' and e.HireDate < '2013-12-01'
order by e.HireDate desc
limit 2;

-- 7. retrieve min, max, total and average salary
select min(e.Salary), max(e.Salary), sum(e.Salary), avg(e.Salary)
from employees as e;

-- 8.retrieve the name of last he left employee in 2011 year
select e.Name
from employees as e
where e.EndDate < '2012-01-01'
order by e.EndDate desc
limit 1;

-- 9. select from column salary values which are between 100-999, 1000-5000 and more than 5000
-- put the result in new column named SalaryRange and count the epmploys in this groups
select count(e.Id) as 'Number Employees',
 case
  when e.Salary between 100 and 999 then '100-999'
  when e.Salary between 1000 and 5000 then '1000-5000'
  when e.Salary > 5000 then 'more than 5000'
 end SalaryRange 
from employees as e
group by SalaryRange;

-- 10. for employe Teodor Jivkov select HireDate and name change date format with '%D:%M:%Y' and raplace name with Ivan
select e.HireDate, e.Name, date_format(e.HireDate, '%D:%M:%Y') as 'New Date Format', replace(e.Name, 'Teodor', 'Ivan') as 'New Name'
from employees as e
where e.Name = 'Teodor Jivkov';

-- 11. count number of Parent departments from departments
select count(distinct d.ParentId) as 'Number of Parent Departments'
from departments as d;

-- 12. Print the total amount of salaries given to employees for each department that include a
select d.Name as 'Department', sum(e.Salary) as 'Amount of Salaries'
from departments as d
left join employees as e on e.DepartmentId = d.Id
group by d.Name
order by sum(e.Salary);

-- 13. Print the names of the departments with more than 3 employees
select d.Name
from departments as d
join employees as e on d.Id = e.DepartmentId
group by d.Name
having count(e.Id) > 3;

-- 14. Print the number of vacations requested between 2010 and 2012
select count(v.RequestDate) as 'Number of Vacantions'
from vacations as v
where v.RequestDate > '2010-01-01' and v.RequestDate < '2013-01-01';

-- 15. Write an SQL query to find all managers that have exactly 2 employees. Display their names and the name and 
-- their department. 
select m.Name as 'ManagerName', d.Name as 'Department'
from employees as e
join employees as m on e.ManagerId = m.Id
join departments as d on d.Id = m.DepartmentId
group by m.Name, d.Name
having count(e.Id) = 2;

-- 16. select all employees that have more certificates than skills
-- !!! DISTINCT
select e.Name, count(distinct ec.CertificateId) as 'Certificates', count(distinct es.SkillId) as 'Skills'
from employees as e
left join employee_certificates as ec on e.Id = ec.EmployeeId
left join employee_skills as es on e.Id = es.EmployeeId
group by e.Name
having count(distinct ec.CertificateId) > count(distinct es.SkillId);