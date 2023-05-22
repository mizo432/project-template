package com.undecided.projectTemplate.shared.idHolder;

import com.undecided.projectTemplate.modules.project.domain.model.project.Project;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;

public class ProjectIdHolder {

    private final static ThreadLocal<SnowflakeId<Project>> identifierRef = new ThreadLocal<>();

    public static SnowflakeId<Project> operatingIdentifier() {
        return identifierRef.get();
    }

    public static void remove() {
        identifierRef.remove();

    }

    public static void set(SnowflakeId<Project> identifier) {
        identifierRef.set(identifier);

    }
}
