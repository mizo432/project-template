CREATE TABLE business.model_entities
(
    id         BIGINT,
    code       varchar(30)  NOT NULL,
    name       varchar(255) NOT NULL,
    type       varchar(10)  NOT NULL,
    project_id BIGINT       not null,
    created_at timestamp    not null default current_timestamp,
    created_by BIGINT       not null,
    primary key (id)
);