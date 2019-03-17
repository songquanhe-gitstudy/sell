package cn.com.soon.dao;

import java.util.List;

/**
 * @author song.qh
 * @date 2019/3/17
 */
public interface IBaseDao<T> {

    T save(T t);
    int update(T t);
    int delete(String id);
    T findById(String id);
    List<T> findAll();
}
