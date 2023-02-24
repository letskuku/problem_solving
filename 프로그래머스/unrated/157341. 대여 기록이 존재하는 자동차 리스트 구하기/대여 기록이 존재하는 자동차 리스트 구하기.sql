-- 코드를 입력하세요
SELECT distinct a.car_id
from CAR_RENTAL_COMPANY_CAR a, CAR_RENTAL_COMPANY_RENTAL_HISTORY b
where a.car_id = b.car_id and a.car_type = '세단' and b.start_date between '2022-10-01' and '2022-10-31'
order by a.car_id desc;