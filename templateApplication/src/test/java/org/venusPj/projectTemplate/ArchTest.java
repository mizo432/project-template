package com.lissajous.taxiDispatcher;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption.Predefined;
import org.junit.jupiter.api.Test;

public class ArchTest {

    private static final String ROOT = "org.venusPj.projectTemplate";
    private static final String SHARED = "org.venusPj.projectTemplate.shared";
    private static final String MODULES = "org.venusPj.projectTemplate.modules";
    JavaClasses CLASSES = new ClassFileImporter()
        .withImportOption(Predefined.DO_NOT_INCLUDE_TESTS)
        .importPackages(ROOT);

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void _moduleパッケージが公開インターフェイス以外の外部のモジュールに依存しないこと() {
        noClasses()
            .should()
            .dependOnClassesThat(new DescribedPredicate<>("moduleパッケージに別モジュールパッケージの依存が存在するか") {
                @Override
                public boolean apply(JavaClass javaClass) {
                    // ここに設定を制約を書く
                    return false;
                }
            })
            .check(CLASSES);
    }
}
