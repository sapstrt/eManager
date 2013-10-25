package com.emanager.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pteltu on 9/20/13.
 */
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "userId"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId = 0;

    @Column(name = "name")
    private String userName;

    @Column(name = "email")
    private String emailId;

    private String phoneNumber;

    private USER_STATUS status;

    @OneToMany
    private Set<Expense> expenses;

    public enum USER_STATUS {
        ACTIVE,NEW,INACTIVE;
    }

    public User() {
    }

    public User(String emailId) {
        this.emailId = emailId;
    }

    public User(String phoneNumber, String emailId, String userName) {
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.userName = userName;
        expenses = new HashSet<Expense>();
        status=USER_STATUS.NEW;
    }

    public USER_STATUS getStatus() {
        return status;
    }

    public void setStatus(USER_STATUS status) {
        this.status = status;
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

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!emailId.equals(user.emailId)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + emailId.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
