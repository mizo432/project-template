package template.shared.entity;

public interface DddEntity<E extends DddEntity<E>> {

    /**
     * Idが一致しているかを返します。
     *
     * @param other エンティティ
     * @return IDが一致している場合、trueを返します。
     */
    boolean sameIdAs(E other);

    /**
     * エンティティの属性がすべて一致しているかを返します。
     * <pre>
     * 監査用のAudit情報は一致しているかの判定には使用しません。
     * </pre>
     *
     * @param other エンティティ
     * @return エンティティの属性がすべて一致していると<code>true</code>を返します
     */
    boolean sameValueAs(E other);

}
