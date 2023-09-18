package template.modules.admin.domain.model.project.attribute;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

import java.io.Serial;
import java.io.Serializable;

/**
 * プロジェクト名
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class ProjectName extends AbstractStringValue implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final ProjectName EMPTY_VALUE = new ProjectName();

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default */ProjectName(final String value) {
        super(value);

    }

    /**
     * コンストラクター
     */
    public ProjectName() {
        super();

    }


    /**
     * ヌルオブジェクトを取得する
     *
     * @return プロジェクト名
     */
    public static ProjectName empty() {
        return EMPTY_VALUE;
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
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }
        return new ProjectName(value);


    }
}
