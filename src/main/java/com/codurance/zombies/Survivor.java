package com.codurance.zombies;

import com.codurance.zombies.equipment.Equipment;

import java.util.ArrayList;

public class Survivor {

    private boolean myTurn;
    private int numberOfActions;
    private int wounds;
    private String name;
    private ArrayList<Equipment> equipments;

    public Survivor() {
        wounds = 0;
        numberOfActions = 3;
        myTurn = true;
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

    public int getActualCapacityOfEquipment() {
        return equipments.size();
    }

    public void setEquipment(ArrayList<Equipment> equipmentList) {
        this.equipments = equipmentList;
    }
}
