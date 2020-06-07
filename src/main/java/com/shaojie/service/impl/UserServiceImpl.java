package com.shaojie.service.impl;


import com.shaojie.dao.UserDao;
import com.shaojie.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
