create table security.role
(
    role_id   BIGINT,
    role_code VARCHAR(10)  NOT NULL,
    role_name VARCHAR(256) NOT NULL,
    primary key (role_id)
);

comment on table security.role is 'ロール';
COMMENT ON COLUMN security.role.role_id IS 'ロールID';
COMMENT ON COLUMN security.role.role_code IS 'ロールコード';
COMMENT ON COLUMN security.role.role_name IS 'ロール名';
