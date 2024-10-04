CREATE DATABASE Tutorial;

\connect Tutorial;

CREATE TABLE "User" (
    id SERIAL PRIMARY KEY,
    pwd VARCHAR,
    name VARCHAR(200) UNIQUE
);

CREATE TABLE "Role" (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES "User"(id),
    role VARCHAR(1),
    role_name VARCHAR(10)
);

GRANT ALL PRIVILEGES ON DATABASE Tutorial TO vin;