package template.modules.admin.appl.command.holiday;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.HolidayRepository;
import template.shared.entity.id.SnowflakeId;

@Service
@AllArgsConstructor
public class DeleteHolidayCommand {
    private final HolidayRepository holidayRepository;

    @Transactional
    public void execute(SnowflakeId id) {
        Holiday entity = Holiday.create(id);
        holidayRepository.delete(entity);

    }
}