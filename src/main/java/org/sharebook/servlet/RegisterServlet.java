package org.sharebook.servlet;

import org.sharebook.model.User;
import org.sharebook.service.UserService;
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
import java.util.Date;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService;

    public RegisterServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    //注册
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String location = request.getParameter("location");
        String birth = request.getParameter("birth");
        int sex = Integer.parseInt(request.getParameter("sex"));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = new User(
                username, password, email, phone,
                sex, birthday, location
        );

        boolean result = userService.register(user);
        if (result) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }
}
