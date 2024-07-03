-- 코드를 입력하세요
select member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d')
from member_profile
where gender = 'W' and tlno is not null and month(date_of_birth) = 3
order by member_id;