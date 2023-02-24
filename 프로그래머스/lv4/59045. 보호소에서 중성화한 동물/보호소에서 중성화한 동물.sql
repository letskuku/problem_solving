-- 코드를 입력하세요
select animal_id, animal_type, name
from animal_ins
where animal_id in (select a.animal_id
                   from animal_ins a, animal_outs b
                   where a.animal_id = b.animal_id 
                    and a.sex_upon_intake like 'Intact%' 
                    and (b.sex_upon_outcome like 'Neutered%' 
                         or b.sex_upon_outcome like 'Spayed%'))
order by animal_id;