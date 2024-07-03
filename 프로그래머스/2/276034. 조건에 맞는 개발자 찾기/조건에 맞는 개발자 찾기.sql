-- 코드를 작성해주세요
select distinct id, email, first_name, last_name
from developers a
join skillcodes b
on a.skill_code & b.code = b.code
where name = 'Python' or name = 'C#'
order by id;