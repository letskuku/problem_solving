-- 코드를 입력하세요
SELECT category, price as max_price, product_name 
from food_product
where (category, price) in (select category, max(price)
                      from food_product
                      where category in ('식용유', '과자', '국', '김치')
                      group by category)
order by max_price desc;