package net.santosh.event.source.backend.entity;

import java.util.stream.Stream;

/**
 * @author santosh
 *
 */
public enum CoffeeType {

    ESPRESSO, POUR_OVER, FRENCH_PRESS;

    public static CoffeeType fromString(final String name) {
        return Stream.of(values())
                .filter(v -> v.name().equalsIgnoreCase(name))
                .findAny().orElse(null);
    }
}
