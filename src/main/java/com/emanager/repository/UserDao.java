package com.emanager.repository;

import com.emanager.domain.Expense;
import com.emanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vvarm1
 * Date: 9/23/13
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface UserDao extends JpaRepository<User,Integer>{
    public List<User> findByUserName(String userName);
    public List<User> findByEmailId(String userName);
    public List<User> findByPhoneNumber(String userName);
}
