package de.djetzen.optionals;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Location {
    private String zipCode;
    private String street;
    private int houseNumber;
    private String city;
}
