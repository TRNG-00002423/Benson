create or replace procedure adjust_stock(
    p_sku TEXT,
    p_delta INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    update product
    set stock_qty = stock_qty + p_delta
    where sku = p_sku
    and stock_qty + p_delta >= 0;

    if not found then
    raise exception 'sku not found'
    end if;

END;
$$;

create or replace function fetch_order_total(
    p_order_id int
)
return numeric
LANGUAGE plpgsql
AS $$
declare total int;
BEGIN
    SELECT COALESCE(SUM(ol.qty * ol.unit_price), 0)
    INTO total
    FROM order_line AS ol
    WHERE ol.order_id = p_order_id;

    RETURN total;
END;
$$;