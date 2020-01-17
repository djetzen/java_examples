package de.djetzen.optionals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Street {
    private String streetName;
    private Integer houseNumber;
}
