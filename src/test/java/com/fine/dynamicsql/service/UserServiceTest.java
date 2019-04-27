package com.fine.dynamicsql.service;

import com.fine.dynamicsql.vo.UserSearchVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserServiceTest
 *
 * @author finefine
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void search() {
        UserSearchVO userSearchVO = new UserSearchVO();
        userSearchVO.setAge(10);
//        userSearchVO.setUsername("张三");

        Assert.assertEquals(1,userService.searchUser(userSearchVO).size());
    }

    @Test
    public void searchUserDsl() {
        UserSearchVO userSearchVO = new UserSearchVO();
        userSearchVO.setAge(10);
        userSearchVO.setUsername("张三");

        Assert.assertEquals(0,userService.searchUser(userSearchVO).size());
    }
}