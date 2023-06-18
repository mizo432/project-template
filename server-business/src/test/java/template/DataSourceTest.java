package template;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.seasar.doma.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


@AnalyzeClasses(packages = "template")
public class DataSourceTest {
    @ArchTest
    static final ArchRule DAOs_must_reside_in_a_dao_package =
            classes().that().haveNameMatching(".*DataSource").should().resideInAPackage("..dataSource..")
                    .as("DataSource should reside in a package '..dataSource..'");

    @ArchTest
    static final ArchRule entities_must_reside_in_a_domain_package =
            classes().that().areAnnotatedWith(Entity.class).should().resideInAPackage("..modules.*.domain.model..")
                    .as("Entities should reside in a package '..modules.*.domain.model..'");

}
