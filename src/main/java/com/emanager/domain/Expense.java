package com.emanager.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cambas on 9/23/13.
 */
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer expenseId=0;
    private String expenseName;
    private Date date;
    private Double amount;
    private String location;
    private String  status;
    @ManyToOne
    private User createdBy;

    public Expense( String expenseName, Date date, Double amount, String location, String status, User createdBy) {
        this.expenseName = expenseName;
        this.date = date;
        this.amount = amount;
        this.location = location;
        this.status = status;
        this.createdBy = createdBy;
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;

        Expense expense = (Expense) o;

        if (!amount.equals(expense.amount)) return false;
        if (!createdBy.equals(expense.createdBy)) return false;
        if (!date.equals(expense.date)) return false;
        if (!expenseId.equals(expense.expenseId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expenseId.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + createdBy.hashCode();
        return result;
    }
}
