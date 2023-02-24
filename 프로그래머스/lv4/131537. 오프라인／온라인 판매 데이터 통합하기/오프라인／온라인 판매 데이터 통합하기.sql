-- 코드를 입력하세요
((select DATE_FORMAT(SALES_DATE, "%Y-%m-%d") as sales_date, product_id, user_id, sales_amount
from online_sale
where sales_date between '2022-03-01' and '2022-03-31')

union 

(select DATE_FORMAT(SALES_DATE, "%Y-%m-%d") as sales_date, product_id, NULL as user_id, sales_amount
from offline_sale
where sales_date between '2022-03-01' and '2022-03-31'))
order by sales_date, product_id, user_id;