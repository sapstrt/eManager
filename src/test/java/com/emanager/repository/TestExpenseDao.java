package com.emanager.repository;

import com.emanager.domain.Expense;
import com.emanager.domain.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vvarm1
 * Date: 9/23/13
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/testContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TestExpenseDao {
    @Autowired
    ExpenseDao expenseDao;

    @Test
    public void shouldAddNewExpense(){
        User user=new User("9902539978","vin1990@gmail.com","varma");
        Expense expense =new Expense("trial",new Date(),200.0,"Benaras","New",user);
        user.addExpense(expense);
        expenseDao.save(expense);

    }
}
