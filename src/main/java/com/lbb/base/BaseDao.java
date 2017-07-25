package com.lbb.base;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by bing on 2017/7/21.
 */
public class BaseDao<T, PK extends Serializable> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;
    private String hql;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public BaseDao() {
        //通过反射获取泛型传过来的类的类对象
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.hql = "from " + this.entityClass.getName();
    }

    public void save(Object entity) {
        this.getSession().save(entity);
    }

    public void delete(Object entity) {
        this.getSession().delete(entity);
    }

    public void update(Object entity) {
        this.getSession().update(entity);
    }

    public T findById(Integer id) {
        T result = (T) this.getSession().get(entityClass,id);
        return result;
    }

    public List<T> getPageList(int startIndex, int pageSize) {
        List<T> list = this.getSession().createQuery(hql).setFirstResult(startIndex).setMaxResults(pageSize).list();
        return list;
    }

    public long getAmount() {
        String sql = "select count(*) from "+ this.entityClass.getName();
        long count =  (Long) this.getSession().createQuery(sql).uniqueResult() ;
        return count;
    }

    //查询所有
    public List<T> findAll(){
        return (List<T>) this.getSession().createQuery(hql).list();
    }
}
