package com.fine.dynamicsql.service;

import com.fine.dynamicsql.domian.User;
import com.fine.dynamicsql.vo.UserSearchVO;

import java.util.List;

/**
 * @author finefine
 * @date 2019-04-27 21:07
 */
public interface UserService {

    /**
     * 动态查询
     * @param user
     * @return
     */
    List<User> searchUser(UserSearchVO user);

    List<User> searchUserDsl(UserSearchVO user);
}
