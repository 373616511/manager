package com.asyf.manager.modules.sys.service;

import com.asyf.manager.modules.sys.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface MenuService {
    List<Menu> findAllList(Menu menu);
}
