create or replace view
v_order_line_detail
as select
oh.order_id, 
c.email, 
p.sku, 
ol.qty, 
(ol.qty * ol.unit_price) as line_total, 
oh.status as status
from customer as c
inner join order_header as oh
on c.customer_id = oh.customer_id
inner join order_line as ol
on ol.order_id = oh.order_id
inner join product as p 
on p.product_id = ol.product_id;


select * from v_order_line_detail;

create or replace view v_customer_spend
as
select c.email, count(distinct oh.order_id) as order_count, sum(ol.qty * ol.unit_price) as lifetime_spend
from customer as c
inner join order_header as oh
on c.customer_id = oh.customer_id
inner join order_line as ol
on ol.order_id = oh.order_id
group by c.customer_id;

select * from v_customer_spend;

EXPLAIN (ANALYZE, BUFFERS)
SELECT COUNT(*)
FROM product_event
WHERE product_id = 1;

create index idx_product_event_product_id on product_event(product_id);

EXPLAIN (ANALYZE, BUFFERS)
SELECT COUNT(*)
FROM product_event
WHERE product_id = 1;

create index idx_product_event_product_id_event_type on product_event(product_id, event_type);
EXPLAIN (ANALYZE, BUFFERS)
SELECT COUNT(*)
FROM product_event
WHERE product_id = 1;