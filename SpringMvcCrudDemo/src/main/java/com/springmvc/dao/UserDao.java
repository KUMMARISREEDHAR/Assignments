package com.springmvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.User;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Transactional(readOnly = true)
    public User get(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    @Transactional
    public void delete(int id) {
        User user = get(id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}

