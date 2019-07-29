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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("user");
        User user = userService.findUserById(loginUser.getId());
        request.setAttribute("user", user);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int sex = Integer.parseInt(request.getParameter("sex"));
        String birth = request.getParameter("birth");
        String location = request.getParameter("location");
        //获取已登录的用户
        User user = (User) request.getSession().getAttribute("user");
        user.setUsername(name);
        user.setSex(sex);
        user.setPhone(phone);
        user.setEmail(email);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirth(dateFormat.parse(birth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setLocation(location);
        boolean result = userService.modify(user);
        if (result) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }


}
