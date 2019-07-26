package org.sharebook.service;

import org.sharebook.model.Like;

public interface LikeService {
    boolean isLiked(int entityType, long entityId, long userId);

    boolean likedCancle(int entityType, long entityId, long userId);
}
