package template.modules.admin.domain.model.holiday;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.seasar.doma.boot.autoconfigure.DomaAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
//@JdbcTest // DB部分のコンポーネントだけロードする ※1
@Import(DomaAutoConfiguration.class) // Doma2のconfigurationをimport
// @ComponentScan // テスト対象の実装Beanをscan
// @Sql(scripts = "../../../schema-dev.sql") // DMLを実行する。ここではテーブルをDrop&Createしている
// @Sql(scripts = "data_employee.sql") // テスト対象のデータをInsertしている
@Disabled
public class HolidayRepositoryTest {
    @Autowired
    private HolidayRepository holidayRepository;

    @Transactional
    @Test
    @Tag("Large")
        // @Sql(scripts = "../../../schema-dev.sql") // DMLを実行する。ここではテーブルをDrop&Createしている
        // @Sql(scripts = "data_employee.sql") // テスト対象のデータをInsertしている
    void testSelectAll() {
        List<Holiday> actual = holidayRepository.selectAll();
        assertThat(actual).isNotNull();
    }
}
