package template.modules.admin.domain.model.project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;
import template.modules.admin.domain.model.project.attribute.ProjectAttribute;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * プロジェクト.
 */
@Getter
@Entity(immutable = true)
@Table(schema = "admin", name = "project")
@ConfigAutowireable
@ToString
@EqualsAndHashCode
public class Project implements Serializable {
    public static final Project EMPTY_ENTITY = new Project();
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "project_id")
    private final SnowflakeId projectTd;

    private final ProjectAttribute attribute;

    /**
     * コンストラクター.
     */
    public Project() {
        projectTd = SnowflakeId.EMPTY_VALUE;
        attribute = ProjectAttribute.EMPTY_VALUE;


    }

    /**
     * コンストラクター.
     *
     * @param projectTd ID
     * @param attribute 属性
     */
    /* default */ Project(final SnowflakeId projectTd,
                          final ProjectAttribute attribute) {
        this.projectTd = projectTd;
        this.attribute = attribute;
    }

    /**
     * ファクトリーメソッド
     *
     * @param attribute 属性
     * @return プロジェクト
     */
    public static Project create(final ProjectAttribute attribute) {
        return create(SnowflakeId.newInstance(), attribute);

    }

    /**
     * ファクトリーメソッド
     *
     * @param projectId ID
     * @param attribute 属性
     * @return プロジェクト
     */
    @JsonCreator
    public static Project create(final @JsonProperty("id") SnowflakeId projectId,
                                 final @JsonProperty("attribute") ProjectAttribute attribute) {
        return new Project(projectId, attribute);

    }

    /**
     * ファクトリーメソッド
     *
     * @param project プロジェクト
     * @return プロジェクト
     */
    public static Project create(final Project project) {
        return new Project(SnowflakeId.newInstance(), project.attribute);

    }

    /**
     * 新しいインスタンスを作成する
     *
     * @return プロジェクト
     */
    public static Project newInstance() {
        return new Project(SnowflakeId.newInstance(), ProjectAttribute.EMPTY_VALUE);
    }

    /**
     * プロジェクトが引数のプロジェクトと値として一致しているかを返却する
     *
     * @param other プロジェクト
     * @return 一致している場合trueを返却する
     */
    public boolean sameValueAs(final Project other) {
        return sameIdAs(other)
                && attribute.equals(other.attribute);

    }

    /**
     * プロジェクトが引数のプロジェクトとIDが一致しているかを返却する
     *
     * @param other プロジェクト
     * @return 一致している場合trueを返却する
     */
    public boolean sameIdAs(final Project other) {
        return projectTd.equals(other.projectTd);

    }

    /**
     * プロジェクトのファストクラスコレクション
     */
    public static class Projects extends AbstractListValue<Project> {

        private static final Projects EMPTY_VALUE = new Projects();

        /**
         * コンストラクター
         *
         * @param value 値
         */
        /* default */Projects(final List<Project> value) {
            super(value);
        }

        /**
         * コンストラクター
         */
        public Projects() {
            super();

        }


        /**
         * 空のプロジェクツ
         *
         * @return プロジェクツ
         */
        public static Projects empty() {
            return EMPTY_VALUE;
        }

        /**
         * 再生成する
         *
         * @param value 値
         * @return プロジェクツ
         */
        public static Projects reconstruct(final List<Project> value) {
            return new Projects(value);
        }

        /**
         * 文字列表現を作成する
         *
         * @return 文字列表現
         */
        @Override
        public String asString() {
            return value.toString();
        }

    }

}
