package com.codurance.zombies;

public class Survivor {

    private String name;

    public Survivor(String name) {
        this.name = name;
    }

    public String getName() {
        if(name.equals("")){
            throw new RuntimeException();
        }
        return name;
    }
}
