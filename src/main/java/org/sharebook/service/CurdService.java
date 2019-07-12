package org.sharebook.service;

/**
 * 增删改查通用接口
 * @param <T> 操作的实体的类型
 * @param <ID> 实体主键的类型
 */
public interface CurdService<T, ID> {

    void findById(ID id);
    void findAll();
    void findAllById(ID id);
    void save(T t);
    void delete(ID id);
}
