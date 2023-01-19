CREATE TABLE resource.actors
(
    actorId     VARCHAR(26),
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    projectId   VARCHAR(26)  NOT NULL,
    primary key (actorId)
);