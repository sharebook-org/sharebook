package org.sharebook.service;

public interface LikeService {

    boolean isLiked(int entityType, Long entityId, Long userId);

    /**
     * 取消点赞
     *
     * @param entityType
     * @param entityId
     * @param userId
     * @return
     */
    boolean cancelLike(int entityType, Long entityId, Long userId);

    /**
     * 获取点赞状态
     *
     * @param entityType
     * @param entityId
     * @param userId
     * @return
     */
    Integer getLikedStatus(int entityType, Long entityId, Long userId);
}
