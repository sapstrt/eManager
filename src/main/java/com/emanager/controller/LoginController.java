package com.emanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: vvarma
 * Date: 9/19/13
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/login",method = RequestMethod.GET)
public class LoginController {


    @RequestMapping
    public
    @ResponseBody String printHello(){

        return "Hello";
    }
}
