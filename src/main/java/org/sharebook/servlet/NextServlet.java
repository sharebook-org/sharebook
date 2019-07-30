package org.sharebook.servlet;

import org.sharebook.service.UserService;
import org.sharebook.service.impl.UserServiceImpl;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/next")
public class NextServlet extends HttpServlet {
    private final UserService userService;

    public NextServlet() {
        this.userService = new UserServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/next.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        boolean result=userService.getCode(email);
        if (result){
            ResponseUtils.write(response, ResponseUtils.success());
        }
        else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }
}
