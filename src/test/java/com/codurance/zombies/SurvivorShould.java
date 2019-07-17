package com.codurance.zombies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SurvivorShould {
    @Test
    public void has_a_name() {
        Survivor survivor = new Survivor("Pepe");
        String name = survivor.getName();
        assertThat(name, is("Pepe"));
    }

    @Test
    public void has_not_name() {
        final Survivor survivor = new Survivor("");
        Assertions.assertThrows(RuntimeException.class, () -> survivor.getName());
    }

    @Test
    public void not_have_initial_wounds() {

        Survivor survivor = new Survivor("Pepe");
        int wounds = survivor.getWounds();
        assertThat(wounds, is(0));
    }
}
