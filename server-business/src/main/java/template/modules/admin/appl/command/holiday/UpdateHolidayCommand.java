package template.modules.admin.appl.command.holiday;

import com.undecided.gfw.common.exception.BusinessException;
import com.undecided.primitive.object.Objects2;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.HolidayRepository;

/**
 * 祝日更新コマンドサービス.
 */
@Service
@AllArgsConstructor
public class UpdateHolidayCommand {
    private final HolidayRepository holidayRepository;

    /**
     * 祝日更新コマンドの実行
     *
     * @param holiday 祝日
     */
    @Transactional
    public void execute(@NonNull Holiday holiday) {
        final Holiday found = holidayRepository.findOneByHoliday(holiday.getDate());
        if (Objects2.nonNull(found) && holiday.sameIdentifierAs(found)) {
            holidayRepository.update(holiday);

        } else {
            throw new BusinessException("祝日の日付が重複するため本祝日日付には変更できません");
        }


    }
}
