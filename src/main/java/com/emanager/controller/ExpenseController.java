package com.emanager.controller;

import com.emanager.service.ExpenseService;
import com.emanager.domain.Expense;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cambas on 9/23/13.
 */
@Controller
@RequestMapping(value = "/createExpense",method = RequestMethod.GET)
public class ExpenseController {
    @RequestMapping
    @ResponseBody
    private void createExpense(@RequestParam("expense") Expense expense)
    {
        ExpenseService expenseService=new ExpenseService();
        expenseService.createNewExpense(expense);
    }
}
