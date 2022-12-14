package org.venusPj.projectTemplate.modules.resource.domain.project;

import static org.venusPj.primitive.object.Objects2.isNull;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectAttribute;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(schema = "resource", name = "projects")
@ConfigAutowireable
public class Project implements Serializable {

    @Id
    protected final Identifier<Project> projectId;

    private final ProjectAttribute attribute;

    public Project() {
        this(Identifier.empty(), ProjectAttribute.empty());

    }

    protected Project(Identifier<Project> projectId,
        ProjectAttribute attribute) {
        this.projectId = projectId;
        this.attribute = attribute;

    }

    public static Project create(ProjectAttribute attribute) {
        return new Project(Identifier.newInstance(), attribute);

    }

    public static Project create(Project project) {
        return new Project(Identifier.newInstance(), project.attribute);

    }

    public static Project newInstance() {
        return new Project(Identifier.newInstance(), ProjectAttribute.empty());
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
