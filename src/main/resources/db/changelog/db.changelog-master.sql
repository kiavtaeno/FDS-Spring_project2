CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE user_roles (
    client_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (client_id, role_id),
    CONSTRAINT fk_user_role FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
    CONSTRAINT fk_role_user FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE
);

CREATE TABLE currencies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    code VARCHAR(5),
    priceChangeRange DOUBLE PRECISION,
    description VARCHAR(255)
)
