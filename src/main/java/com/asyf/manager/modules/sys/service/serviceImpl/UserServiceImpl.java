package com.asyf.manager.modules.sys.service.serviceImpl;

import com.asyf.manager.common.entity.Page;
import com.asyf.manager.modules.sys.dao.UserDao;
import com.asyf.manager.modules.sys.entity.User;
import com.asyf.manager.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User selectByPrimaryKey(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    public Page<User> findAllList(Page<User> page, User user) {
        user.setPage(page);
        page.setRows(userDao.findUserList(user));
        return page;
    }

    public int countUser(Page<User> page, User user) {
        user.setPage(page);
        return userDao.countUser(user);
    }

    @Transactional(readOnly = false)
    public void test(long l) {
        System.err.println(l);
        for (int i = 0; i < 1000; i++) {
            String name = Thread.currentThread().getName();
            System.err.println(name + "===" + i);
        }
        userDao.test();
    }
}
