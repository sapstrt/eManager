package com.emanager.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pteltu on 9/20/13.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId=0;
    private String userName;
    private String emailId;
    private String phoneNumber;
    @OneToMany
    private Set<Expense> expenses;

    public User() {
    }

    public User(String phoneNumber, String emailId, String userName) {
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.userName = userName;
        expenses=new HashSet<Expense>();
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

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!emailId.equals(user.emailId)) return false;
        if (!phoneNumber.equals(user.phoneNumber)) return false;
        if (!userId.equals(user.userId)) return false;
        if (!userName.equals(user.userName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + emailId.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }
}
