package template.shared.value;

import java.util.Set;

/**
 * セット値インターフェイス
 *
 * @param <I> セットの要素の型
 */
public interface SetValue<I> {

    /**
     * 値を取得する
     *
     * @return 値
     */
    Set<I> getValue();
}
