package org.sharebook.servlet;

import org.sharebook.model.Article;
import org.sharebook.service.ArticleService;
import org.sharebook.service.UploadService;
import org.sharebook.service.impl.ArticleServiceImpl;
import org.sharebook.service.impl.UploadServiceImpl;
import org.sharebook.utils.FileUtil;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/article"})
public class ArticleServlet extends HttpServlet {

    private final ArticleService articleService = new ArticleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long userId = Long.valueOf(request.getParameter("userId"));
        String content = request.getParameter("article");
        String imgs = request.getParameter("images");
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(date);

        Article article = new Article();
        article.setUserId(userId);
        article.setCreateTime(date);
        article.setContent(content);
        article.setImages(imgs);
        boolean result = articleService.publish(article);
        if (result) {
            request.getSession().setAttribute("createTime",createTime);
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
