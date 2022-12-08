package org.venusPj.projectTemplate.modules.resource.domain.project;

import static org.venusPj.primitive.object.Objects2.isNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectAttribute;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(schema = "resources", name = "projects")
@@ConfigAutowireable
public class Project {

    @Id
    protected final Identifier<Project> projectId;

    protected final AuditInfo auditInfo;

    private final ProjectAttribute attribute;

    public Project() {
        this(Identifier.empty(), AuditInfo.empty(), ProjectAttribute.empty());

    }

    protected Project(Identifier<Project> projectId, AuditInfo auditInfo,
        ProjectAttribute attribute) {
        this.projectId = projectId;
        this.auditInfo = auditInfo;
        this.attribute = attribute;

    }

    public static Project create(ProjectAttribute attribute) {
        return new Project(Identifier.newInstance(), AuditInfo.empty(), attribute);

    }

    public static Project create(Project project) {
        return new Project(Identifier.newInstance(), AuditInfo.empty(), project.attribute);

    }

    public boolean sameValueAs(Project other) {
        return sameIdentifierAs(other)
            && auditInfo.equals(other.auditInfo)
            && attribute.equals(other.attribute);

    }

    private boolean sameIdentifierAs(Project other) {
        if (isNull(other)) {
            return false;
        }
        return projectId.equals(other.projectId);
    }

}
