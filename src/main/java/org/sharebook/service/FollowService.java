package org.sharebook.service;

import org.sharebook.model.Follow;

public interface FollowService {
    /**
     * 关注
     * @param follow
     * @return
     */
    boolean follow(Follow follow);

    /**
     * 显示Follow信息
     * @return
     */
    boolean showFollow(Follow follow);

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
