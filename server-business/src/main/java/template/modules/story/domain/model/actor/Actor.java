package template.modules.story.domain.model.actor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import template.modules.story.domain.model.actor.attribute.ActorAttribute;
import template.shared.entity.AuditInfo;
import template.shared.entity.id.SnowflakeId;

/**
 * アクタークラス.
 */
@Getter
@EqualsAndHashCode
@ToString
public class Actor {

    private final SnowflakeId id;
    private final AuditInfo auditInfo;

    private final SnowflakeId projectId;
    private final ActorAttribute attribute;

    /**
     * コンストラクター.
     *
     * @param id        ID
     * @param projectId プロジェクトID
     * @param auditInfo 監査証跡情報
     * @param attribute 即成
     */
    private Actor(SnowflakeId id, SnowflakeId projectId,
                  AuditInfo auditInfo,
                  ActorAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.projectId = projectId;
        this.attribute = attribute;

    }

    /**
     * 空のアクターを取得する.
     *
     * @return アクター
     */
    public static Actor empty() {
        return new Actor(SnowflakeId.EMPTY_VALUE, SnowflakeId.EMPTY_VALUE,
                AuditInfo.EMPTY_VALUE,
                ActorAttribute.EMPTY_VALUE);
    }

    /**
     * 再生成.
     *
     * @param id        ID
     * @param auditInfo 監査証跡情報
     * @param projectId プロジェクトID
     * @param attribute 属性
     * @return アクター
     */
    public static Actor reconstruct(@NotNull SnowflakeId id,
                                    @NotNull AuditInfo auditInfo,
                                    @NotNull SnowflakeId projectId,
                                    @NotNull ActorAttribute attribute) {
        return new Actor(id, projectId, auditInfo, attribute);

    }

    /**
     * アクターを値として一致しているかを調べる.
     *
     * @param other 対象の値
     * @return 一致している場合trueを返却する
     */
    public boolean sameValueAs(Actor other) {
        return id.equals(other.id)
                && projectId.equals(other.projectId)
                && attribute.equals(other.attribute);
    }

}
