package de.djetzen.archunit.application.port.in;

import de.djetzen.archunit.domain.models.ArchUnitDomain;

public interface SaveDataUseCase {
    void saveData(ArchUnitDomain domain);
}
