package org.sangaizhi.security.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.sangaizhi.security.dao.AbstractDao;
import org.sangaizhi.security.dao.UserDao;
import org.sangaizhi.security.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author sangaizhi
 * @date 2017/7/10
 */
@Repository(value = "userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    public User findById(Long id) {
        return getByKey(id);
    }

    public User findByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }
}
