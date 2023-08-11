-- 코드를 입력하세요
SELECT user_id, nickname, sum(price) as total_sales
from used_goods_board
join used_goods_user
on used_goods_board.writer_id = used_goods_user.user_id
where status = "DONE"
group by user_id
having sum(price) >= 700000
order by total_sales;