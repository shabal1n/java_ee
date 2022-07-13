package com.bookout.enitiy;

import java.io.Serializable;

import static com.bookout.util.Constants.categories;

public class Restaurant implements Serializable {
    private int id;
    private int localItemId;
    private int categoryId;
    private String name;
    private String image;
    private String address;
    private int capacity;
    private double rating;
    private int currFreeSpace;
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

    public int getCurrFreeSpace() {
        return currFreeSpace;
    }

    public void setCurrFreeSpace(int currFreeSpace) {
        this.currFreeSpace = currFreeSpace;
    }

    public String getCategoryName() {
        return categories.get(this.categoryId).getName();
    }
}
