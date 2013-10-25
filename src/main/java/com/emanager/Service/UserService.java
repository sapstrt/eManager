package com.emanager.service;


import com.emanager.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vvarm1
 * Date: 10/15/13
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    boolean createNewUser(User user);
    User.USER_STATUS getUserStatus(int userId);
    User getUserByName(String userName);
    User getUserByEmail(String email);
    User getUserByPhone(String phNumber);
    List<String> getAllUserNames();
    boolean updateUser(User user);
    User getUserFromJson(String userInfo);
}
