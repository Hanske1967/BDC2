package be.mloz.bdc;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("be.mloz.bdc");

        noClasses()
            .that()
            .resideInAnyPackage("be.mloz.bdc.service..")
            .or()
            .resideInAnyPackage("be.mloz.bdc.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..be.mloz.bdc.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
