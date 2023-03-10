package com.undecided.projectTemplate.shared.idHolder;

import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.Identifier;

public class ProjectIdHolder {

    private final static ThreadLocal<Identifier<Project>> identifierRef = new ThreadLocal<>();

    public static Identifier<Project> operatingIdentifier() {
        return identifierRef.get();
    }

    public static void remove() {
        identifierRef.remove();

    }

    public static void set(Identifier<Project> identifier) {
        identifierRef.set(identifier);

    }
}
