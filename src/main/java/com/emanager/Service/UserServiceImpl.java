package com.emanager.service;

import com.emanager.domain.User;
import com.emanager.repository.UserDao;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vvarm1
 * Date: 10/21/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public boolean createNewUser(User user) {
        if (user==null)
            return false;
        user.setStatus(User.USER_STATUS.NEW);
        user=userDao.save(user);
        if (user.getUserId()==null)
            return false;
        return true;
    }

    @Override
    public User.USER_STATUS getUserStatus(int userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUserByName(String userName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUserByEmail(String email) {
        User user=null;
        List<User> users=userDao.findByEmailId(email);
        if (users.size()>0)
            if (users.size()>1)
                throw new IllegalStateException("multiple users with same email not allowed");
            else
                user=users.get(0);
        return user;
    }

    @Override
    public User getUserByPhone(String phNumber) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> getAllUserNames() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean updateUser(User user) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUserFromJson(String userInfo) {
        User user=null;
        Map<String,String> userMap;
        ObjectMapper mapper=new ObjectMapper();
        try {
            userMap=mapper.readValue(userInfo,new TypeReference<HashMap<String,String>>(){});
            String email=userMap.get("email");
            user=getUserByEmail(email);
            if (user==null){
                user=new User();
                user.setEmailId(email);
                user.setUserName(userMap.get("name"));
                if (createNewUser(user))
                    user=getUserByEmail(user.getEmailId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
