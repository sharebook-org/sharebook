package org.sharebook.servlet;

import org.sharebook.model.User;
import org.sharebook.service.UserService;
import org.sharebook.service.impl.UserServiceImpl;
import org.sharebook.utils.MD5Utils;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/forget")
public class ForgetServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        User user = userService.findUserByName(userName);
        if (user != null) {
            String salt = user.getSalt();
            String encryptPassword = MD5Utils.md5(password, salt);
            boolean res = user.getPassword().equals(encryptPassword);
            if (res) {
                String saltt = MD5Utils.getSalt();
                String ePassword = MD5Utils.md5(newPassword, saltt);
                user.setPassword(ePassword);
                user.setSalt(saltt);
                boolean result = userService.modifyPassword(user);
                if (result) {
                    ResponseUtils.write(response, ResponseUtils.success());
                } else {
                    ResponseUtils.write(response, ResponseUtils.error());
                }
            } else {
                //密码有误

            }
        } else {
            //没有找到该已注册的用户
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/forget.jsp").forward(request, response);
    }
}
