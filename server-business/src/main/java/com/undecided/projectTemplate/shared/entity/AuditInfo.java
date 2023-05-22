package com.undecided.projectTemplate.shared.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.gfw.common.exception.SystemException;
import com.undecided.projectTemplate.resource.domain.partyRole.user.User;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import com.undecided.projectTemplate.shared.value.ValuePreconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.VisibleForTesting;
import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;

import java.time.LocalDateTime;

/**
 * 監査証跡
 */
@Getter
@EqualsAndHashCode
@ToString
@Embeddable
public class AuditInfo {

    @Column(name = "created_at", insertable = false, updatable = false)
    private final WhenNoticed whenNoticed;
    @Column(name = "created_by", updatable = false)
    private WhoNoticed whoNoticed;

    /**
     * コンストラクター
     */
    public AuditInfo() {
        this.whenNoticed = WhenNoticed.empty();
        this.whoNoticed = WhoNoticed.empty();
    }

    /**
     * コンストラクター
     *
     * @param whenNoticed 登録日時
     * @param whoNoticed  登録者
     */
    @VisibleForTesting
    public AuditInfo(WhenNoticed whenNoticed, WhoNoticed whoNoticed) {
        this.whenNoticed = whenNoticed;
        this.whoNoticed = whoNoticed;
    }

    /**
     * 再生成
     *
     * @param whenNoticed 登録日時
     * @param whoNoticed  登録者
     * @return 監査証跡
     */
    public static AuditInfo reconstruct(LocalDateTime whenNoticed, Long whoNoticed) {
        return new AuditInfo(WhenNoticed.reconstruct(whenNoticed),
                WhoNoticed.reconstruct(whoNoticed));

    }

    /**
     * ファクトリー
     *
     * @param whoNoticed 登録者
     * @return 監査証跡
     */
    public static AuditInfo of(Long whoNoticed) {
        return of(WhoNoticed.reconstruct(whoNoticed));

    }

    /**
     * ファクトリー
     *
     * @param whoNoticed 登録者
     * @return 監査証跡
     */
    public static AuditInfo of(WhoNoticed whoNoticed) {
        return new AuditInfo(WhenNoticed.now(),
                whoNoticed);

    }

    /**
     * 空オブジェクトを生成する
     *
     * @return 監査証跡
     */
    public static AuditInfo empty() {
        return new AuditInfo(WhenNoticed.empty(), WhoNoticed.empty());
    }

    /**
     * 登録者IDをセットする
     *
     * @param userId 登録者ID
     */
    public void setWhoNoticed(SnowflakeId<User> userId) {
        ValuePreconditions.checkNotEmpty(userId, () -> new SystemException("E0001001", "userIdが指定されていません"));
        whoNoticed = WhoNoticed.of(userId);
    }

    /**
     * 空オブジェクトかを判定する
     *
     * @return 空オブジェクトの場合<code>true</code>を返す
     */
    @JsonIgnore
    public boolean isEmpty() {
        return whenNoticed.isEmpty() && whoNoticed.isEmpty();
    }
}
