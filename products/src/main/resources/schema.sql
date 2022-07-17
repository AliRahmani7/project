
CREATE TABLE IF NOT EXISTS product (id SERIAL PRIMARY KEY, product_id INT, product_name VARCHAR(255), product_description VARCHAR(255), category VARCHAR(255));
CREATE TABLE IF NOT EXISTS stock (id SERIAL PRIMARY KEY, stock_id INT, product_id INT, quantity BIGINT);
