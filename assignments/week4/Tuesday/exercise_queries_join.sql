select c.email, oh.placed_at, SUM(ol.qty * ol.unit_price)
from customer as c
inner join order_header as oh
on oh.customer_id = c.customer_id
inner join order_line as ol
on ol.order_id = oh.order_id
group by c.email, oh.placed_at;

select customer_name, recent_order_id from (select c.full_name as customer_name, oh.order_id as recent_order_id, row_number() over (partition by c.customer_id order by oh.placed_at desc) as rn
from customer as c
left join order_header as oh
on oh.customer_id = c.customer_id) as numbered
where rn < 2;

select customer_name, recent_order_id from (select c.full_name as customer_name, oh.order_id as recent_order_id, row_number() over (partition by c.customer_id order by oh.placed_at desc) as rn
from order_header as oh
right join customer as c
on oh.customer_id = c.customer_id) as numbered
where rn < 2;

select c.full_name as customer_name, oh.order_id as order_id from customer as c 
full outer join order_header as oh
on c.customer_id = oh.customer_id;


select p.name, product_status from product as p 
cross join (values 
('STOCK_OK'), 
('STOCK_LOW'))
as status_table(product_status)
where (p.stock_qty > 50 and product_status = 'STOCK_OK')
or (p.stock_qty <=50 and product_status = 'STOCK_LOW')
order by p.name;

select customer_id, full_name, count(order_id) as order_count, sum(line_cost)
from
(select distinct 
c.customer_id as customer_id, 
c.full_name as full_name, 
oh.order_id as order_id,
qty * unit_price as line_cost
from customer as c
inner join order_header as oh
on c.customer_id = oh.customer_id
inner join order_line as ol
on oh.order_id = ol.order_id) as t1
group by customer_id, full_name
having sum(line_cost) > 25;

select product_id 
from
    (select product_id, count(distinct order_id)
    from order_line
    group by product_id) as t1
where count > 1;

select customer_id, email, full_name from customer where customer_id < 3;
select customer_id, email, full_name from customer where customer_id = 3;

select customer_id, email, full_name from customer where customer_id < 3
UNION ALL
select customer_id, email, full_name from customer where customer_id = 3;
