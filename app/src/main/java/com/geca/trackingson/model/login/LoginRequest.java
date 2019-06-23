package com.geca.trackingson.model.login;

import com.squareup.moshi.Json;

public class LoginRequest {

    @Json(name = "username")
    private String username;
    @Json(name = "password")
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public LoginRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }

}
