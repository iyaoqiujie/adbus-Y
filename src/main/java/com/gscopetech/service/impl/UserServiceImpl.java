package com.gscopetech.service.impl;

import com.gscopetech.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gscopetech.dao.UserDao;
import com.gscopetech.service.UserService;

import java.util.List;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/15
 */
@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void update(String password, String username) {
        userDao.update(password, username);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
