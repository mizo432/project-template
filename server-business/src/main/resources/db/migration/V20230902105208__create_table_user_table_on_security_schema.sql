create table security."user"
(
    user_id     BIGINT,
    user_code   VARCHAR(8)   NOT NULL,
    user_name   VARCHAR(20)  NOT NULL,
    user_j_name VARCHAR(50)  NOT NULL,
    email       varchar(128) NOT NULL,
    primary key (user_id)
);

comment on table security."user" is 'ユーザー';
COMMENT ON COLUMN security."user".user_id IS 'ユーザーID';
COMMENT ON COLUMN security."user".user_code IS 'ユーザーコード';
COMMENT ON COLUMN security."user".user_name IS 'ユーザー名';
COMMENT ON COLUMN security."user".user_j_name IS 'ユーザーかな名:並び替えに使用する';
COMMENT ON COLUMN security."user".email IS 'E-Mailアドレス';
