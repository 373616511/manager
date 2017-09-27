package com.asyf.manager.modules.sys.dao;

import com.asyf.manager.common.annotation.MyBatisDao;
import com.asyf.manager.modules.sys.entity.User;

import java.util.List;

@MyBatisDao
public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findUserList(User user);

    int countUser(User user);

    void test(String name);

    String get();
}