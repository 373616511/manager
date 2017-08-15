package com.asyf.manager.modules.sys.service.serviceImpl;

import com.asyf.manager.modules.sys.dao.UserDao;
import com.asyf.manager.modules.sys.entity.User;
import com.asyf.manager.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User selectByPrimaryKey(String id) {
        return userDao.selectByPrimaryKey(id);
    }
}
