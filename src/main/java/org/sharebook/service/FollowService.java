package org.sharebook.service;

import org.sharebook.model.Follow;

import java.util.List;

public interface FollowService {
    /**
     * 关注
     * @param follow
     * @return
     */
    boolean follow(Follow follow);

    /**
     * 显示一个user_id的Follow信息
     * @return
     */
    Follow showFollow(Long userId);

    /**
     * 通过userId显示关注的人的list
     * @param userId
     * @return
     */
    List<Follow> showFollows(Long userId);

    List<Long> showFollowUserId(Long id);

    /**
     * 显示关注的人数
     * @param userId
     * @return
     */
    Long showFollowNum(Long userId);

    /**
     * 显示粉丝数
     * @param followUserId
     * @return
     */
    Long showUserNum(Long followUserId);

    //取关
    boolean deleteFollow(Long userId,Long followUserId);
}
