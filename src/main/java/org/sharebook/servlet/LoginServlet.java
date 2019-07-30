package org.sharebook.servlet;

import org.sharebook.constant.status.ActiveStatus;
import org.sharebook.constant.status.UserStatus;
import org.sharebook.model.Active;
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

/**
 * 登录相关Servlet
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService;

    public LoginServlet() {
        this.userService = new UserServiceImpl();
    }

    //跳转页面
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    //登录
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");
        String password = request.getParameter("password");

        User loginUser = userService.login(account, password);
        Active active = userService.findByAccount(account);
        if (loginUser == null) {
            ResponseUtils.write(response, ResponseUtils.error("您尚未注册!"));
            return;
        } else if (active!=null){
            boolean canUse = accountStatus(active.getStatus(), response);
            //用户状态正常，成功登录
            if (canUse) {
                request.getSession().setAttribute("user", new User(loginUser));
                ResponseUtils.write(response, ResponseUtils.success());
            }
        } else {
            boolean flag = processStatus(loginUser.getStatus(), response);
            //用户状态正常，成功登录
            if (flag) {
                request.getSession().setAttribute("user", new User(loginUser));
                ResponseUtils.write(response, ResponseUtils.success());
            }
        }
    }

    //注销
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        ResponseUtils.write(response, ResponseUtils.success());
    }

    /**
     * 校验用户状态
     *
     * @param status   用户状态
     * @param response
     * @return 用户状态正常返回true，否则返回false。
     */
    private boolean processStatus(int status, HttpServletResponse response) {
        boolean flag = false;
        switch (status) {
            case UserStatus.BANNED:
                ResponseUtils.write(response, ResponseUtils.error("您已经被封号了!"));
                break;
            case UserStatus.DELETED:
                ResponseUtils.write(response, ResponseUtils.error("您已经被注销了!"));
                break;
            case UserStatus.NORMAL:
                flag = true;
                break;
        }
        return flag;
    }


    /**
     * 校验账号状态
     * @param status
     * @param response
     * @return
     */
    private boolean accountStatus(int status,HttpServletResponse response){
        boolean canUse=false;
        switch (status){
            case ActiveStatus.ACTIVATED:
                canUse=true;
                break;
            case ActiveStatus.INACTIVATED:
                ResponseUtils.write(response, ResponseUtils.error("你的账号尚未激活！"));
                break;
        }
        return canUse;
    }
}
