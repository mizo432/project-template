package template.modules.project.domain.model.project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.undecided.primitive.object.Objects2;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;
import template.modules.project.domain.model.project.attribute.ProjectAttribute;
import template.shared.entity.AuditInfo;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;

import java.util.List;

/**
 * プロジェクト.
 */
@Getter
@Entity(immutable = true)
@Table(schema = "resource", name = "projects")
@ConfigAutowireable
@ToString
public class Project {
    private final SnowflakeId id;

    private final ProjectAttribute attribute;
    private final AuditInfo auditInfo;

    /**
     * コンストラクター.
     */
    public Project() {
        id = SnowflakeId.empty();
        auditInfo = AuditInfo.empty();
        attribute = ProjectAttribute.empty();


    }

    /**
     * コンストラクター.
     *
     * @param id        ID
     * @param auditInfo 証跡
     * @param attribute 属性
     */
    public Project(SnowflakeId id,
                   AuditInfo auditInfo,
                   ProjectAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;
    }


    public static Project create(ProjectAttribute attribute) {
        return create(SnowflakeId.newInstance(), attribute);

    }

    @JsonCreator
    public static Project create(@JsonProperty("id") SnowflakeId id,
                                 @JsonProperty("attribute") ProjectAttribute attribute) {
        return new Project(id, AuditInfo.empty(), attribute);

    }

    public static Project create(Project project) {
        return new Project(SnowflakeId.newInstance(), AuditInfo.empty(), project.attribute);

    }

    public static Project newInstance() {
        return new Project(SnowflakeId.newInstance(), AuditInfo.empty(), ProjectAttribute.empty());
    }

    public static Project empty() {
        return new Project(SnowflakeId.empty(), AuditInfo.empty(), ProjectAttribute.empty());
    }

    public boolean sameValueAs(Project other) {
        return sameIdAs(other)
                && attribute.equals(other.attribute);

    }

    public boolean sameIdAs(Project other) {
        return id.equals(other.id);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Project project)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return id.equals(project.id) && attribute.equals(project.attribute);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(getClass(), id, auditInfo, attribute);

    }

    public static class Projects extends AbstractListValue<Project> {

        private static final Projects EMPTY = new Projects();

        Projects(List<Project> value) {
            super(value);
        }

        public Projects() {

        }


        public static Projects empty() {
            return EMPTY;
        }

        public static Projects reconstruct(List<Project> value) {
            return new Projects(value);
        }

        @Override
        public String asString() {
            return value.toString();
        }

    }

}
