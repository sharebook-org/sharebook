package org.sharebook.servlet;

import org.sharebook.model.Comment;
import org.sharebook.service.CommentService;
import org.sharebook.service.impl.CommentServiceImpl;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/comment")
public class CommentServlet extends HttpServlet {
    private final CommentService commentService=new CommentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId= Long.valueOf(request.getParameter("userId"));
        String content=request.getParameter("content");
        int entityType= Integer.parseInt(request.getParameter("entityType"));
        Long entityId= Long.valueOf(request.getParameter("entityId"));

        Comment comment=new Comment();
        comment.setUserId(userId);
        comment.setContent(content);
        comment.setEntityType(entityType);
        comment.setEntityId(entityId);
        boolean result=commentService.comments(comment);
        if (result){
            ResponseUtils.write(response, ResponseUtils.success());
        }
        else {
            ResponseUtils.write(response, ResponseUtils.error());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
