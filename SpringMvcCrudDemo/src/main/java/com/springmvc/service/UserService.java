package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public User get(int id) {
        return userDao.get(id);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return userDao.list();
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}

