package com.lbb.user.biz;

import com.lbb.user.model.User;
import org.junit.Test;
import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by bing on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class UserBizTest {
    @Autowired
    private UserBiz userBiz;

    @Test
    public void testUserSave(){
        User user = new User();
        user.setName("小卢");
        user.setBirthday(new Date());
        userBiz.saveUser(user);
    }

    @Test
    public void testUserAll(){
       List<User> list = userBiz.getAllUser();
       for(User user : list){
           System.out.println(user.getName()+"的生日是:"+user.getBirthday());
       }
    }
}
