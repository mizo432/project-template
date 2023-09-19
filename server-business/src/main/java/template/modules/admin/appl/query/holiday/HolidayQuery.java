package template.modules.admin.appl.query.holiday;

import lombok.NonNull;
import template.modules.admin.domain.model.holiday.Holiday;
import template.shared.entity.id.SnowflakeId;

/**
 * 祝日クエリーサービス.
 */
public interface HolidayQuery {

    /**
     * 祝日を全建取得する
     *
     * @return 祝日ファストクラスコレクション
     */
    Holiday.Holidays selectAll();

    /**
     * 祝日IDを検索条件に祝日を検索する
     *
     * @param holidayId 祝日ID
     * @return 検索結果の祝日
     */
    Holiday findOneBy(@NonNull final SnowflakeId holidayId);

}
