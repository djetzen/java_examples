package de.djetzen.optionals;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Location {
    private String zipCode;
    private Street street;
    private String city;
}
