package template.modules.admin.domain.model.project.attribute;

import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class ProjectCode extends AbstractStringValue {

    private static final ProjectCode EMPTY = new ProjectCode();

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default */ProjectCode(final String value) {
        super(value);
    }

    /**
     * コンストラクター
     */
    public ProjectCode() {

    }


    public static ProjectCode empty() {
        return EMPTY;
    }


    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return プロジェクトコード
     */
    public static ProjectCode of(final String value) {
        StringPreconditions.checkNotEmpty(value, "プロダクトコード");
        return new ProjectCode(value);

    }

    /**
     * 再生成メソッド
     *
     * @param value 値
     * @return プロジェクトコード
     */
    public static ProjectCode reconstruct(final String value) {
        return new ProjectCode(value);


    }
}
