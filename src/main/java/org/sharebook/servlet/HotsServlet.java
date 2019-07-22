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

@WebServlet(urlPatterns = "/hots")
public class HotsServlet extends HttpServlet {

    private final HotService hotService = new HotServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hot> weiboHots = hotService.getWeiboHots();
        List<Hot> zhihuHots = hotService.getZhihuHots();
        List<Hot> hupuHots = hotService.getHupuHots();
        List<Hot> tianyaHots = hotService.getTianyaHots();
        if (CollectionUtils.isNotEmpty(weiboHots)) {
            request.setAttribute("weiboHots", weiboHots);
        }
        if (CollectionUtils.isNotEmpty(zhihuHots)) {
            request.setAttribute("zhihuHots", zhihuHots);
        }
        if (CollectionUtils.isNotEmpty(weiboHots)) {
            request.setAttribute("hupuHots", hupuHots);
        }
        if (CollectionUtils.isNotEmpty(weiboHots)) {
            request.setAttribute("tianyaHots", tianyaHots);
        }
        request.getRequestDispatcher("/hots.jsp").forward(request, response);
    }
}
