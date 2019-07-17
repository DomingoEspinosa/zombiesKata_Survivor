package com.codurance.zombies;

import com.codurance.zombies.equipment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SurvivorShould {

    public static final String PEPE = "Pepe";
    private Survivor survivor;
    private ArrayList<Equipment> equipmentList;
    private Equipment baseballbat;
    private Equipment fryingPan;
    private Equipment katana;
    private Equipment pistol;
    private Equipment bottledWater;

    @BeforeEach
    void setUp() {
        survivor = new Survivor();
        equipmentList = new ArrayList<>();
        baseballbat = new BaseballBat();
        fryingPan = new FryingPan();
        katana = new Katana();
        pistol = new Pistol();
        bottledWater = new BottledWater();
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

    @Test
    public void have_three_actions_per_turn() {
        int actions = survivor.getNumberOfActionsAvailable();
        assertThat(actions, is(3));
    }

    @Test
    public void validate_is_my_turn() {
        boolean turn = survivor.isMyTurn();
        assertThat(turn, is(true));
    }

    @Test
    public void have_a_capacity_of_5_of_equipment() {
        equipmentList.add(baseballbat);
        equipmentList.add(fryingPan);
        equipmentList.add(katana);
        equipmentList.add(pistol);
        equipmentList.add(bottledWater);

        Survivor survivor = new Survivor();
        survivor.setName(PEPE);
        survivor.setEquipment(equipmentList);

        assertThat(survivor.getActualCapacityOfEquipment(), is(5));
    }
}
