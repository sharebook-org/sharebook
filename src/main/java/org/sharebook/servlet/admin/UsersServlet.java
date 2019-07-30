package org.sharebook.servlet.admin;

import org.apache.commons.lang3.StringUtils;
import org.sharebook.model.User;
import org.sharebook.service.UserManageService;
import org.sharebook.service.UserService;
import org.sharebook.service.impl.UserManageServiceImpl;
import org.sharebook.service.impl.UserServiceImpl;
import org.sharebook.utils.ResponseUtils;
import org.sharebook.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    private UserManageService userManageService = new UserManageServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int page = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("size"));

        List<User> users = userManageService.getAllUsers(page, size);
        //将user不需要展示的字段过滤
        List<UserVO> userVOS = new ArrayList<>();
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            userVOS.add(new UserVO(user));
        }
        long count = userService.getCount();
        Map map = new HashMap();
        map.put("count", count);
        ResponseUtils.write(response, ResponseUtils.success(userVOS, map));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String hasRole = request.getParameter("role");
        String hasStatus = request.getParameter("status");
        if (!StringUtils.isBlank(hasRole)) {
            int role = Integer.parseInt(hasRole);
            userManageService.updateRole(id, role);
            ResponseUtils.write(response, ResponseUtils.success("角色修改完成"));
            return;
        }
        if (!StringUtils.isBlank(hasStatus)) {
            int status = Integer.parseInt(hasStatus);
            userManageService.updateStatus(id, status);
            ResponseUtils.write(response, ResponseUtils.success("状态修改完成"));
            return;
        }

        ResponseUtils.write(response, ResponseUtils.error("修改失败"));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hasId = request.getParameter("id");
        if (StringUtils.isBlank(hasId)) {
            ResponseUtils.write(response, ResponseUtils.error("该用户不存在"));
            return;
        }
        long id = Long.parseLong(hasId);
        int result = userManageService.deleteUser(id);
        if (result != 0) {
            ResponseUtils.write(response, ResponseUtils.success("用户已被删除"));
        } else {
            ResponseUtils.write(response, ResponseUtils.error("该用户不存在"));
        }
    }
}
