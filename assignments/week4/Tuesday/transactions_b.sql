BEGIN;

update product as p
set stock_qty = p.stock_qty - t.total_qty
from
(select ol.product_id, ol.qty as total_qty from order_line as ol
inner join order_header as oh
on ol.order_id = oh.order_id
where oh.status = 'PAID') as t
where p.product_id = t.product_id;

select * from product;
ROLLBACK;
