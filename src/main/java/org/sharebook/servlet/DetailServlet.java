package org.sharebook.servlet;

import org.sharebook.constant.EntityType;
import org.sharebook.model.Comment;
import org.sharebook.model.User;
import org.sharebook.service.CommentService;
import org.sharebook.service.UserService;
import org.sharebook.service.impl.CommentServiceImpl;
import org.sharebook.service.impl.UserServiceImpl;
import org.sharebook.vo.CommentVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/detail")
public class DetailServlet extends HttpServlet {

    private final CommentService commentService = new CommentServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<Comment> commentList = commentService.getCommentList(EntityType.ARTICLE, id);
        List<CommentVO> commentVOList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentVO commentVO = null;
            User user = userService.findUserById(comment.getUserId());
            if (user != null) {
                commentVO = new CommentVO(user.getId(), user.getUsername(),
                        user.getAvatar(), comment.getId(), comment.getContent());
                String date = df.format(comment.getCreateTime());
                commentVO.setCreateTime(date);
            }
            commentVOList.add(commentVO);
        }
        request.setAttribute("commentVOList", commentVOList);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }
}
