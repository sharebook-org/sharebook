package org.sharebook.servlet;

import org.sharebook.model.User;
import org.sharebook.service.impl.UserServiceImpl;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/attention")
public class AttentionServlet extends HttpServlet {
    public final UserServiceImpl userService = new UserServiceImpl();

    //检测用户是否登录，从而控制关注页面的展示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = (Long) request.getSession().getAttribute("loginId");
        User user = userService.findUserById(id);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/attention.jsp").forward(request, response);
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index").forward(request, response);
    }

}
