package com.asyf.manager.modules.sys.dao;

import com.asyf.manager.common.annotation.MyBatisDao;
import com.asyf.manager.modules.sys.entity.User;

@MyBatisDao
public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}