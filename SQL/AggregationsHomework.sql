-- 1. Изведете имената на отделите, в които има повече от 2-ма служителя
select d.Name as DepartmantName, count(e.Id) as NumberEmployees
from employees as e
join departments as d 
on e.DepartmentId = d.Id
group by d.Name
having count(e.Id)>2
order by 2;

-- 2. Изведете бройката на служителите, които са ползвали отпуск през 2010-та (поне два начина)
select count(v.Id) as NumberEmployees, v.FromDate, v.ToDate
from vacations as v
where v.`Status` like 'APPROVED' and v.FromDate >= '2010-01-01' and v.ToDate < '2011-01-02'
group by v.FromDate, v.ToDate;

select count(v.Id) as NumberEmployees, v.FromDate, v.ToDate
from vacations as v
where v.`Status` like 'APPROVED' and v.RequestDate >= '2010-01-01' and v.RequestDate < '2011-01-02'
group by v.FromDate, v.ToDate;

-- year(v.ToDate)=2010
-- year(v.fromDate)=2010

-- 3. Изведете всички позиции/тайтъли, които съдържат думата Junior, но не завършват на нея.
select t.Name
from titles as t
where t.Name like 'Junior%' or t.Name like '%Junior%';

select *
from titles
where name like '%Junior%' and name not like '%Junior';

select *
from titles
where name like '%Junior%_';

select *
from titles as t
where locate('junior',t.Name)>0
and right(t.Name,6) <> 'junior';

-- 4. Изведете бройката на служителите, наети през последните 5 години, 3 месеца и 2 дни.
select count(e.Id)
from employees as e
where e.HireDate>adddate(adddate(adddate(curdate(), interval -5 year), interval -3 month), interval -2 day);

-- 5. Изведете 3-те месеца, в които са се наемали най-много служители.
select month(e.HireDate), count(e.Id)
from employees as e
group by month(e.HireDate)
order by count(e.Id) desc
limit 3;

-- 6. Намерете кога за последно е наеман служител през 2010-та
select e.HireDate
from employees as e
where year(e.HireDate) = 2010
order by e.HireDate desc
limit 1;

-- 7. Изведете служителите с фамилия Ivanov
select e.Name
from employees as e
where e.Name like '%_Ivanov';

-- 8. Изведете служителя работил най-дълго в компанията
select e.Name, datediff(IFNULL(e.EndDate, curdate()), e.HireDate)
from employees as e
group by e.Name
order by datediff(IFNULL(e.EndDate, curdate()), e.HireDate) desc
limit 1;

select e.Name, datediff(case when e.EndDate is null then curdate() else e.EndDate end, e.HireDate)
from employees as e
group by e.Name
order by datediff(case when e.EndDate is null then curdate() else e.EndDate end, e.HireDate) desc
limit 1;