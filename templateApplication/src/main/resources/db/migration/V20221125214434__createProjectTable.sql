CREATE TABLE resource.projects
(
    projectId   VARCHAR(26),
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    primary key (projectId)
);