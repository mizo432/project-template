package template.modules.admin.infra.query.holiday;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import template.modules.admin.appl.query.holiday.HolidayQuery;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.HolidayRepository;
import template.shared.entity.id.SnowflakeId;

/**
 * 祝日クエリーサービス.
 */
@Service
@AllArgsConstructor
public class HolidayQueryImpl implements HolidayQuery {
    private final HolidayRepository holidayRepository;

    /**
     * 祝日を全建取得する
     *
     * @return 祝日ファストクラスコレクション
     */
    public Holiday.Holidays selectAll() {
        return Holiday.Holidays.reconstruct(holidayRepository.selectAll());

    }

    /**
     * 祝日IDを検索条件に祝日を検索する
     *
     * @param holidayId 祝日ID
     * @return 検索結果の祝日
     */
    public Holiday findOneBy(@NonNull final SnowflakeId holidayId) {
        return holidayRepository.findOneBy(holidayId);

    }
}
