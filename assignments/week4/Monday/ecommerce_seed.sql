insert into products (product_name, stock_quantity, unit_price)
values
('Fish', 2, 2.99), 
('Cat', 1, 30),
('Dog', 2, 50)
;

insert into addresses (address_name)
values('19 beatty st');

insert into customers(first_name, last_name, phone_number)
values
('Benson', 'Zheng', '6789181239'),
('Trista', 'Zheng', '6789181238')
;

insert into orders(customer_id, shipping_address_id, total_price)
values
(1, 1, 2.99),
(2, 1, 80)
;

insert into line_items(quantity, order_id, product_id, unit_price)
values
(1, 1, 1, 2.99),
(1, 2, 2, 30),
(1, 2, 3, 50)
;

update products set unit_price = 60 where id = 3;

select unit_price from products where id = 3;

select unit_price from line_items where id = 3;

select * from orders;