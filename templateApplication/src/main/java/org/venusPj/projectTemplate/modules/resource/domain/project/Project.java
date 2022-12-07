package org.venusPj.projectTemplate.modules.resource.domain.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectAttribute;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(schema = "resources", name = "projects")
public class Project extends AbstractEntity<Project> {

    private final ProjectAttribute attribute;

    public Project() {
        this(Identifier.empty(), AuditInfo.empty(), ProjectAttribute.empty());

    }

    protected Project(Identifier<Project> id, AuditInfo auditInfo, ProjectAttribute attribute) {
        super(id, auditInfo);
        this.attribute = attribute;

    }

    public static Project create(ProjectAttribute attribute) {
        return new Project(Identifier.newInstance(), AuditInfo.empty(), attribute);

    }

    public static Project create(Project project) {
        return new Project(Identifier.newInstance(), AuditInfo.empty(), project.attribute);

    }

    @Override
    public boolean sameValueAs(Project other) {
        return super.sameValueAs(other)
            && attribute.equals(other.attribute);

    }

}
