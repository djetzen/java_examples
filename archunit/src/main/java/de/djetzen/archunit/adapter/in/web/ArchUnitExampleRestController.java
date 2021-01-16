package de.djetzen.archunit.adapter.in.web;

import de.djetzen.archunit.application.port.in.SaveDataUseCase;
import de.djetzen.archunit.domain.models.ArchUnitDomain;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArchUnitExampleRestController implements SaveDataUseCase {
    @Override
    public void saveData(ArchUnitDomain domain) {

    }
}
