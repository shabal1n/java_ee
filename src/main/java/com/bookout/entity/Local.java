package com.bookout.entity;

import java.util.Objects;

public class Local {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Local other = (Local) obj;

        if (this.id != other.getId()) {
            return false;
        }

        if (!Objects.equals(this.name, other.getName())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + this.id;
        return hash;
    }
}
