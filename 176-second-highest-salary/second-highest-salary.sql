# Write your MySQL query statement below
select max(salary) as SecondHighestSalary
from employee
where salary = (
    select salary from employee
    group by salary
    order by salary desc
    limit 1 offset 1
)