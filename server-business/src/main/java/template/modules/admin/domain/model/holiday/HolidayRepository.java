package template.modules.admin.domain.model.holiday;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import template.shared.entity.id.SnowflakeId;

import java.time.LocalDate;
import java.util.List;

/**
 * 祝日リポジトリ
 */
@ConfigAutowireable
@Dao
public interface HolidayRepository {
    /**
     * 祝日を全件取得する
     *
     * @return 祝日のリスト
     */
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

    /**
     * 祝日を削除する
     *
     * @param holiday 祝日
     * @return 処理結果
     */
    @Delete
    Result<Holiday> delete(Holiday holiday);

    /**
     * 祝日1IDをキーに祝日を検索する
     *
     * @param holidayId 祝日ID
     * @return 祝日
     */
    @Select
    Holiday findOneBy(SnowflakeId holidayId);

    /**
     * 祝日を更新する
     *
     * @param holiday 祝日
     * @return 更新結果
     */
    @Update
    Result<Holiday> update(Holiday holiday);

    /**
     * 祝日を祝日日付をキーに検索する
     *
     * @param holiday 祝日日付
     * @return 祝日
     */
    @Select
    Holiday findOneByHoliday(LocalDate holiday);
}
