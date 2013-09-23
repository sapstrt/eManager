package com.emanager.domain;

import java.util.Date;

/**
 * Created by cambas on 9/23/13.
 */
public class Expense {
    private Integer expenseId;
    private String expenseName;
    private Date date;
    private Double amount;
    private String location;
    private String  status;

    public Expense(Integer expenseId, String status, String location, Double amount, Date date, String expenseName) {
        this.expenseId = expenseId;
        this.status = status;
        this.location = location;
        this.amount = amount;
        this.date = date;
        this.expenseName = expenseName;
    }

    public Expense() {
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }



    public String getStatus() {
        return status;

    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
