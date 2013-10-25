package com.emanager.controller;

import com.emanager.domain.User;
import com.emanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: vvarm1
 * Date: 10/22/13
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/app")
public class AppController {
    final static Logger LOGGER = LoggerFactory.getLogger(AppController.class);
    @Autowired
    UserService userService;
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<String> registerNewUser(HttpServletRequest request) {
        LOGGER.debug("In the App Controller");
        String userEmail= (String) request.getSession().getAttribute("user");
        LOGGER.debug("User from session :" + userEmail);
        if (userEmail!=null) {
            User user = userService.getUserByEmail(userEmail);
            if (user==null) {
                user = new User(userEmail);
                userService.createNewUser(user);
            }
        }
        return new ResponseEntity<String>("Done dona Done!", HttpStatus.OK);
    }
}
