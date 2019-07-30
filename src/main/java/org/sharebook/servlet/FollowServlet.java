package org.sharebook.servlet;

import org.sharebook.model.Follow;
import org.sharebook.model.User;
import org.sharebook.service.FollowService;
import org.sharebook.service.impl.FollowServiceImpl;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/follow")
public class FollowServlet extends HttpServlet {

    private final FollowService followService;

    public FollowServlet() {
        this.followService = new FollowServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        Long userId = Long.valueOf(request.getParameter("userId"));
        Long articleUserId = Long.valueOf(request.getParameter("articleUserId"));

        Follow follow = new Follow(userId, articleUserId);
        if (method.equals("follow")) {
            follow(follow, response);
        } else if (method.equals("cancelFollow")) {
            followCancle(userId, articleUserId, response);
        }
    }

    private void follow(Follow follow, HttpServletResponse response) {
        boolean res = followService.follow(follow);
        if (res) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }

    private void followCancle(Long userId, Long articleUserId, HttpServletResponse response) {
        boolean res = followService.cancelFollow(userId, articleUserId);
        if (res) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("user");
        Long userId = loginUser.getId();

        //得到关注的人数
        Long followCount = followService.getFollowCount(userId);
        //得到粉丝数
        Long fansCount = followService.getFansCount(userId);
        Map<String, Long> map = new HashMap<>();
        map.put("followCount", followCount);
        map.put("fansCount", fansCount);

        ResponseUtils.write(response, ResponseUtils.success(map));
    }

}
