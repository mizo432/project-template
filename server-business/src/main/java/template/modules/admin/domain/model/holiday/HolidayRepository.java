package template.modules.admin.domain.model.holiday;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.List;

/**
 * 祝日リポジトリ
 */
@ConfigAutowireable
@Dao
public interface HolidayRepository {
    @Select
    List<Holiday> selectAll();

    /**
     * 祝日を新規で記録する
     *
     * @param holiday 祝日
     * @return 入力結果
     */
    @Insert
    Result<Holiday> insert(Holiday holiday);

}
