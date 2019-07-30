package org.sharebook.service.impl;

import org.sharebook.model.Follow;
import org.sharebook.repository.FollowRepository;
import org.sharebook.repository.impl.FollowRepositoryImpl;
import org.sharebook.service.FollowService;

import java.util.List;

public class FollowServiceImpl implements FollowService {
    private final FollowRepository followRepository;
    public FollowServiceImpl(){
        this.followRepository=new FollowRepositoryImpl();
    }
    @Override
    public boolean follow(Follow follow) {
        if (follow!=null){
            //如果一个follow_user_id已经被该用户关注，则该id不能被该user_id再次关注
            Follow follow1=followRepository.find(follow.getUserId(),follow.getFollowUserId());
            if (follow1==null){
                int result=followRepository.save(follow);
                return result > 0;
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public Follow showFollow(Long userId) {
        Follow follow=null;
        if (userId!=null){
            follow = followRepository.findById(userId);
            return follow;
        }
        return follow;
    }

    @Override
    public List<Follow> showFollows(Long userId) {
        List<Follow> follows=null;
        if (userId!=null){
            follows = followRepository.findFollowByUserId(userId);
            return follows;
        }
        return follows;
    }

    @Override
    public List<Long> showFollowUserId(Long id) {
        List<Long> ids=null;
        ids = followRepository.findAll(id);
        return ids;
    }

    @Override
    public Long getFollowCount(Long userId) {
        Long result=0L;
        if (userId!=null){
            result=followRepository.findNumByUserId(userId);
            return result;
        }
        return result;
    }

    @Override
    public Long getFansCount(Long followUserId) {
        Long result=0L;
        if (followUserId!=null){
            result=followRepository.findNumByFollowUserId(followUserId);
            return result;
        }
        return result;
    }

    @Override
    public boolean cancelFollow(Long userId, Long followUserId) {
            Follow follow1=followRepository.find(userId,followUserId);
            //如果查到则取消关注
            if (follow1!=null){
                followRepository.delete(userId,followUserId);
                return true;
            }
            return false;
    }


}
