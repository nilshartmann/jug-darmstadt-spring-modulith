package nh.demo.plantify;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.core.Violation;
import org.springframework.modulith.docs.Documenter;

import static java.util.function.Predicate.not;

public class PlantifyModuleTest {

    @Test
    void write_document() {
        var modules = ApplicationModules.of(PlantifyApplication.class);

        new Documenter(modules)
            .writeDocumentation();
    }

    @Test
    void verify_modules() {
        var modules = ApplicationModules
            .of(PlantifyApplication.class);

        modules.detectViolations()
//            .filter(not(this::isKnownPlantCareModuleCycle))
            .throwIfPresent();
    }

    private boolean isKnownPlantCareModuleCycle(Violation violation) {
        // Message:
        //        Cycle detected:
        //          Slice care ->
        //          Slice plant ->
        //          Slice care
        return violation.hasMessageContaining("Cycle detected")
               && violation.hasMessageContaining("Slice plant")
               && violation.hasMessageContaining("Slice care");
    }

}
