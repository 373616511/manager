package com.asyf.manager.modules.sys.entity;

import com.asyf.manager.common.annotation.ExcelField;
import com.asyf.manager.common.entity.DataEntity;
import com.asyf.manager.common.entity.Page;

import java.util.Date;

public class User extends DataEntity<User> {

    private String loginName;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String status;


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @ExcelField(value = "姓名")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}