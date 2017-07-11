package org.sangaizhi.security.service;

import org.sangaizhi.security.model.User;

/**
 * 用戶接口
 * @author sangaizhi
 * @date 2017/7/10
 */
public interface UserService {

    User findById(Long id);
    User findByUsername(String username);
}

