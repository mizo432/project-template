package template.modules.admin.domain.model.glossary;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

/**
 * プロジェクトリポジトリー.
 */
@ConfigAutowireable
@Dao
public interface GlossaryItemRepository {

    /**
     * プロジェクトIDを元にプロジェクトを検索する
     *
     * @param glossaryItemId プロジェクトID
     * @return 検索結果
     */
    @Select
    GlossaryItem findOneById(SnowflakeId glossaryItemId);

    /**
     * プロジェクトを全件検索する
     *
     * @return 検索結果
     */
    @Select
    List<GlossaryItem> selectAll();

    /**
     * プロジェクトを新規追加する
     *
     * @param glossaryItem プロジェクト
     * @return 新規登録結果
     */
    @Insert
    Result<GlossaryItem> insert(GlossaryItem glossaryItem);

    /**
     * プロジェクトを更新する
     *
     * @param glossaryItem プロジェクト
     * @return 更新結果
     */
    @Update
    Result<GlossaryItem> update(GlossaryItem glossaryItem);

    /**
     * プロジェクトIDを元にプロジェクトを削除する
     *
     * @param glossaryItemId プロジェクトID
     * @return 削除件数
     */
    @Delete(sqlFile = true)
    int deleteById(SnowflakeId glossaryItemId);
}
