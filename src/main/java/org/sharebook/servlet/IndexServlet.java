package org.sharebook.servlet;

import org.sharebook.model.Article;
import org.sharebook.model.User;
import org.sharebook.service.ArticleService;
import org.sharebook.service.UserService;
import org.sharebook.service.impl.ArticleServiceImpl;
import org.sharebook.service.impl.UserServiceImpl;
import org.sharebook.vo.ArticleVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Article> articleList=articleService.getArticles();
        List<ArticleVO> articleVOList = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (Article article : articleList) {
            //当前发表微博的用户
            User user = userService.findUserById(article.getUserId());
            ArticleVO articleVO = new ArticleVO(article, user);

            String images = article.getImages();
            if (images != null) {
                String[] image1 = images.split("#");
                articleVO.setImages(image1);
            }
            articleVO.setCreateTime(dateFormat.format(article.getCreateTime()));
            articleVOList.add(articleVO);
        }
        request.setAttribute("articles",articleVOList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
