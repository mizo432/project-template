package template.modules.admin.appl.query.holiday;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.HolidayRepository;

@Service
@AllArgsConstructor
public class HolidayQuery {
    private final HolidayRepository holidayRepository;

    public Holiday.Holidays selectAll() {
        return Holiday.Holidays.reconstruct(holidayRepository.selectAll());

    }
}
