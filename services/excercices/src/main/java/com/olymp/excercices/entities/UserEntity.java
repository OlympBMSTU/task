package com.olymp.excercices.entities;

public class UserEntity {
    private Integer id;
    private String role;
    private String nickname;
    private String password;
    private String email;
    private String phone;

    public UserEntity(Integer id, String role, String nickname, String password, String email, String phone) {
        this.id = id;
        this.role = role;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public UserEntity(String role, String nickname, String password, String email, String phone) {
        if (role == null) {
            this.role = "user";
        }
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
