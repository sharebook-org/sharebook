<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>首页</title>
    <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body class="bob">

<jsp:include page="./common/navbar.jsp"></jsp:include>

<div class="by aha ahl">
    <div class="dp">
        <!-- 左侧 -->
        <div class="fj">
            <div class="pz vp vy afo">
                <!-- 排行榜 -->
                <div class="qa">
                    <h6 class="afh">
                        热搜
                        <small>· <a href="/hots">查看其他热榜</a></small>
                    </h6>
                    <ul class="dc axg" id="hot-list"></ul>
                </div>
            </div>
        </div>

        <!-- 微博列表 -->
        <div class="fm">
            <ul class="ca bow box afo">
                <!-- 微博主体 -->
                <c:if test="${empty articles}">
                    <li class="rv b agz">暂时没有微博呀！</li>
                </c:if>
                <c:if test="${!empty articles}">
                    <c:forEach items="${articles}" var="article">
                        <li class="rv b agz">
                            <!-- 头像 -->
                            <div style="display: flex; flex-direction: column">
                                <img
                                        data-action="zoom"
                                        class="bos vb yb aff"
                                        src="${article.avatar}">
                                <c:if test="${article.userId eq user.id}" var="currentUser">
                                    <button class="cg nz ok" style="width: 60px;margin-top: 5px;" hidden>
                                        <span>关注</span>
                                    </button>
                                </c:if>
                                <c:if test="${not currentUser}">
                                    <c:if test="${article.followed eq 0}">
                                        <button class="cg nz ok" style="width: 60px;margin-top: 5px;">
                                            <span onclick="follow('${article.userId}','${user.id}')">关注</span>
                                        </button>
                                    </c:if>
                                    <c:if test="${article.followed eq 1}">
                                        <button class="cg nz ok" style="width: 60px;margin-top: 5px;">
                                            <span onclick="followCancle('${article.userId}','${user.id}')">已关注</span>
                                        </button>
                                    </c:if>
                                </c:if>
                            </div>
                            <div class="rw">
                                <div class="bpb">
                                    <!-- 发表时间 -->
                                    <small class="acx axc">${article.createTime}</small>
                                    <!-- 昵称 -->
                                    <div style="display: flex; ">
                                        <c:if test="${article.role eq 1}">
                                            <h6 style="color: red;font-size: 15px">${article.username}</h6>
                                        </c:if>
                                        <c:if test="${article.role eq 0}">
                                            <h6>${article.username}</h6>
                                        </c:if>
                                    </div>
                                </div>
                                <!-- 微博内容 -->
                                <p>${article.content}</p>
                                <!-- 图片 -->
                                <div class="boy">
                                    <c:forEach items="${article.images}" var="images">
                                        <img style="width: 150px;height: 150px;" data-action="zoom" src="${images}">
                                    </c:forEach>
                                </div>

                                <div style="display: flex; flex-direction: row; justify-content: space-between; margin-bottom: 10px">
                                    <span id="forward">转发</span>
                                    <c:if test="${article.commentNum eq 0}" var="comment">
                                        <span id="comment" onclick="handleCommentClick(${article.id})">评论</span>
                                    </c:if>
                                    <c:if test="${not comment}">
                                        <span id="comment"
                                              onclick="handleCommentClick(${article.id})">评论&nbsp;${article.commentNum}</span>
                                    </c:if>
                                    <c:if test="${article.likeNum eq 0}" var="like">
                                        <span id="like" onclick="like('${article.id}','${user.id}')">点赞</span>
                                    </c:if>
                                    <c:if test="${not like}">
                                        <c:if test="${article.liked eq 0}" var="liked">
                                            <span id="like"
                                                  onclick="like('${article.id}','${user.id}')">点赞&nbsp;${article.likeNum}</span>
                                        </c:if>
                                        <c:if test="${not liked}">
                                            <span id="like"
                                                  onclick="likeCancle('${article.id}','${user.id}')">已点赞&nbsp;${article.likeNum}</span>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>

        <!-- 右侧推荐框 -->
        <div class="fj">
            <div class="pz afo d-none vy">
                <div class="qa">
                    <h6 class="afh">
                        Likes
                        <small>· <a href="#">View All</a></small>
                    </h6>
                    <ul class="bow box">
                        <li class="rv afa">
                            <img class="bos vb yb aff" src="assets/img/avatar-fat.jpg"/>
                            <div class="rw">
                                <strong>Jacob Thornton</strong> @fat
                                <div class="bpa">
                                    <button class="cg nz ok">
                                        <span class="h ayi"></span> Follow
                                    </button>
                                </div>
                            </div>
                        </li>
                        <li class="rv">
                            <a class="bpu" href="#">
                                <img
                                        class="bos vb yb aff"
                                        src="assets/img/avatar-mdo.png"
                                />
                            </a>
                            <div class="rw">
                                <strong>Mark Otto</strong> @mdo
                                <div class="bpa">
                                    <button class="cg nz ok">
                                        <span class="h ayi"></span> Follow
                                    </button>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- 版权 -->
            <jsp:include page="./common/copyright.jsp"></jsp:include>
        </div>
    </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
    $(function () {
        //获取热榜数据
        $.ajax({
            url: '/hots',
            method: 'POST',
            dataType: 'json',
            success: function (result) {
                var str = '';
                if (result.code == 200) {
                    var data = result.data;
                    $.each(data, function (i, n) {
                        str += '<li><a href=\"' + n.url + '\" target=\"_blank\">' + n.title + '</a></li>';
                    });
                } else {
                    str += '<li>暂时没有数据！</li>';
                }
                $('#hot-list').append(str);
            },
            error: function (result) {
                console.log(result);
                var str = '<li>暂时没有数据！</li>';
                $('#hot-list').append(str);
            }
        });
    });
</script>
</body>
</html>

