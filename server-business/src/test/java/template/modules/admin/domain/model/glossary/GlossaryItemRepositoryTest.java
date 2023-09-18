package template.modules.admin.domain.model.glossary;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;
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
public class GlossaryItemRepositoryTest {
    @Autowired
    private GlossaryItemRepository glossaryItemRepository;

    @Test
    @Tag("MEDIUM")
    @Transactional
    @Timeout(value = 1)
    void selectAll() {
        final List<GlossaryItem> actual = glossaryItemRepository.selectAll();

        assertThat(actual)
                .isNotNull()
                .hasSize(0);


    }

    @Test
    @Tag("MEDIUM")
    @Transactional
    @Timeout(value = 1)
    void insert() {
        // given
        GlossaryItem gi = GlossaryItem.create("用語", "用語読み", "詳細");

        glossaryItemRepository.insert(gi);

        final List<GlossaryItem> actual = glossaryItemRepository.selectAll();

        assertThat(actual)
                .isNotNull()
                .hasSize(1);


    }

}
