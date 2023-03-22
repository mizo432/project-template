package com.undecided.projectTemplate.shared.idHolder;

import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;

public class ProjectIdHolder {

    private final static ThreadLocal<UlidIdentifier<Project>> identifierRef = new ThreadLocal<>();

    public static UlidIdentifier<Project> operatingIdentifier() {
        return identifierRef.get();
    }

    public static void remove() {
        identifierRef.remove();

    }

    public static void set(UlidIdentifier<Project> identifier) {
        identifierRef.set(identifier);

    }
}
