package com.asyf.manager.modules.sys.dao;

import com.asyf.manager.common.annotation.MyBatisDao;
import com.asyf.manager.modules.sys.entity.Menu;

import java.util.List;

@MyBatisDao
public interface MenuDao {
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> findAllList(Menu menu);
}