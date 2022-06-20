package com.bookout.enitiy;

public class Local {
    private int id;
    private String shortName;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocalId(String local) {
        if (local.equals("ru")) return 1;
        return 2;
    }
}
