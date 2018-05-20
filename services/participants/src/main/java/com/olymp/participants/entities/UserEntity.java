package com.olymp.participants.entities;

public class UserEntity {
    private Integer id;
    private String nickname;
    private String password;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String email;
    private String universityId;
    private Integer privateInfoId;
    private String testVariantId;

    // todo phone, passport, and others to new secret service
    //private String phone;


    public UserEntity(String nickname, String password, String firstName, String secondName, String thirdName, String email) {
        //}, String universityId, Integer privateInfoId, String testVariantId) {
        this.nickname = nickname;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.email = email;
//        this.universityId = universityId;
//        this.privateInfoId = privateInfoId;
//        this.testVariantId = testVariantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public Integer getPrivateInfoId() {
        return privateInfoId;
    }

    public void setPrivateInfoId(Integer privateInfoId) {
        this.privateInfoId = privateInfoId;
    }

    public String getTestVariantId() {
        return testVariantId;
    }

    public void setTestVariantId(String testVariantId) {
        this.testVariantId = testVariantId;
    }

    public UserEntity(Integer id, String nickname, String password, String email, String phone) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    public UserEntity(String nickname, String password, String email, String phone) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}

