package com.codurance.zombies;

import com.codurance.zombies.equipment.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(RuntimeException.class, () -> survivor.getName());
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
    public void have_a_capacity_of_5_maximum_of_equipment() {
        equipmentList.add(baseballbat);
        equipmentList.add(fryingPan);
        equipmentList.add(katana);
        equipmentList.add(pistol);
        equipmentList.add(bottledWater);
        equipmentList.add(pistol);

        Survivor survivor = new Survivor();
        survivor.setName(PEPE);

        assertThrows(RuntimeException.class, ()->survivor.setEquipment(equipmentList));
    }

    @Test
    public void have_a_capacity_of_2_in_hand_and_3_in_reserve() {
        equipmentList.add(baseballbat);
        equipmentList.add(fryingPan);
        equipmentList.add(katana);

        survivor.setName(PEPE);

        assertThrows(RuntimeException.class, ()-> survivor.setInHand(equipmentList));

        equipmentList = new ArrayList<>();
        equipmentList.add(baseballbat);
        equipmentList.add(fryingPan);
        equipmentList.add(katana);
        equipmentList.add(pistol);

        assertThrows(RuntimeException.class, ()-> survivor.setInReserve(equipmentList));
    }
}
