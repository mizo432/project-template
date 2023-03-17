package com.undecided.projectTemplate.shared.idHolder;

import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;

public class ProjectIdHolder {

    private final static ThreadLocal<UildIdentifier<Project>> identifierRef = new ThreadLocal<>();

    public static UildIdentifier<Project> operatingIdentifier() {
        return identifierRef.get();
    }

    public static void remove() {
        identifierRef.remove();

    }

    public static void set(UildIdentifier<Project> identifier) {
        identifierRef.set(identifier);

    }
}
