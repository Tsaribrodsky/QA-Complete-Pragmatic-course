-- 0. retrieve all employees along with their department
select e.Name as employeeName, d.Name as DepartmantName
from employees as e
join departments as d 
on e.DepartmentId = d.Id;

-- 1. retrieve all employees along with their manager
select e.Name as EmName, m.Name as managerName
from employees as e
left join employees as m on e.ManagerId = m.Id;

-- 2. retrieve all employees that have requested a vacation between 01.01.2011 and 01.01.2012
select e.Name, v.RequestDate 
from employees as e
join vacations as v
on e.Id = v.EmployeeId
where v.RequestDate >= '2011-01-01' and v.RequestDate < '2012-01-02';

-- 3.1. Write an SQL query to find the average salary in the "Marketing" department.
select d.Name, avg(e.Salary)
from employees as e
join departments as d
on e.DepartmentId = d.Id
where d.Name like 'Marketing'
group by d.Name;

-- 3.2. Write an SQL query to find the average salary in the department which name start with 'a'.
select d.Name, avg(e.Salary)
from employees as e
join departments as d
on e.DepartmentId = d.Id
where d.Name like 'a%'
group by d.Name;

-- 4. Write an SQL query to find the first 10 employees joined the company (select EmployeeName and DepartmentName)
select e.Name, e.HireDate, d.Name
from employees as e
join departments as d
on e.DepartmentId = d.Id
order by e.HireDate asc
limit 10;

-- 5. Write a SQL query to find the names of all employees from the departments "Quality Assurance" or "Marketing" 
-- whose hire year is between 2005 and 2009 (2 - subselect and join)
select *
from employees as e
join departments as d on e.DepartmentId = d.Id
where (d.Name = "Quality Assurance"
or d.Name = "Marketing")
and year(e.HireDate) between 2005 and 2009;

-- 6. Write an SQL query to find the employees that have more than two certificates
select e.Name, count(c.Name)
from employees as e
join employee_certificates as ec on e.Id = ec.EmployeeId
join certificates as c on c.Id = ec.CertificateId
group by e.Name
having count(c.Name) >= 2;

-- 7. select all employee names along with number of their certificates
select e.Name, count(ec.CertificateId)
from employees as e
left join employee_certificates as ec on e.Id = ec.EmployeeId
group by e.Name;


-- 8. select all departments without employees (using left join)
select d.Name
from departments as d
left join employees as e on d.Id = e.DepartmentId
where e.Id is null;


-- 9. select skills that are assigned to at least one employee with title 'Software Engineer'
select distinct s.Name as SkillName
from skills as s
join employee_skills as es on s.Id = es.SkillId
join employees as e on e.Id = es.EmployeeId
join titles as t on t.Id = e.TitleId
where t.Name = 'Software Engineer';

select *
from employees e
join titles t on t.id = e.titleid
join vacations v on v.employeeid = e.id
join employee_skills es on e.Id = es.EmployeeId;


-- 10. Write an SQL query to find for each department and for each job title the total number of employees. 




-- 11. Write an SQL query to find all managers that have exactly 3 employees. Display their names and the name and their department. 



-- 12. Print the number of vacations per department per years requested between 2008 and 2012 along with the name of the department



-- 13. select all employees that have more skills than certificates



-- 14. select employees with a salary higher than that of 'Didi Marinova' (2 - subselect and join)


-- 15. select employees with maximum salary (2 - subselect and left join)