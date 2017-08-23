package com.asyf.manager.modules.sys.service;


import com.asyf.manager.modules.sys.entity.User;

import java.util.List;

public interface UserService {


    User selectByPrimaryKey(String s);

    List<User> findAllList(User user);

    int countUser(User user);
}
