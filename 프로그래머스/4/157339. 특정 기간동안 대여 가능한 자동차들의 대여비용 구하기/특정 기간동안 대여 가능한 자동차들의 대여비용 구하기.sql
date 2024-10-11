-- 코드를 입력하세요
select a.car_id, a.car_type, 
        if (daily_fee * 30 * (1 - discount_rate / 100) >= 500000 and 
           daily_fee * 30 * (1 - discount_rate / 100) < 2000000, 
           floor(daily_fee * 30 * (1 - discount_rate / 100)), null) fee
from CAR_RENTAL_COMPANY_CAR a
join (select car_type, discount_rate
     from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
     where duration_type = '30일 이상') b
on a.car_type = b.car_type
where a.car_id not in (select car_id
                      from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                      where (start_date between '2022-11-01' and '2022-11-30'
                        or end_date between '2022-11-01' and '2022-11-30')
                      or (start_date < '2022-11-01' and end_date > '2022-11-30'))
        and a.car_type in ('세단', 'SUV')
having fee is not null
order by fee desc, a.car_type, a.car_id desc