create table security.setting_password
(
    setting_password_id BIGINT,
    user_id             BIGINT,
    when_occurred       timestamp    NOT NULL,
    password            varchar(256) NOT NULL,
    primary key (setting_password_id)
);

comment on table security.setting_password is 'パスワード設定:[E]ユーサーにパスワード設定を設定した';
COMMENT ON COLUMN security.setting_password.setting_password_id IS 'パスワード設定ID';
COMMENT ON COLUMN security.setting_password.user_id IS 'ユーザーID';
COMMENT ON COLUMN security.setting_password.when_occurred IS '設定日時';
COMMENT ON COLUMN security.setting_password.password IS 'パスワード:ハッシュ化されたパスワード';
