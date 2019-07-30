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
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private final ArticleService articleService;

    public SearchServlet(){
        this.articleService=new ArticleServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord=request.getParameter("keyWord");
        List<Article> articles = articleService.getArticles(keyWord);
        if (articles.size()>0){
            String message="共查出"+articles.size()+"篇文章";
            ResponseUtils.write(response, ResponseUtils.success(message));
        }
        else {
            ResponseUtils.write(response, ResponseUtils.error("不存在该内容的文章"));
        }
    }
}
