CREATE TABLE resource.actors
(
    id          BIGINT,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    projectId   VARCHAR(26)  NOT NULL,
    createdAt   timestamp    not null default current_timestamp,
    createdBy   BIGINT       not null,
    primary key (id)
);