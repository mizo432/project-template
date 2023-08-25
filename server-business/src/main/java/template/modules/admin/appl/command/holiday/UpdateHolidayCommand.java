package template.modules.admin.appl.command.holiday;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.HolidayRepository;

@Service
@AllArgsConstructor
public class UpdateHolidayCommand {
    private final HolidayRepository holidayRepository;

    @Transactional
    public void execute(Holiday holiday) {
        holidayRepository.update(holiday);

    }
}
