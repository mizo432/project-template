package template.shared.type.description;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

import static com.undecided.primitive.string.Strings2.emptyToNull;

/**
 * 詳細
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class Description extends AbstractStringValue {

    private static final Description EMPTY = new Description();

    /**
     * コンストラクター
     */
    private Description() {
        super();
    }

    /**
     * コンストラクター
     *
     * @param value 値
     */
    Description(String value) {
        super(emptyToNull(value));
    }

    public static Description reconstruct(String value) {
        Description description = new Description(value);
        if (EMPTY.equals(description)) {
            return EMPTY;
        }
        return description;

    }

    public static Description of(String value) {
        return new Description(value);
    }

    public static Description empty() {
        return EMPTY;
    }

}
