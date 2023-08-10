CREATE TABLE IF NOT EXISTS admin.department
(
    id   NUMERIC(19, 0) PRIMARY KEY UNIQUE,
    name varchar(255) not null
);