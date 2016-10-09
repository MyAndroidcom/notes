package com.xhp.scm.service;

import com.xhp.scm.entity.Page;

/**
 * Created by xhp on 2016/9/30.
 */
public interface BaseService<T> {
    //添加单个对象
    public Integer insert(T entity) throws Exception;

    //修改单个对象
    public int update(T entity) throws Exception;

    //通过多条件分页查询
    Page<T> selectPageUseDyc(Page<T> page);

    //删除单个对象
    public int delete(T entity) throws Exception;

    //通过主键批量删除
    public int deleteList(String [] pks) throws Exception;

    //查询单个对象
    public T select(T entity) throws Exception;

    //通过关键字分页查询
    public Page<T> selectPage(Page<T> page);

}
