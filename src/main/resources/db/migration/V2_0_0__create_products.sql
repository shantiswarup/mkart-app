CREATE TABLE IF NOT EXISTS products (
                                    id SERIAL,
                                    product_name VARCHAR(255),
                                    product_desc VARCHAR(1000),
                                    PRIMARY KEY(id)
                            );