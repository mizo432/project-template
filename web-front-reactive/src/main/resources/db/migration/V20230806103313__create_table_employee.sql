CREATE TABLE IF NOT EXISTS admin.employee
(
    id         NUMERIC(19, 0) PRIMARY KEY UNIQUE,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    kana_name  varchar(255) not null
);