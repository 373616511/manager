package com.asyf.manager.modules.sys.service;


import com.asyf.manager.common.entity.Page;
import com.asyf.manager.modules.sys.entity.User;

public interface UserService {


    User selectByPrimaryKey(String s);

    Page<User> findAllList(Page<User> page, User user);

    int countUser(Page<User> page, User user);
}
