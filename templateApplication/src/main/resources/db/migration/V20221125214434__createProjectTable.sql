CREATE TABLE resource.projects
(
    projectId       VARCHAR(26),
    projectCode     varchar(10)  NOT NULL,
    projectName     varchar(255) NOT NULL,
    description     TEXT,
    storyCodePrefix integer      NOT NULL,
    primary key (projectId)
);