package com.geca.trackingson.model.login;

import android.support.annotation.Nullable;

import com.squareup.moshi.Json;

public class LoginResponse {

    public static class User {
        @Json(name = "id")
        private int id;
        @Json(name = "username")
        private String username;
        @Json(name = "firstname")
        private String firstname;
        @Json(name = "lastname")
        private String lastname;
        @Json(name = "dni")
        private String dni;
        @Json(name = "phone")
        private String phone;
        @Json(name = "address")
        private String address;
        @Json(name = "role")
        private Role role;
        @Json(name = "relative")
        private Relative relative;

        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getDni() {
            return dni;
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() {
            return address;
        }

        public Role getRole() {
            return role;
        }

        public Relative getRelative() {
            return relative;
        }
    }

    public static class Role {
        @Json(name = "id")
        private int id;
        @Json(name = "name")
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Relative {
        @Json(name = "id")
        private int id;
        @Json(name = "isOnline")
        private boolean isOnline;

        public int getId() {
            return id;
        }

        public boolean isOnline() {
            return isOnline;
        }
    }

    @Nullable
    @Json(name = "expiresIn")
    private String expiresIn;
    @Nullable
    @Json(name = "accessToken")
    private String accessToken;
    @Nullable
    @Json(name = "user")
    private User user;

    public LoginResponse(String expiresIn, String accessToken, User user) {
        this.expiresIn = expiresIn;
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public LoginResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public User getUser() {
        return user;
    }

    public LoginResponse setUser(User user) {
        this.user = user;
        return this;
    }
}
