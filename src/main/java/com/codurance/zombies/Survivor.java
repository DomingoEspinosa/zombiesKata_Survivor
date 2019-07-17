package com.codurance.zombies;

public class Survivor {

    private int wounds;
    private String name;

    public Survivor() {
        wounds = 0;
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
}
