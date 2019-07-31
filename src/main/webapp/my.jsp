<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>我的关注</title>
    <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body class="bob">

<jsp:include page="./common/navbar.jsp"></jsp:include>

<div class="by aha ahl">
    <div class="dp">
        <!-- 微博 -->
        <div class="fm" style="margin: 0 auto">
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
                                <c:if test="${article.role eq 1}" >
                                    <img
                                            style="border: 5px solid gold"
                                            data-action="zoom"
                                            class="bos vb yb aff"
                                            src="${article.avatar}">
                                </c:if>
                                <c:if test="${article.role eq 0}">
                                    <img
                                            data-action="zoom"
                                            class="bos vb yb aff"
                                            src="${article.avatar}">
                                </c:if>
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
                                        <h6>${article.username}</h6>
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
                                        <span id="comment" onclick="handleCommentClick(${article.id})">评论&nbsp;${article.commentNum}</span>
                                    </c:if>
                                    <c:if test="${article.likeNum eq 0}" var="like">
                                        <span id="like" onclick="like('${article.id}','${user.id}')">点赞</span>
                                    </c:if>
                                    <c:if test="${not like}">
                                        <c:if test="${article.liked eq 0}" var="liked">
                                            <span id="like" onclick="like('${article.id}','${user.id}')">点赞&nbsp;${article.likeNum}</span>
                                        </c:if>
                                        <c:if test="${not liked}">
                                            <span id="like" onclick="likeCancle('${article.id}','${user.id}')">已点赞&nbsp;${article.likeNum}</span>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>

    </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
    $(function () {
            $(function () {
                $('#publish-button').on('click', function () {
                    var article = $('#article').val();
                    var res = notBlank(article);
                    if (!res) {
                        alert('文章内容不能为空!');
                    } else {
                        $.ajax({
                            url: '/article',
                            method: 'POST',
                            data: {
                                userId:${user.id},
                                article: article,
                            },
                            success: function (result) {
                                if (result.code == 200) {
                                    alert('发表文章成功！');
                                    $('#article').val('');
                                    window.location.href='/attention';
                                } else {
                                    alert('发表文章失败！');
                                }
                            }
                        })
                    }
                });
                $('#publish').on('click', function () {
                    window.location.href = '/publish';
                });
            })
    $('#publish-comment').on('click', function () {
            alert('comment')
        });
        $('#forward').on('click', function () {
            alert('转发');
        });
    })
</script>
</body>
</html>


