create table security.assignment_role
(
    assignment_role_id BIGINT,
    user_id            BIGINT,
    role_id            BIGINT,
    when_occurred      timestamp NOT NULL,
    primary key (assignment_role_id)
);

comment on table security.assignment_role is 'ロール割り当て:[E]ユーザーにロールを割り当てた';
COMMENT ON COLUMN security.assignment_role.assignment_role_id IS 'ロール割り当てID';
COMMENT ON COLUMN security.assignment_role.user_id IS 'ユーザーID';
COMMENT ON COLUMN security.assignment_role.role_id IS 'ロールID';
COMMENT ON COLUMN security.assignment_role.when_occurred IS '割当日時';

