package template.modules.admin.presentation.web.holiday;

import com.undecided.primitive.list.Lists2;
import lombok.Data;
import template.modules.admin.domain.model.holiday.Holiday;
import template.modules.admin.domain.model.holiday.Holiday.Holidays;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class HolidayForm {
    private Long holidayId;
    private LocalDate holiday;
    private String name;

    public static HolidayForm reconstruct(Holiday holiday) {
        HolidayForm form = new HolidayForm();
        form.setHolidayId(holiday.getHolidayId().getValue());
        form.setHoliday(holiday.getDate());
        form.setName(holiday.getName().getValue());
        return form;

    }

    public Holiday convertToInsertModel() {
        return Holiday.create(holiday, name);
    }


    public static class HolidayFormList {
        public static List<HolidayForm> reconstruct(Holidays holidays) {
            ArrayList<HolidayForm> holidayList = Lists2.newArrayList();
            for (Holiday holiday : holidays.getValue()) {
                holidayList.add(HolidayForm.reconstruct(holiday));

            }

            return holidayList;

        }
    }
}
