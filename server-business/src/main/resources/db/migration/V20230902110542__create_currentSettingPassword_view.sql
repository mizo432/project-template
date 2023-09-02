create view security.current_setting_password
as
select user_id, max(when_occurred) latest_when_occurred, password
from security.setting_password
group by user_id, password;

comment on view security.current_setting_password is '現在パスワード設定:[R]最新のユーサーにパスワード設定を設定';

