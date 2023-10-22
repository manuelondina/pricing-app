CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    product_id BIGINT UNIQUE
);

CREATE TABLE IF NOT EXISTS prices (
    id SERIAL PRIMARY KEY,
    brand_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    price_list INT NOT NULL,
    priority INT NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    curr VARCHAR(255) NOT NULL,
    product_id BIGINT,
    CONSTRAINT fk_prices_product FOREIGN KEY (product_id) REFERENCES products(product_id)
);
