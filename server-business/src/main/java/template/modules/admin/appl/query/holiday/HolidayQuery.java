package template.modules.admin.appl.query.holiday;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.HolidayRepository;
import template.shared.entity.id.SnowflakeId;

/**
 * 祝日クエリーサービス.
 */
@Service
@AllArgsConstructor
public class HolidayQuery {
    private final HolidayRepository holidayRepository;

    public Holiday.Holidays selectAll() {
        return Holiday.Holidays.reconstruct(holidayRepository.selectAll());

    }

    public Holiday findOneBy(@NonNull final SnowflakeId holidayId) {
        return holidayRepository.findOneBy(holidayId);
    }
}
