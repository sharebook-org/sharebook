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

@WebServlet(urlPatterns = {"/article"})
public class ArticleServlet extends HttpServlet {

    private final ArticleService articleService = new ArticleServiceImpl();

    //发表文章
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long userId = Long.valueOf(request.getParameter("userId"));
        String content = request.getParameter("article");
        String imgs = request.getParameter("images");

        Article article = new Article(userId, content, imgs);
        boolean result = articleService.publish(article);
        if (result) {
            ResponseUtils.write(response, ResponseUtils.success());
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
