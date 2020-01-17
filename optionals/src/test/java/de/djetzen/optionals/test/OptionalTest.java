package de.djetzen.optionals.test;

import de.djetzen.optionals.Location;
import de.djetzen.optionals.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionalTest {

    @Test
    void getStreetIsReturned() {
        Person p = new Person();
        p.setName("Dominik");
        p.setLocation(Location.builder().street("Main Street").zipCode("00000").city("Frankfurt").houseNumber(5).build());
        assertEquals("Main Street",p.getStreet());
    }

    @Test
    void ortIsOptional(){
        Person p = new Person();
        p.setName("Dominik");
        assertEquals(null, p.getStreet());
    }
}
