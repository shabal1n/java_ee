package com.bookout.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private long id;
    private String firstName;
    private String mobile;
    private String email;
    private String passwordHash;
    private int localId;
    private boolean isAdmin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getLocalId() {
        return localId;
    }

    public String getLocalName() {
        if(localId == 1) return "ru";
        return "en";
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final User other = (User) obj;
        if (this.id != other.getId()) {
            return false;
        }

        if (!Objects.equals(this.firstName, other.getFirstName())) {
            return false;
        }

        if (!Objects.equals(this.mobile, other.getMobile())) {
            return false;
        }

        if (!Objects.equals(this.email, other.getEmail())) {
            return false;
        }

        if (!Objects.equals(this.passwordHash, other.getPasswordHash())) {
            return false;
        }

        if (this.localId != other.getLocalId()) {
            return false;
        }

        if (this.isAdmin != other.isAdmin()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 53 * hash + this.email.hashCode();
        return hash;
    }
}
