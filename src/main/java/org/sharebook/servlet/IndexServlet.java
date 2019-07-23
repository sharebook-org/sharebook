package org.sharebook.servlet;

import org.apache.commons.collections4.CollectionUtils;
import org.sharebook.model.Hot;
import org.sharebook.service.HotService;
import org.sharebook.service.impl.HotServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    private HotService hotService = new HotServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hot> hots = hotService.getWeiboHots();
        if (CollectionUtils.isNotEmpty(hots)) {
            request.setAttribute("hots", hots);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
