CREATE TABLE resource.projects
(
    id                BIGINT,
    project_code      varchar(10)  NOT NULL,
    project_name      varchar(255) NOT NULL,
    description       TEXT,
    story_code_prefix varchar(10)  NOT NULL,
    created_at        timestamp    not null default current_timestamp,
    created_by        BIGINT       not null,
    primary key (id)
);