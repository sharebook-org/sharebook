package org.sharebook.service;

import org.sharebook.model.Follow;

import java.util.List;

public interface FollowService {

    /**
     * 关注
     *
     * @param follow
     * @return
     */
    boolean follow(Follow follow);

    /**
     * 显示一个user_id的Follow信息
     *
     * @return
     */
    Follow showFollow(Long userId);

    /**
     * 通过userId显示关注的人的list
     *
     * @param userId
     * @return
     */
    List<Follow> showFollows(Long userId);

    List<Long> showFollowUserId(Long id);

    /**
     * 显示关注的人数
     *
     * @param userId
     * @return
     */
    Long getFollowCount(Long userId);

    /**
     * 显示粉丝数
     *
     * @param followUserId
     * @return
     */
    Long getFansCount(Long followUserId);

    /**
     * 取消关注
     *
     * @param userId
     * @param followUserId
     * @return
     */
    boolean cancelFollow(Long userId, Long followUserId);
}
