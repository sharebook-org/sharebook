package org.sharebook.servlet;

import org.sharebook.constant.EntityType;
import org.sharebook.constant.status.FollowStatus;
import org.sharebook.constant.status.LikeStatus;
import org.sharebook.model.Article;
import org.sharebook.model.Comment;
import org.sharebook.model.User;
import org.sharebook.service.*;
import org.sharebook.service.impl.*;
import org.sharebook.vo.ArticleVO;
import org.sharebook.vo.CommentVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/detail")
public class DetailServlet extends HttpServlet {

    private final CommentService commentService = new CommentServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final ArticleService articleService = new ArticleServiceImpl();
    private final FollowService followService = new FollowServiceImpl();
    private final LikeService likeService = new LikeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("user");

        long id = Long.parseLong(request.getParameter("id"));

        List<Long> ids = null;
        if (loginUser != null) {
            Long userId = loginUser.getId();
            ids = followService.showFollowUserId(userId);
        }
        Article article = articleService.getArticle(id);
        ArticleVO articleVO = null;
        if (article != null) {
            //向VO对象赋值
            User user = userService.findUserById(article.getUserId());
            articleVO = new ArticleVO(article, user);

            Integer likedStatus = LikeStatus.UNLIKED;
            int followed = FollowStatus.UNFOLLOWED;
            if (loginUser!=null){
                 likedStatus= likeService.getLikedStatus(
                        EntityType.ARTICLE, article.getId(), loginUser.getId()
                );
                if (ids.contains(article.getUserId())) {
                    followed = FollowStatus.FOLLOWED;
                }
            }
            articleVO.setLiked(likedStatus);
            articleVO.setFollowed(followed);
        }

        //获取评论
        List<Comment> commentList = commentService.getCommentList(EntityType.ARTICLE, id);
        List<CommentVO> commentVOList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentVO commentVO = null;
            User user = userService.findUserById(comment.getUserId());
            if (user != null) {
                commentVO = new CommentVO(user, comment);
            }
            commentVOList.add(commentVO);
        }
        request.setAttribute("article", articleVO);
        request.setAttribute("commentVOList", commentVOList);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }
}
