package com.network.user;


import com.network.api.beans.TUser;
import com.network.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StuserverServiceApplication.class})
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    public void login() {
        TUser user = userService.login("test", "123");

        if (null != user) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

}
