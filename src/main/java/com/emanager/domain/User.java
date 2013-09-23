package com.emanager.domain;

/**
 * Created by pteltu on 9/20/13.
 */

public class User {
    private Integer userId;
    private String userName;
    private String emailId;
    private String phoneNumber;

    public User() {
    }

    public User(Integer userId, String phoneNumber, String emailId, String userName) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
