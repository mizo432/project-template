package template.modules.admin.appl.command.holiday;

import com.undecided.gfw.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.HolidayRepository;

import static com.undecided.primitive.object.Objects2.isNull;

@Service
@AllArgsConstructor
public class UpdateHolidayCommand {
    private final HolidayRepository holidayRepository;

    @Transactional
    public void execute(Holiday holiday) {
        Holiday found = holidayRepository.findOneByHoliday(holiday.getDate());
        if (isNull(found) && holiday.sameIdentifierAs(found)) {
            holidayRepository.update(holiday);

        } else {
            throw new BusinessException("祝日の日付が重複するため本祝日日付には変更できません");
        }


    }
}
