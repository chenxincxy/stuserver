package com.network.good.serviceImpl;

import com.network.StuserverServiceApplication;
import com.network.api.beans.User;
import com.network.good.service.IUserService;
import com.network.good.mapper.SLevelDao;
import com.network.good.mapper.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = StuserverServiceApplication.class)
class UserServiceImplTest {
    @Autowired
    UserDao userDao;
    @Autowired
    SLevelDao sLevelDao;

    @Autowired
    IUserService iUserService;
    @Test
    public void testList(){
        List<User> users=iUserService.selectUsersBypage(0,10);
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testById(){
        System.out.println(sLevelDao.selectAll());
    }
}