package com.emanager.controller;

import com.emanager.domain.User;
import com.emanager.service.UserService;
import com.emanager.service.oauth.GoogleAuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * User: vvarma
 * Date: 9/19/13
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    GoogleAuthHelper authHelper;

    @RequestMapping(method = RequestMethod.GET)
    String loginToUserService(@RequestParam(value = "state", required = false) String state,
                              @RequestParam(value = "code", required = false) String code, HttpSession session) {
        if (code == null)
            return "redirect:" + authHelper.buildLoginUrl();
        else {
            try {
                String userInfo = authHelper.getUserInfoJson(code);
                User user = userService.getUserFromJson(userInfo);
                session.setAttribute("user", user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/user/welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    String welcomeToUserService(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null)
            return "welcome " + user.getUserName();
        return "oh oo!";
    }
}
