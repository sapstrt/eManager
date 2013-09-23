package com.emanager.repository;

import com.emanager.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cambas on 9/23/13.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface ExpenseDao extends JpaRepository<Expense,Integer> {

    public List<Expense> findByExpenseName(String expenseName);

}
