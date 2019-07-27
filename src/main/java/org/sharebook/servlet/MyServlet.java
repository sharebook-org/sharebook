package org.sharebook.servlet;

import org.sharebook.service.ArticleService;
import org.sharebook.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {

    private final ArticleService articleService;

    public MyServlet() {
        this.articleService = new ArticleServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int commentNum = 0;
        int likeNum = 1;
        request.setAttribute("commentNum", commentNum);
        request.setAttribute("likeNum", likeNum);
        request.setAttribute("createTime", new Date());
        request.getRequestDispatcher("/my.jsp").forward(request,response);
    }
}
