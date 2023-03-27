CREATE TABLE resource.projects
(
    id              BIGINT,
    projectCode     varchar(10)  NOT NULL,
    projectName     varchar(255) NOT NULL,
    description     TEXT,
    storyCodePrefix varchar(10)  NOT NULL,
    createdAt       timestamp    not null default current_timestamp,
    createdBy       BIGINT       not null,
    primary key (id)
);