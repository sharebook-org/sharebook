package org.sharebook.servlet;

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

    private LikeService likeService = new LikeServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/my.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        long userId = Long.parseLong(request.getParameter("userId"));
        int entityType = Integer.parseInt(request.getParameter("entityType"));
        long entityId = Long.parseLong(request.getParameter("entityId"));

        if (method.equals("like")) {
            like(userId, entityType, entityId, response);
        } else if (method.equals("cancelLike")) {
            cancelLike(userId, entityType, entityId, response);
        }
    }

    private void like(Long userId, int entityType, Long entityId,
                      HttpServletResponse response) {
        boolean result = likeService.isLiked(entityType, entityId, userId);
        if (result) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }

    private void cancelLike(Long userId, int entityType, Long entityId,
                            HttpServletResponse response) {
        boolean result = likeService.cancelLike(entityType, entityId, userId);
        if (result) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }

}
