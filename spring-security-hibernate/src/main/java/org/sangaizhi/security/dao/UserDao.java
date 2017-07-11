package org.sangaizhi.security.dao;

import org.sangaizhi.security.model.User;

/**
 * created by sangaizhi on 2017/7/10.
 */
public interface UserDao {

    User findById(Long id);

    User findByUsername(String username);
}
