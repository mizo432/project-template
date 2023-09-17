package template.modules.admin.domain.model.project;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import template.modules.admin.domain.model.project.attribute.ProjectCode;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

/**
 * プロジェクトリポジトリー.
 */
@ConfigAutowireable
@Dao
public interface ProjectRepository {

    /**
     * プロジェクトIDを元にプロジェクトを検索する
     *
     * @param projectId プロジェクトID
     * @return 検索結果
     */
    @Select
    Project findOneById(SnowflakeId projectId);

    /**
     * プロジェクトを全件検索する
     *
     * @return 検索結果
     */
    @Select
    List<Project> selectAll();

    /**
     * プロジェクトを新規追加する
     *
     * @param project プロジェクト
     * @return 新規登録結果
     */
    @Insert
    Result<Project> insert(Project project);

    /**
     * プロジェクトを更新する
     *
     * @param project プロジェクト
     * @return 更新結果
     */
    @Update
    Result<Project> update(Project project);

    /**
     * プロジェクトコードを元にプロジェクトを検索する
     *
     * @param projectCode プロジェクトコード
     * @return 検索結果
     */
    @Select
    Project findOneByProjectCode(ProjectCode projectCode);

    /**
     * プロジェクトIDを元にプロジェクトを削除する
     *
     * @param projectId プロジェクトID
     * @return 削除件数
     */
    @Delete(sqlFile = true)
    int deleteById(SnowflakeId projectId);
}
