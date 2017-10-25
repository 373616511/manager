package com.asyf.manager.modules.sys.service.serviceImpl;

import com.asyf.manager.modules.sys.dao.MenuDao;
import com.asyf.manager.modules.sys.entity.Menu;
import com.asyf.manager.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> findAllList(Menu menu) {
        return menuDao.findAllList(menu);
    }
}
