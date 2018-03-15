package com.woodman.testtravelapp.model;

import java.util.UUID;

/**
 * Created by Zver on 07.03.2018.
 */

public class User {

    private UUID uuid;
    private String fullName;
    private String email;
    private String password;

    public User() {
    }

    public User( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
