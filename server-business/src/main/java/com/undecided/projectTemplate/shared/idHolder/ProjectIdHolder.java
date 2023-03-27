package com.undecided.projectTemplate.shared.idHolder;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;

public class ProjectIdHolder {

    private final static ThreadLocal<SnowflakeIdentifier<Project>> identifierRef = new ThreadLocal<>();

    public static SnowflakeIdentifier<Project> operatingIdentifier() {
        return identifierRef.get();
    }

    public static void remove() {
        identifierRef.remove();

    }

    public static void set(SnowflakeIdentifier<Project> identifier) {
        identifierRef.set(identifier);

    }
}
