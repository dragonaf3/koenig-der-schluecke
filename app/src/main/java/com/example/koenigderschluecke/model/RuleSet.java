package com.example.koenigderschluecke.model;

public class RuleSet {
    private long id;
    private String name;

    public RuleSet(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
