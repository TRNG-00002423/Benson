DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS addresses CASCADE;
DROP TABLE IF EXISTS customers cascade;
DROP TABLE IF EXISTS orders cascade;
DROP TABLE IF EXISTS line_items cascade;

CREATE TABLE products(
    id serial primary key,
    product_name varchar(50) not null,
    stock_quantity int default 0 check(stock_quantity >= 0),
    unit_price decimal(10, 2) default 0
);

create table addresses(
    id serial primary key,
    address_name varchar(50) not null
);

create table customers(
    id serial primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone_number varchar(20) unique not null
);

create table orders(
    id serial primary key,
    customer_id int not null,
    shipping_address_id int not null,
    total_price decimal(10, 2) not null,
    status varchar(20) check(status in ('Processing', 'Shipped', 'Delivered')) default 'Processing',
    created_date date default current_date,

    FOREIGN KEY (shipping_address_id) REFERENCES addresses(id)
);

CREATE TABLE line_items(
    id SERIAL PRIMARY KEY,
    quantity INT DEFAULT 1 check(quantity > 0),
    product_id INT NOT NULL,
    order_id INT NOT NULL,
    unit_price decimal(10, 2) not null,

    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

