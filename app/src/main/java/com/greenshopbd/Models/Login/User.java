package com.greenshopbd.Models.Login;

public class User {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String confirmpass;
    private String address_arr;
    private String role;
    private String blockuser;
    private String wishlist;
    private String created_at;
    private String updated_at;

    public User(String id, String username, String email, String phone, String password, String confirmpass, String address_arr, String role, String blockuser, String wishlist, String created_at, String updated_at) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.confirmpass = confirmpass;
        this.address_arr = address_arr;
        this.role = role;
        this.blockuser = blockuser;
        this.wishlist = wishlist;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public String getAddress_arr() {
        return address_arr;
    }

    public void setAddress_arr(String address_arr) {
        this.address_arr = address_arr;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBlockuser() {
        return blockuser;
    }

    public void setBlockuser(String blockuser) {
        this.blockuser = blockuser;
    }

    public String getWishlist() {
        return wishlist;
    }

    public void setWishlist(String wishlist) {
        this.wishlist = wishlist;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
