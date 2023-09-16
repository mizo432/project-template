package template.modules.admin.appl.command.holiday;

import com.undecided.gfw.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.HolidayRepository;

import static com.undecided.primitive.object.Objects2.isNull;

/**
 * 祝日登録コマンドサービス.
 */
@Service
@AllArgsConstructor
public class InsertHolidayCommand {
    private final HolidayRepository holidayRepository;

    /**
     * 祝日登録を実行する
     *
     * @param holiday 祝日
     */
    @Transactional
    public void execute(@NonNull Holiday holiday) {
        final Holiday found = holidayRepository.findOneByHoliday(holiday.getDate());
        if (isNull(found)) {
            holidayRepository.insert(holiday);

        } else {
            throw new BusinessException("祝日の日付が重複しているため本祝日は登録できません");
        }
    }
}
