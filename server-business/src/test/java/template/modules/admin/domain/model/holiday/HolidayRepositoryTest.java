package template.modules.admin.domain.model.holiday;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class
})
class HolidayRepositoryTest {

    @Autowired
    private HolidayRepository holidayRepository;

    @Transactional
    @Test
    @Tag("MEDIUM")
        // @Sql(scripts = "../../../schema-dev.sql") // DMLを実行する。ここではテーブルをDrop&Createしている
        // @Sql(scripts = "data_employee.sql") // テスト対象のデータをInsertしている
    void selectAll() {
        List<Holiday> actual = holidayRepository.selectAll();
        assertThat(actual).isNotNull();
    }
}
