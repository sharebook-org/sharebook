package org.sharebook.servlet;

import org.sharebook.model.Article;
import org.sharebook.service.ArticleService;
import org.sharebook.service.impl.ArticleServiceImpl;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {

    private final ArticleService articleService = new ArticleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long userId = Long.valueOf(request.getParameter("userId"));
        String content = request.getParameter("article");
        Article article = new Article();
        article.setUserId(userId);
        article.setContent(content);
        boolean result = articleService.publish(article);
        if (result) {
            request.getSession().setAttribute("content", content);
            //request.getRequestDispatcher("/attention").forward(request,response);
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
