package com.codurance.zombies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SurvivorShould {

    public static final String PEPE = "Pepe";
    private Survivor survivor;

    @BeforeEach
    void setUp() {
        survivor = new Survivor();
    }

    @Test
    public void has_a_name() {
        survivor.setName(PEPE);
        assertThat(survivor.getName(), is(PEPE));
    }

    @Test
    public void has_not_name() {
        survivor.setName("");
        Assertions.assertThrows(RuntimeException.class, () -> survivor.getName());
    }

    @Test
    public void not_have_initial_wounds() {
        survivor.setName(PEPE);
        assertThat(survivor.getWounds(), is(0));
    }

    @Test
    public void must_die_with_have_2_wounds() {
        survivor.setName(PEPE);
        survivor.increaseWounds(2);
        assertThat(survivor.isAlive(), is(false));
    }
}
