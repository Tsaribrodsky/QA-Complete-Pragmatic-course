select avg(e.Salary)
from employees as e;

select max(e.Salary)
from employees as e;

select min(e.Salary)
from employees as e
where e.DepartmentId=5;

select count(e.Id)
from  employees as e;

select count(e.Id),e.ManagerId
from  employees as e
where e.ManagerId=2
group by e.ManagerId;

select e.DepartmentId ,count(e.Id)
from employees as e
group by e.DepartmentId
having avg(e.Salary)>2000;