package org.sharebook.repository;

/**
 * 增删改查通用接口
 * @param <T> 操作的实体的类型
 * @param <ID> 实体主键的类型
 */
public interface CurdRepository<T, ID> {

    /**
     * 根据主键查找实体
     * @param id 主键
     * @return 查找的实体
     */
    T findById(ID id);

    /**
     * 保存实体
     * @param t 实体
     * @return 影响的行数
     */
    int save(T t);

    /**
     * 更新实体
     *
     * @param t 实体
     * @return 影响的行数
     */
    int update(T t);

    /**
     * 删除实体
     * @param id 主键
     *
     */
    int delete(ID id);
}
