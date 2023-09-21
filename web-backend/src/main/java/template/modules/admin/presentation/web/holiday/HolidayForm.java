package template.modules.admin.presentation.web.holiday;

import com.undecided.primitive.list.Lists2;
import lombok.Data;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.Holiday.Holidays;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 祝日フォーム
 */
@Data
public class HolidayForm {
    private Long holidayId;
    private LocalDate holiday;
    private String name;

    /**
     * ファクトリーメソッド
     *
     * @param holiday 祝日
     * @return 祝日フォーム
     */
    public static HolidayForm reconstruct(final Holiday holiday) {
        HolidayForm form = new HolidayForm();
        form.setHolidayId(holiday.getHolidayId().getValue());
        form.setHoliday(holiday.getDate());
        form.setName(holiday.getName().getValue());
        return form;

    }

    /**
     * 新規登録用モデルに変換する
     *
     * @return 祝日
     */
    public Holiday convertToInsertModel() {
        return Holiday.create(holiday, name);

    }

    /**
     * 更新用モデルに変換する
     *
     * @return 祝日
     */
    public Holiday convertToUpdateModel() {
        return Holiday.create(holidayId, holiday, name);

    }


    /**
     * 祝日フォームのファーストクラスコレクション
     */
    public static class HolidayFormList {
        public static List<HolidayForm> reconstruct(final Holidays holidays) {
            ArrayList<HolidayForm> holidayList = Lists2.newArrayList();
            for (Holiday holiday : holidays.getValue()) {
                holidayList.add(HolidayForm.reconstruct(holiday));

            }

            return holidayList;

        }
    }
}
