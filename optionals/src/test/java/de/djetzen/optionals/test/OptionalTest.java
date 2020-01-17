package de.djetzen.optionals.test;

import de.djetzen.optionals.Location;
import de.djetzen.optionals.Person;
import de.djetzen.optionals.Street;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionalTest {

    @Test
    void streetIsReturned() {
        Person p = new Person();
        p.setName("Dominik");
        p.setLocation(Location.builder().street(Street.builder().streetName("Main Street").houseNumber(5).build()).zipCode("00000").city("Frankfurt").build());
        assertEquals("Main Street", p.getStreet());
    }

    @Test
    void locationIsOptional() {
        Person p = new Person();
        p.setName("Dominik");
        assertEquals(null, p.getStreet());
    }

    @Test
    void streetIsOptional() {
        Person p = new Person();
        p.setName("Dominik");
        p.setLocation(Location.builder().zipCode("00000").city("Frankfurt").build());
        assertEquals(null, p.getStreet());
    }
}
