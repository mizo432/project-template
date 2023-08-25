package template.modules.admin.domain.model.holiday;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import template.shared.entity.id.SnowflakeId;

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

    @Delete
    Result<Holiday> delete(Holiday holiday);

    @Select
    Holiday findOneBy(SnowflakeId holidayId);

    @Update
    Result<Holiday> update(Holiday holiday);
}
