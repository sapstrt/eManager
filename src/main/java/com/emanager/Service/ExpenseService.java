package com.emanager.Service;

import com.emanager.Dao.ExpenseDao;
import com.emanager.domain.Expense;

/**
 * Created by cambas on 9/23/13.
 */
public class ExpenseService {
    ExpenseDao expenseDao;
    public void createNewExpense(Expense expense)
    {
       expenseDao.createExpense(expense);
    }
}
