package com.geca.trackingson.utility;

public class Session {
    private String accessToken;
    private String userId;
    private String relativeId;

    public Session() {
    }

    public Session(String accessToken, String userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Session setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Session setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getRelativeId() {
        return relativeId;
    }

    public Session setRelativeId(String relativeId) {
        this.relativeId = relativeId;
        return this;
    }
}
