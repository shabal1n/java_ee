package com.bookout.entity;

import java.io.Serializable;
import java.util.Objects;

public class Restaurant implements Serializable {
    private int id;
    private int localItemId;
    private int categoryId;
    private String name;
    private String image;
    private String address;
    private int capacity;
    private double rating;
    private int localId;

    public int getLocalItemId() {
        return localItemId;
    }

    public void setLocalItemId(int local_item_id) {
        this.localItemId = local_item_id;
    }

    public String getImageUrl() {
        return image;
    }

    public void setImageUrl(String image) {
        this.image = image;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Restaurant other = (Restaurant) obj;
        if (this.id == other.getId()) {
            return false;
        }

        if (this.localItemId != other.getLocalItemId()) {
            return false;
        }

        if (this.categoryId != other.getCategoryId()) {
            return false;
        }

        if (!Objects.equals(this.name, other.getName())) {
            return false;
        }

        if (!Objects.equals(this.image, other.getImageUrl())) {
            return false;
        }

        if(!Objects.equals(this.address, other.getAddress())) {
            return false;
        }

        if(this.capacity == other.getCapacity()) {
            return false;
        }

        if (this.rating == other.getRating()) {
            return false;
        }

        if (this.localId == other.getLocalId()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 6;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = (int) (53 * hash + this.id + this.address.hashCode());
        return hash;
    }
}
