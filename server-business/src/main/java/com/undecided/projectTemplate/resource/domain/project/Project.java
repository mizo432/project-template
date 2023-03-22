package com.undecided.projectTemplate.resource.domain.project;

import static com.undecided.primitive.object.Objects2.isNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.undecided.projectTemplate.resource.domain.project.attribute.ProjectAttribute;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Entity(immutable = true)
@Table(schema = "resource", name = "projects")
@ConfigAutowireable
public class Project implements Serializable {

    @Id
    protected final UlidIdentifier<Project> projectId;

    private final ProjectAttribute attribute;

    public Project() {
        this(UlidIdentifier.empty(), ProjectAttribute.empty());

    }


    public static Project create(ProjectAttribute attribute) {
        return create(UlidIdentifier.newInstance(), attribute);

    }

    @JsonCreator
    public static Project create(@JsonProperty("projectId") UlidIdentifier<Project> projectId,
        @JsonProperty("attribute") ProjectAttribute attribute) {
        return new Project(projectId, attribute);

    }

    public static Project create(Project project) {
        return new Project(UlidIdentifier.newInstance(), project.attribute);

    }

    public static Project newInstance() {
        return new Project(UlidIdentifier.newInstance(), ProjectAttribute.empty());
    }

    public static Project empty() {
        return new Project(UlidIdentifier.empty(), ProjectAttribute.empty());
    }

    public boolean sameValueAs(Project other) {
        return sameIdentifierAs(other)
            && attribute.equals(other.attribute);

    }

    private boolean sameIdentifierAs(Project other) {
        if (isNull(other)) {
            return false;
        }
        return projectId.equals(other.projectId);

    }

}
