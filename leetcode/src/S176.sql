-- 只有一个元素时出错 5 / 7 个通过测试用例
-- select salary as SecondHighestSalary
-- from employee
-- order by salary desc
-- limit 1, 1
-- 输入：
-- {"headers": {"Employee": ["Id", "Salary"]}, "rows": {"Employee": [[1, 100]]}}
-- 输出：
-- {"headers": ["SecondHighestSalary"], "values": []}
-- 预期结果：
-- {"headers":["SecondHighestSalary"],"values":[[null]]}


-- 临时表
select (select distinct salary
from employee
order by salary desc
limit 1 offset 1) as SecondHighestSalary


-- 使用 ifNull 函数
select ifnull((select distinct salary
from employee
order by salary desc
limit 1 offset 1), null) as SecondHighestSalary