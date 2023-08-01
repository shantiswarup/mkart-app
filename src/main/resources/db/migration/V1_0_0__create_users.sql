CREATE TABLE IF NOT EXISTS users (
                                    id SERIAL,
                                    username VARCHAR(255) unique,
                                    password VARCHAR(255),
                                    email VARCHAR(255) unique,
                                    first_name VARCHAR(255),
                                    last_name VARCHAR(255),
                                    PRIMARY KEY(id, username, email)
                            );