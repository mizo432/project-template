package template.modules.admin.domain.model.project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.undecided.primitive.object.Objects2;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;
import template.modules.admin.domain.model.project.attribute.ProjectAttribute;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;

import java.util.List;

/**
 * プロジェクト.
 */
@Getter
@Entity(immutable = true)
@Table(schema = "admin", name = "project")
@ConfigAutowireable
@ToString
public class Project {

    @Column(name = "project_id")
    private final SnowflakeId projectTd;

    private final ProjectAttribute attribute;

    /**
     * コンストラクター.
     */
    public Project() {
        projectTd = SnowflakeId.empty();
        attribute = ProjectAttribute.empty();


    }

    /**
     * コンストラクター.
     *
     * @param projectTd ID
     * @param attribute 属性
     */
    public Project(SnowflakeId projectTd,
                   ProjectAttribute attribute) {
        this.projectTd = projectTd;
        this.attribute = attribute;
    }


    public static Project create(ProjectAttribute attribute) {
        return create(SnowflakeId.newInstance(), attribute);

    }

    @JsonCreator
    public static Project create(@JsonProperty("id") SnowflakeId id,
                                 @JsonProperty("attribute") ProjectAttribute attribute) {
        return new Project(id, attribute);

    }

    public static Project create(Project project) {
        return new Project(SnowflakeId.newInstance(), project.attribute);

    }

    public static Project newInstance() {
        return new Project(SnowflakeId.newInstance(), ProjectAttribute.empty());
    }

    public static Project empty() {
        return new Project(SnowflakeId.empty(), ProjectAttribute.empty());
    }

    public boolean sameValueAs(Project other) {
        return sameIdAs(other)
                && attribute.equals(other.attribute);

    }

    public boolean sameIdAs(Project other) {
        return projectTd.equals(other.projectTd);

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
        return projectTd.equals(project.projectTd) && attribute.equals(project.attribute);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(getClass(), projectTd, attribute);

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
