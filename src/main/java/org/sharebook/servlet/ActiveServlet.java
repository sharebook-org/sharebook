package org.sharebook.servlet;

import org.sharebook.service.UserService;
import org.sharebook.service.impl.UserServiceImpl;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/active")
public class ActiveServlet extends HotsServlet {

    private final UserService userService;

    public ActiveServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        Boolean result = userService.checkCode(email, code);
        if (result) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }
}
