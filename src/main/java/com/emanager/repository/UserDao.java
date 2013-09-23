package com.emanager.repository;

import com.emanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
