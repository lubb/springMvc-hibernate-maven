package com.lbb.user.biz;

import com.lbb.user.dao.UserDao;
import com.lbb.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by bing on 2017/7/20.
 */
@Service
public class UserBiz {

    @Autowired
    private UserDao userDao;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void saveUser(User user){
        userDao.saveUser(user);
    }

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
}
