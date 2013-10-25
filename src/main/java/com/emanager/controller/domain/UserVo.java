package com.emanager.controller.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vvarm1
 * Date: 10/15/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserVo implements Serializable {
    String userName;
    String email;
    String phNumber;

    public UserVo() {
    }

    public UserVo(String userName, String email, String phNumber) {
        this.userName = userName;
        this.email = email;
        this.phNumber = phNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phNumber='" + phNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserVo)) return false;

        UserVo userVo = (UserVo) o;

        if (email != null ? !email.equals(userVo.email) : userVo.email != null) return false;
        if (phNumber != null ? !phNumber.equals(userVo.phNumber) : userVo.phNumber != null) return false;
        if (userName != null ? !userName.equals(userVo.userName) : userVo.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phNumber != null ? phNumber.hashCode() : 0);
        return result;
    }
}
