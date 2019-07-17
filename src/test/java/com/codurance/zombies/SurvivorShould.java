package com.codurance.zombies;

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
}
