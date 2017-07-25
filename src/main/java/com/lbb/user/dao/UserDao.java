package com.lbb.user.dao;
import com.lbb.user.model.User;
import com.lbb.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bing on 2017/7/20.
 */
@Repository
public class UserDao extends BaseDao<User,Long> {

    public void saveUser(User user){
        this.save(user);
    }

    public List<User> getAllUser(){
        return this.findAll();
    }
}


