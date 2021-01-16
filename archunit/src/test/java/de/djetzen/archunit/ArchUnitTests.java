package de.djetzen.archunit;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaAnnotation;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

class ArchUnitTests {

    private ImportOption ignoreConfigurations = location -> !location.contains("/configuration/");

    private String BASE_PACKAGE = "de.djetzen.archunit";

    private JavaClasses classesOfProjectWithoutConfiguration = new ClassFileImporter()
            .withImportOption(ignoreConfigurations)
            .importPackages(BASE_PACKAGE+"..");

    @Test
    void onionArchitecturePackageStructureIsFine() {
        onionArchitecture()
                .domainModels(BASE_PACKAGE+".domain.models..")
                .domainServices(BASE_PACKAGE+".domain.services..")
                .applicationServices(BASE_PACKAGE+"..application..")
                .adapter("persistence", BASE_PACKAGE+".adapter.out.persistence..")
                .adapter("rest", BASE_PACKAGE+".adapter.in.web..")
                .withOptionalLayers(true)
                .check(classesOfProjectWithoutConfiguration);
    }

    @Test
    void classesInPortsPackageShouldHavePortOrUseCaseInName() {
        classes().that().resideInAPackage("..port..")
                .should().haveNameMatching(".*Port")
                .orShould().haveNameMatching(".*UseCase").check(classesOfProjectWithoutConfiguration);
    }

    @Test
    void classesAnnotatedWithRestControllerAnnotationShouldHaveControllerInName() {
        classes().that().areAnnotatedWith(RestController.class)
                .should().haveNameMatching(".*Controller").check(classesOfProjectWithoutConfiguration);
    }

    @Test
    void domainPackageShouldHaveNoDependenciesToSpring() {
        DescribedPredicate<JavaAnnotation> springAnnotationPredicate = new DescribedPredicate<>("Filter for org.spring package") {
            @Override
            public boolean apply(JavaAnnotation input) {
                return input.getType().getName().startsWith("org.spring");
            }
        };

        classes().that().resideInAPackage("..domain..").should()
                .notBeAnnotatedWith(springAnnotationPredicate).check(classesOfProjectWithoutConfiguration);
    }
}
