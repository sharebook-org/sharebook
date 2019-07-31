package org.sharebook.servlet;


import org.sharebook.constant.status.FollowStatus;
import org.sharebook.model.Article;
import org.sharebook.model.User;
import org.sharebook.service.ArticleService;
import org.sharebook.service.FollowService;
import org.sharebook.service.UserService;
import org.sharebook.service.impl.ArticleServiceImpl;
import org.sharebook.service.impl.FollowServiceImpl;
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
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private final ArticleService articleService;
    private final FollowService followService;
    private final UserService userService;

    public SearchServlet(){
        this.articleService=new ArticleServiceImpl();
        this.followService=new FollowServiceImpl();
        this.userService=new UserServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword=request.getParameter("keyword");
        List<Article> articles = articleService.getArticles(keyword);
        if (articles.size()>0){
            //查询出来的文章
            User loginUser = (User) request.getSession().getAttribute("user");
            List<Long> ids = null;
            if (loginUser != null) {
                Long userId = loginUser.getId();
                ids = followService.showFollowUserId(userId);
            }
            List<ArticleVO> articleVOList = new ArrayList<>();

            for (Article article : articles) {
                //当前发表微博的用户
                User user = userService.findUserById(article.getUserId());
                if (user != null) {
                    ArticleVO articleVO = new ArticleVO(article, user);
                    if (loginUser != null) {
                        int followed = FollowStatus.UNFOLLOWED;
                        if (ids.contains(article.getUserId())) {
                            followed = FollowStatus.FOLLOWED;
                        }
                        articleVO.setFollowed(followed);
                        articleVOList.add(articleVO);
                    } else {
                        articleVOList.add(articleVO);
                    }
                }
            }
            request.setAttribute("articles", articleVOList);
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        }
        else {
            ResponseUtils.write(response, ResponseUtils.error("不存在该内容的文章"));
        }
    }
}
