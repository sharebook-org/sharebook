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

@WebServlet(urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long loginId = (Long) request.getSession().getAttribute("loginId");
        User user = userService.findUserById(loginId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int sex = Integer.parseInt(request.getParameter("sex"));
        String birth = request.getParameter("birth");
        String location = request.getParameter("location");
        //获取已登录的用户
        Long loginId = (Long) request.getSession().getAttribute("loginId");
        User user = userService.findUserById(loginId);
        user.setUsername(name);
        user.setSex(sex);
//        user.setBirth(date);
        user.setLocation(location);
        boolean result = userService.modify(user);
        if (result) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }


}
