package org.sangaizhi.security.service.impl;

import org.sangaizhi.security.dao.UserDao;
import org.sangaizhi.security.model.User;
import org.sangaizhi.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sangaizhi
 * @date 2017/7/10
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public User findById(Long id) {
        return userDao.findById(id);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
