package org.sangaizhi.security.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author sangaizhi
 * @date 2017/7/10
 */
public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    public AbstractDao() {
        // 泛型化超类
        this.persistentClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public T getByKey(PK key){
        return (T) getSession().get(persistentClass, key);
    }

    public void persist(T entity){
        getSession().persist(entity);
    }

    private void delete(T entity){
        getSession().delete(entity);
    }

    public Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }



}
