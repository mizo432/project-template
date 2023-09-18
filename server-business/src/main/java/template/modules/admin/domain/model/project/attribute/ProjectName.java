package template.modules.admin.domain.model.project.attribute;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

/**
 * プロジェクト名
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class ProjectName extends AbstractStringValue {

    private static final ProjectName EMPTY = new ProjectName();

    /**
     * コンストラクター
     *
     * @param value 値
     */
    ProjectName(final String value) {
        super(value);

    }

    /**
     * コンストラクター
     */
    public ProjectName() {

    }


    /**
     * ヌルオブジェクトを取得する
     *
     * @return プロジェクト名
     */
    public static ProjectName empty() {
        return EMPTY;
    }

    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return プロジェクト名
     */
    public static ProjectName of(final String value) {
        StringPreconditions.checkNotEmpty(value, "プロダクト名");
        return new ProjectName(value);

    }

    /**
     * 再生成
     *
     * @param value 値
     * @return プロおジェクト名
     */
    public static ProjectName reconstruct(final String value) {
        if (Strings2.isEmpty(value))
            return EMPTY;
        return new ProjectName(value);


    }
}
