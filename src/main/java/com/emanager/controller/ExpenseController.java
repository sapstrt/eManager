package com.emanager.controller;

import com.emanager.service.ExpenseService;
import com.emanager.domain.Expense;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cambas on 9/23/13.
 */
@Controller
@RequestMapping(value = "/expense",method = RequestMethod.GET)
public class ExpenseController {
    @RequestMapping
    @ResponseBody
    private ResponseEntity<Expense> createExpense()
    {
       return new ResponseEntity<Expense>(new Expense(), HttpStatus.OK);
    }
    @RequestMapping(value="/createExpense", method=RequestMethod.GET)
    public String saveExpense(Expense expense) {

        return "redirect:http://www.google.co.in";
    }
}
