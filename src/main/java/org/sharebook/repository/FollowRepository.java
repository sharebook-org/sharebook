package org.sharebook.repository;

import org.sharebook.model.Follow;

import java.util.List;

public interface FollowRepository extends CurdRepository<Follow,Long>{
    /**
     * 通过user_id找到其关注的人
     * @param userId
     * @return
     */
    List<Follow> findFollowByUserId(Long userId);

    /**
     * 通过follow_user_id查到该follow_user_id的粉丝
     * @param followUserId
     * @return
     */
    List<Follow> findUserByFollow(Long followUserId);

    /**
     * 通过user_id和follow_user_id查询是否存在该条语句
     * @param userId
     * @param followUserId
     * @return
     */
    Follow find(Long userId,Long followUserId);

    /**
     * 通过user_id查询其关注的人数
     * @param userId
     * @return
     */
    Long findNumByUserId(Long userId);

    /**
     * 通过follow_user_id查询该follow_user_id的粉丝数
     * @param followUserId
     * @return
     */
    Long findNumByFollowUserId(Long followUserId);

    /**
     * 找出follow表的所有信息
     * @return
     */
    List<Follow> findAll();
}
