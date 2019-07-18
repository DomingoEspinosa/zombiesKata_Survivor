package com.codurance.zombies;

import com.codurance.zombies.equipment.Equipment;

import java.util.ArrayList;

public class Survivor {

    private static final int MAXIMUM_CAPACITY = 5;
    private static final int MAXIMUM_IN_RESERVE = 3;
    private static final int MAXIMUM_IN_HAND = 2;
    private boolean myTurn;
    private int numberOfActions;
    private int wounds;
    private String name;
    private ArrayList<Equipment> equipmentInHand;
    private ArrayList<Equipment> equipmentInReserve;


    public Survivor() {
        wounds = 0;
        numberOfActions = 3;
        myTurn = true;
        equipmentInHand = new ArrayList<>();
        equipmentInReserve = new ArrayList<>();
    }

    public String getName() {
        if (name.equals("")) {
            throw new RuntimeException();
        }
        return name;
    }

    public int getWounds() {
        return wounds;
    }

    public boolean isAlive() {
        return wounds < 2;
    }

    public void increaseWounds(int wound) {
        this.wounds += wound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfActionsAvailable() {
        return numberOfActions;
    }

    public boolean isMyTurn() {
        return myTurn;
    }


    public void setEquipment(ArrayList<Equipment> equipmentList) {
        if (equipmentList.size() > MAXIMUM_CAPACITY) {
            throw new RuntimeException();
        }
        for (Equipment equipment : equipmentList) {
            if (equipmentInHand.size() < MAXIMUM_IN_HAND) {
                setInHand(equipment);
            }
            if (equipmentInReserve.size() < MAXIMUM_IN_RESERVE) {
                setInReserve(equipment);
            }
        }
    }

    public void setInHand(Equipment equipment) {
        if (equipmentInHand.size() >= MAXIMUM_IN_HAND) {
            throw new RuntimeException();
        }
        equipmentInHand.add(equipment);
    }

    public void setInReserve(Equipment equipment) {
        if (equipmentInReserve.size() >= MAXIMUM_IN_RESERVE) {
            throw new RuntimeException();
        }
        equipmentInReserve.add(equipment);
    }
}
