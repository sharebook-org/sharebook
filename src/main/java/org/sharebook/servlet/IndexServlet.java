package org.sharebook.servlet;

import org.sharebook.constant.EntityType;
import org.sharebook.constant.status.ArticleStatus;
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
import org.sharebook.vo.ArticleVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final ArticleService articleService = new ArticleServiceImpl();
    private final FollowService followService = new FollowServiceImpl();
    private final LikeService likeService = new LikeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //待渲染的文章
        List<Article> articleList = null;
        User loginUser = (User) request.getSession().getAttribute("user");
        List<Long> ids = null;
        if (loginUser != null) {
            Long userId = loginUser.getId();
            ids = followService.showFollowUserId(userId);
        }
            articleList = articleService.getArticles();
        List<ArticleVO> articleVOList = new ArrayList<>();

        //TODO 代码重复
        for (Article article : articleList) {
            //当前发表微博的用户
            User user = userService.findUserById(article.getUserId());
            if (user != null) {
                if (!user.getStatus().equals(ArticleStatus.NORMAL)) {
                    continue;
                }
                ArticleVO articleVO = new ArticleVO(article, user);
                if (loginUser != null) {
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
                } else {
                    articleVOList.add(articleVO);
                }
            }
        }
        request.setAttribute("articles", articleVOList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
