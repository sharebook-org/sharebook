package org.sharebook.repository;

import org.sharebook.model.Like;

public interface LikeResposity extends CurdRepository<Like,Long>{
    Long getLikeCount();
    Like findByAllId(int entityType,long entityId,long userId);
    Integer findStatus(int entityType,long entityId,long userId);
}
