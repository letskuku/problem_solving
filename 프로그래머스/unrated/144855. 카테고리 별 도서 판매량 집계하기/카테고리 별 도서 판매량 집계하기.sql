-- 코드를 입력하세요
SELECT category, sum(sales) as total_sales
from book
join book_sales
on book.book_id = book_sales.book_id
where year(sales_date) = 2022 and month(sales_date) = 01
group by category
order by category;