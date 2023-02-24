-- 코드를 입력하세요
SELECT animal_id, name
from ANIMAL_INS
where animal_type = 'dog' and name like '%el%'
order by name;