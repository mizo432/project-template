package template.modules.admin.domain.model.project.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;

import java.io.Serial;
import java.io.Serializable;

/**
 * プロジェクト属性
 */
@Getter
@Embeddable
@ToString
public class ProjectAttribute implements Serializable {
    /**
     * nullオブジェクト
     */
    public static final ProjectAttribute EMPTY_VALUE = new ProjectAttribute();
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "project_name")
    private final ProjectName projectName;
    @Column(name = "project_code")
    private final ProjectCode projectCode;
    @Column(name = "story_code_prefix")
    private final StoryCodePrefix storyCodePrefix;


    /**
     * コンストラクター
     */
    public ProjectAttribute() {
        this.projectName = ProjectName.EMPTY_VALUE;
        this.projectCode = ProjectCode.EMPTY_VALUE;
        this.storyCodePrefix = StoryCodePrefix.EMPTY_VALUE;

    }

    /**
     * コンストラクター
     *
     * @param projectName     プロジェクト名
     * @param projectCode     プロジェクトコード
     * @param storyCodePrefix ストーリーコードプレフィックス
     */
    /* default */ ProjectAttribute(final ProjectName projectName, final ProjectCode projectCode,
                                   final StoryCodePrefix storyCodePrefix) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.storyCodePrefix = storyCodePrefix;
    }


    /**
     * ファクトリーメソッド
     *
     * @param projectName     プロジェクト名
     * @param projectCode     プロジェクトコード
     * @param storyCodePrefix ストーリーコードプレフィックス
     * @return プロジェクト属性
     */
    @JsonCreator
    public static ProjectAttribute create(
            @JsonProperty("projectName") final ProjectName projectName,
            @JsonProperty("projectCode") final ProjectCode projectCode,
            @JsonProperty("storyCodePrefix") final StoryCodePrefix storyCodePrefix) {
        return new ProjectAttribute(projectName, projectCode, storyCodePrefix);
    }

    /**
     * ファクトリーメソッド
     *
     * @param projectName     プロジェクト名
     * @param projectCode     プロジェクトコード
     * @param storyCodePrefix ストーリーコードプレフィックス
     * @return プロジェクト属性
     */
    public static ProjectAttribute create(final String projectName, final String projectCode, final String storyCodePrefix) {
        return create(ProjectName.of(projectName), ProjectCode.of(projectCode), StoryCodePrefix.of(storyCodePrefix));
    }
}
