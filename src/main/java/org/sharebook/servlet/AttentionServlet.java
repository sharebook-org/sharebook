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
import org.sharebook.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/attention")
public class AttentionServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final FollowService followService = new FollowServiceImpl();
    private final ArticleService articleService = new ArticleServiceImpl();
    private final LikeService likeService = new LikeServiceImpl();

    //检测用户是否登录，从而控制关注页面的展示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser != null) {
            Long userId = loginUser.getId();
            Map<String, Long> map = getFollowAndFans(userId);

            //获取关注的人的所有id和自己的id
            List<Long> ids = followService.showFollowUserId(userId);
            ids.add(userId);
            List<Article> articles = articleService.getArticles(ids);

            List<ArticleVO> articleVOList = new ArrayList<>();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Article article : articles) {
                //当前发表微博的用户
                User user = userService.findUserById(article.getUserId());
                ArticleVO articleVO = new ArticleVO(article, user);
                Integer likedStatus = likeService.getLikedStatus(EntityType.ARTICLE,article.getId(),loginUser.getId());
                articleVO.setLiked(likedStatus);
                int followed = FollowStatus.UNFOLLOWED;
                if (ids.contains(article.getUserId())){
                    followed=FollowStatus.FOLLOWED;
                }
                articleVO.setFollowed(followed);
                String images = article.getImages();
                if (images != null) {
                    String[] image1 = images.split("#");
                    articleVO.setImages(image1);
                }
                articleVO.setCreateTime(dateFormat.format(article.getCreateTime()));
                articleVOList.add(articleVO);
            }

            //基本资料
            request.setAttribute("profile", new UserVO(loginUser));
            //关注数粉丝数
            request.setAttribute("number", map);
            //微博列表
            request.setAttribute("articles", articleVOList);
            request.getRequestDispatcher("/attention.jsp").forward(request, response);
        } else {
            ResponseUtils.write(response, ResponseUtils.error());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index").forward(request, response);
    }

    /**
     * 获取关注数和粉丝数
     *
     * @param userId
     * @return
     */
    private Map<String, Long> getFollowAndFans(Long userId) {
        //得到关注的人数
        Long res1 = followService.showFollowNum(userId);
        //得到粉丝数
        Long res2 = followService.showUserNum(userId);
        Map<String, Long> map = new HashMap<>();
        map.put("followCount", res1);
        map.put("fansCount", res2);
        return map;
    }
}
