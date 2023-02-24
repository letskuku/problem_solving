-- 코드를 입력하세요
SELECT a.animal_id, a.name
from animal_ins a, animal_outs b
where a.animal_id = b.animal_id and a.datetime > b.datetime
order by a.datetime;