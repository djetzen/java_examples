package de.djetzen.optionals;

import lombok.Data;

import java.util.Optional;

@Data
public class Person {
    private String name;
    private Location location;

    public String getStreet() {
        return Optional.ofNullable(location)
                .map(location -> location.getStreet())
                .map(street -> street.getStreetName())
                .orElse(null);
    }
}
