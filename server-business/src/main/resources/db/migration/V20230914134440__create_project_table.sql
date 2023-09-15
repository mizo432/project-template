CREATE TABLE admin.project
(
    project_id        BIGINT,
    project_code      varchar(10)  NOT NULL,
    project_name      varchar(255) NOT NULL,
    story_code_prefix varchar(10)  NOT NULL,
    primary key (project_id)
);

comment on table admin.project IS 'プロジェクト';
comment on column admin.project.project_id IS 'プロジェクトID';
comment on column admin.project.project_code IS 'プロジェクトコード';
comment on column admin.project.project_name IS 'プロジェクト名称';
comment on column admin.project.story_code_prefix IS 'ストーリーコード接頭子';
