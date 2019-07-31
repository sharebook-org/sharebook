package org.sharebook.servlet;

import org.sharebook.constant.EntityType;
import org.sharebook.constant.status.FollowStatus;
import org.sharebook.model.Article;
import org.sharebook.model.Comment;
import org.sharebook.model.User;
import org.sharebook.service.ArticleService;
import org.sharebook.service.CommentService;
import org.sharebook.service.FollowService;
import org.sharebook.service.UserService;
import org.sharebook.service.impl.ArticleServiceImpl;
import org.sharebook.service.impl.CommentServiceImpl;
import org.sharebook.service.impl.FollowServiceImpl;
import org.sharebook.service.impl.UserServiceImpl;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        Article article = articleService.getArticle(id);
        List<Long> ids = followService.showFollowUserId(article.getUserId());
        ids.add(article.getUserId());
        ArticleVO articleVO = null;
        if (article != null) {
            //向VO对象赋值
            User user = userService.findUserById(article.getUserId());
            articleVO = new ArticleVO(article, user);

            int followed = FollowStatus.UNFOLLOWED;
            if (ids.contains(article.getUserId())) {
                followed = FollowStatus.FOLLOWED;
            }
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
