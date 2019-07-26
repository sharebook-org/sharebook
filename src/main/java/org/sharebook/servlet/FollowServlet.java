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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/follow")
public class FollowServlet extends HttpServlet {
    private final FollowService followService;
    public FollowServlet(){
        this.followService=new FollowServiceImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId= Long.valueOf(request.getParameter("userId"));
        Long followUserId= Long.valueOf(request.getParameter("followUserId"));
        /*Follow follow=new Follow();
        follow.setUserId(userId);
        follow.setFollowUserId(followUserId);
        boolean res=followService.follow(follow);*/
        boolean res=followService.deleteFollow(userId,followUserId);
        if (res){
            ResponseUtils.write(response, ResponseUtils.success());
        }
        else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //User user=(User) request.getSession().getAttribute("user");
        //Long userId=user.getId();
        Long userId= Long.valueOf(request.getParameter("userId"));

        //得到关注的人数
        Long res1=followService.showFollowNum(userId);
        //得到粉丝数
        Long res2=followService.showUserNum(userId);
        Map<String, Long> map = new HashMap<>();
        map.put("followCount", res1);
        map.put("fansCount", res2);

        ResponseUtils.write(response, ResponseUtils.success(map));

    }
}
