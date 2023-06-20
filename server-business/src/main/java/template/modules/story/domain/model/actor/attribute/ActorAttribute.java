package template.modules.story.domain.model.actor.attribute;

import lombok.*;
import template.shared.type.description.Description;
import template.shared.value.name.Name;

/**
 * アクター属性クラス.
 */
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ActorAttribute {

    /**
     * 名称.
     */
    private Name name;
    /**
     * 詳細.
     */
    private Description description;

    /**
     * 再生成.
     *
     * @param name        名前
     * @param description 詳細
     * @return アクター属性
     */
    public static ActorAttribute reconstruct(String name, String description) {
        return reconstruct(Name.reconstruct(name), Description.reconstruct(description));
    }

    /**
     * 再生成.
     *
     * @param name        名前
     * @param description 詳細
     * @return アクター属性
     */
    public static ActorAttribute reconstruct(Name name, Description description) {
        return new ActorAttribute(name, description);

    }

    /**
     * 空のアクター属性を返却する.
     *
     * @return アクター属性
     */
    public static ActorAttribute empty() {
        return new ActorAttribute(Name.empty(), Description.empty());
    }
}
