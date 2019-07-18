package org.sharebook.dao;

import java.util.List;

/**
 * 增删改查通用接口
 * @param <T> 操作的实体的类型
 * @param <ID> 实体主键的类型
 */
public interface CurdRepository<T, ID> {

    /**
     * 根据主键查找实体
     * @param id 主键
     */
    T findById(ID id);

    /**
     * 根据主键查找实体列表
     * @param id 主键
     */
    List<T> findAllById(ID id);

    /**
     * 保存或更新实体
     * @param t 实体
     */
    int save(T t);

    /**
     * 删除实体
     * @param id 主键
     */
    void delete(ID id);
}
