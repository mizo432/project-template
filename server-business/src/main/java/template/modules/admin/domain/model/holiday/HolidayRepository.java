package template.modules.admin.domain.model.holiday;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * 祝日リポジトリ
 */
@Dao
@ConfigAutowireable
public interface HolidayRepository {
    @Select
    List<Holiday> selectAll();

}
