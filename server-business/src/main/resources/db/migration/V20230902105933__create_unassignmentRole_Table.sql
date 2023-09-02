create table security.unassignment_role
(
    assignment_role_id BIGINT,
    when_occurred      timestamp NOT NULL,
    primary key (assignment_role_id)
);

comment on table security.unassignment_role is '[E]ロール割当解除:ユーザーに割り当てたロールを解除した';
COMMENT ON COLUMN security.unassignment_role.assignment_role_id IS 'ロール割り当てID';
COMMENT ON COLUMN security.unassignment_role.when_occurred IS '割当解除日時';
