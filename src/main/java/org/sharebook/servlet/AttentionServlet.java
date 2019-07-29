package org.sharebook.servlet;

import org.sharebook.model.Article;
import org.sharebook.model.Follow;
import org.sharebook.model.User;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/attention")
public class AttentionServlet extends HttpServlet {
    public final UserServiceImpl userService = new UserServiceImpl();
    public final FollowServiceImpl followService = new FollowServiceImpl();
    public final ArticleServiceImpl articleService = new ArticleServiceImpl();
    //检测用户是否登录，从而控制关注页面的展示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Long userId=user.getId();

            //得到关注的人数
            Long res1 = followService.showFollowNum(userId);
            //得到粉丝数
            Long res2 = followService.showUserNum(userId);
            request.setAttribute("followCount",res1);
            request.setAttribute("fansCount",res2);
            Map map = new HashMap<>();
            map.put("followCount", res1);
            map.put("fansCount", res2);


            //获取当前用户关注的人
            //Follow follow = followService.showFollow(userId);
            List<Follow> follows = followService.showFollows(userId);
            //获取关注的人的所有id和自己的id
            List<Long> ids = followService.showFollowUserId(userId);
            ids.add(userId);
            //List<User> follow = userService.findUsers(ids);   //得到发表文章的人的名字
            List<Article> articles = articleService.getArticles(ids);   //文章
            List<ArticleVO> articleVOS = new ArrayList<>();
            for (Article article:articles){
                ArticleVO articleVO=new ArticleVO();
                articleVO.setId(article.getId());
                articleVO.setUserId(article.getUserId());
                User user1 = userService.findUserById(article.getUserId());
                articleVO.setUsername(user1.getUsername());
                articleVO.setContent(article.getContent());
                articleVO.setAvatar(user1.getAvatar());
                String images1=article.getImages();
                if (images1!=null){
                    String[] image1=images1.split("#");
                    articleVO.setImages(image1);
                }
                articleVO.setStatus(article.getStatus());
                articleVO.setCommentNum(article.getCommentNum());
                articleVO.setLikeNum(article.getLikeNum());
                articleVO.setCreateTime(article.getCreateTime());
                articleVOS.add(articleVO);
            }
            request.setAttribute("articles",articleVOS);

            ResponseUtils.write(response, ResponseUtils.success(map));
            request.getRequestDispatcher("/attention.jsp").forward(request, response);
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index").forward(request, response);
    }

}
