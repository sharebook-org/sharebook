package org.sharebook.servlet;

import org.sharebook.constant.EntityType;
import org.sharebook.constant.status.FollowStatus;
import org.sharebook.model.Article;
import org.sharebook.model.User;
import org.sharebook.service.ArticleService;
import org.sharebook.service.FollowService;
import org.sharebook.service.LikeService;
import org.sharebook.service.UserService;
import org.sharebook.service.impl.ArticleServiceImpl;
import org.sharebook.service.impl.FollowServiceImpl;
import org.sharebook.service.impl.LikeServiceImpl;
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

@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {

    private final ArticleService articleService;
    private final UserService userService;
    private final LikeService likeService;
    private final FollowService followService;

    public MyServlet() {
        this.articleService = new ArticleServiceImpl();
        this.userService = new UserServiceImpl();
        this.likeService = new LikeServiceImpl();
        this.followService = new FollowServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser != null) {
            Long userId = loginUser.getId();
            //获取自己的id
            List<Long> ids = followService.showFollowUserId(userId);
            ids.add(userId);
            List<Article> articles = articleService.getArticles(ids);
            List<Article> articleList=articleService.getArticles(userId);
            List<ArticleVO> articleVOList = new ArrayList<>();
            if (articleList!=null){
               for (Article article:articleList){
                   User user = userService.findUserById(article.getUserId());
                   ArticleVO articleVO = new ArticleVO(article, user);
                   Integer likedStatus = likeService.getLikedStatus(
                           EntityType.ARTICLE, article.getId(), loginUser.getId()
                   );
                   articleVO.setLiked(likedStatus);
                   int followed = FollowStatus.UNFOLLOWED;
                   if (ids.contains(article.getUserId())) {
                       followed = FollowStatus.FOLLOWED;
                   }
                   articleVO.setFollowed(followed);
                   articleVOList.add(articleVO);
               }
            }
            //微博列表
            request.setAttribute("articles", articleVOList);
            request.getRequestDispatcher("/my.jsp").forward(request, response);
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }
}
