package org.sharebook.servlet.admin;

import org.apache.commons.lang3.StringUtils;
import org.sharebook.model.Article;
import org.sharebook.model.User;
import org.sharebook.service.ArticleManageService;
import org.sharebook.service.UserService;
import org.sharebook.service.impl.ArticleManageServiceImpl;
import org.sharebook.service.impl.UserServiceImpl;
import org.sharebook.utils.ResponseUtils;
import org.sharebook.vo.ArticleVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/articles")
public class ArticleManageServlet extends HttpServlet {

    private ArticleManageService articleManageService = new ArticleManageServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("size"));

        List<Article> articles = articleManageService.getAllArticles(page, size);
        List<ArticleVO> articleVOList = new ArrayList<>();
        for (Article article : articles){
            User user = userService.findUserById(article.getUserId());
            ArticleVO articleVO = new ArticleVO(article, user);
            articleVOList.add(articleVO);
        }
        long count = articleManageService.getArticlesCount();
        Map map = new HashMap();
        map.put("count", count);
        ResponseUtils.write(response, ResponseUtils.success(articleVOList, map));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hasId = request.getParameter("id");
        int status = Integer.parseInt(request.getParameter("status"));
        if (StringUtils.isBlank(hasId)) {
            ResponseUtils.write(response, ResponseUtils.error("该文章不存在"));
            return;
        }
        long id = Long.parseLong(hasId);
        Article article = articleManageService.getArticle(id);
        article.setStatus(status);
        int result = articleManageService.updateArticle(article);
        if (result != 0) {
            ResponseUtils.write(response, ResponseUtils.success("文章修改成功"));
        } else {
            ResponseUtils.write(response, ResponseUtils.error("文章修改失败"));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hasId = request.getParameter("id");
        if (StringUtils.isBlank(hasId)) {
            ResponseUtils.write(response, ResponseUtils.error("该文章不存在"));
            return;
        }
        long id = Long.parseLong(hasId);
        int result = articleManageService.deleteArticle(id);
        if (result != 0) {
            ResponseUtils.write(response, ResponseUtils.success("文章已被删除"));
        } else {
            ResponseUtils.write(response, ResponseUtils.error("该文章不存在"));
        }
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
    }
}
