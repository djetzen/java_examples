package de.djetzen.archunit.application.port.out;

import de.djetzen.archunit.domain.models.ArchUnitDomain;

public interface DatabasePort {
    void saveToDatabase(ArchUnitDomain domain);
}
