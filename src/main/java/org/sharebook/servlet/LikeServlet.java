package org.sharebook.servlet;

import org.sharebook.model.Like;
import org.sharebook.model.User;
import org.sharebook.repository.impl.LikeResposityImpl;
import org.sharebook.service.LikeService;
import org.sharebook.service.impl.LikeServiceImpl;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/like")
public class LikeServlet extends HttpServlet {

    private LikeService likeService=new LikeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //User user=request.getSession().getAttribute("user")
        long userId=Long.parseLong(request.getParameter("userId"));
        int entityType=Integer.parseInt(request.getParameter("entityType"));
        long entityId= Long.parseLong(request.getParameter("entityId"));
//        int liked=Integer.parseInt(request.getParameter("liked"));
        boolean result=likeService.isLiked(entityType,entityId,userId);
        if (result){
            ResponseUtils.write(response,ResponseUtils.success());
        }else {
            ResponseUtils.write(response,ResponseUtils.error());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/my.jsp").forward(request,response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //User user=request.getSession().getAttribute("user")
        long userId=Long.parseLong(request.getParameter("userId"));
        int entityType=Integer.parseInt(request.getParameter("entityType"));
        long entityId= Long.parseLong(request.getParameter("entityId"));
//        int liked=Integer.parseInt(request.getParameter("liked"));
        boolean result=likeService.likedCancle(entityType,entityId,userId);
        if (result){
            ResponseUtils.write(response,ResponseUtils.success());
        }else {
            ResponseUtils.write(response,ResponseUtils.error());
        }
    }
}
