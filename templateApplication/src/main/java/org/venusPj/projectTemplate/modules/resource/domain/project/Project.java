package org.venusPj.projectTemplate.modules.resource.domain.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectAttribute;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Project extends AbstractEntity<ProjectId, Project> {

    private final ProjectAttribute attribute;

    protected Project(ProjectId id, AuditInfo auditInfo, ProjectAttribute attribute) {
        super(id, auditInfo);
        this.attribute = attribute;

    }

    public static Project create(ProjectAttribute attribute) {
        return new Project(ProjectId.newInstance(), AuditInfo.empty(), attribute);

    }

    public static Project create(Project project) {
        return new Project(ProjectId.newInstance(), AuditInfo.empty(), project.attribute);

    }

    @Override
    public boolean sameValueAs(Project other) {
        return super.sameValueAs(other)
            && attribute.equals(other.attribute);

    }

}
