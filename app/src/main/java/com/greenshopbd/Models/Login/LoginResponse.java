package com.greenshopbd.Models.Login;

public class LoginResponse {
    private Boolean error;
    private String message;
    private String token;
    private User user;

    public LoginResponse(Boolean error, String message, String token, User user) {
        this.error = error;
        this.message = message;
        this.token = token;
        this.user = user;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
