package com.codurance.zombies;

public class Survivor {

    private int wounds;
    private String name;

    public Survivor(String name) {
        this.name = name;
        wounds = 0;
    }

    public String getName() {
        if(name.equals("")){
            throw new RuntimeException();
        }
        return name;
    }

    public int getWounds() {
        return wounds;
    }
}
