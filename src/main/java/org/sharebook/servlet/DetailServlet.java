package org.sharebook.servlet;

import org.sharebook.constant.EntityType;
import org.sharebook.constant.status.FollowStatus;
import org.sharebook.constant.status.LikeStatus;
import org.sharebook.model.Article;
import org.sharebook.model.Comment;
import org.sharebook.model.User;
import org.sharebook.service.*;
import org.sharebook.service.impl.*;
import org.sharebook.utils.DateFormatUtils;
import org.sharebook.vo.ArticleVO;
import org.sharebook.vo.CommentVO;

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

        Article article = articleService.getArticle(id);
        List<Long> ids = followService.showFollowUserId(article.getUserId());
        ids.add(article.getUserId());
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

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<Comment> commentList = commentService.getCommentList(EntityType.ARTICLE, id);
        List<CommentVO> commentVOList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentVO commentVO = null;
            User user = userService.findUserById(comment.getUserId());
            if (user != null) {
                //TODO 待优化
                commentVO = new CommentVO(user.getId(), user.getUsername(),
                        user.getAvatar(), comment.getId(), comment.getContent());
                String date = DateFormatUtils.complexDateFormat(comment.getCreateTime());
                commentVO.setCreateTime(date);
            }
            commentVOList.add(commentVO);
        }
        request.setAttribute("article", articleVO);
        request.setAttribute("commentVOList", commentVOList);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }
}
