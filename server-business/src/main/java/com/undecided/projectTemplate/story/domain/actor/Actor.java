package com.undecided.projectTemplate.story.domain.actor;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import com.undecided.projectTemplate.story.domain.actor.attribute.ActorAttribute;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

/**
 * アクタークラス
 */
@Getter
@EqualsAndHashCode
@ToString
public class Actor {

    private final SnowflakeIdentifier<Actor> id;
    private final AuditInfo auditInfo;

    private final SnowflakeIdentifier<Project> projectId;
    private final ActorAttribute attribute;

    /**
     * コンストラクター
     *
     * @param id        ID
     * @param projectId プロジェクトID
     * @param auditInfo 監査証跡情報
     * @param attribute 即成
     */
    private Actor(SnowflakeIdentifier<Actor> id, SnowflakeIdentifier<Project> projectId,
                  AuditInfo auditInfo,
                  ActorAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.projectId = projectId;
        this.attribute = attribute;

    }

    /**
     * 空のアクターを取得する
     *
     * @return アクター
     */
    public static Actor empty() {
        return new Actor(SnowflakeIdentifier.empty(), SnowflakeIdentifier.empty(),
                AuditInfo.empty(),
                ActorAttribute.empty());
    }

    /**
     * 再生成
     *
     * @param id        ID
     * @param auditInfo 監査証跡情報
     * @param projectId プロジェクトID
     * @param attribute 属性
     * @return アクター
     */
    public static Actor reconstruct(@NotNull SnowflakeIdentifier<Actor> id,
                                    @NotNull AuditInfo auditInfo,
                                    @NotNull SnowflakeIdentifier<Project> projectId,
                                    @NotNull ActorAttribute attribute) {
        return new Actor(id, projectId, auditInfo, attribute);

    }

    /**
     * アクターを値として一致しているかを調べる
     *
     * @param other 対象の値
     * @return 一致している場合trueを返却する
     */
    public boolean sameValueAs(Actor other) {
        return id.equals(other.id) &&
                projectId.equals(other.projectId) &&
                attribute.equals(other.attribute);
    }

}
