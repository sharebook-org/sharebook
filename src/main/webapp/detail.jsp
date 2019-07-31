<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>详情</title>
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
        <li class="rv b agz">
          <c:if test="${empty article}">
            跳到异次元啦！
          </c:if>
          <c:if test="${!empty article}">
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
                <small
                    class="acx axc">${article.createTime}</small>
                <!-- 昵称 -->
                <h6>${article.username}</h6>
              </div>
              <!-- 微博内容 -->
              <p>
                  ${article.content}
              </p>
              <!-- 图片 -->
              <div class="boy">
                <c:forEach items="${article.images}" var="images">
                  <img style="width: 150px;height: 150px;" data-action="zoom" src="${images}">
                </c:forEach>
              </div>

              <div
                  style="display: flex; flex-direction: row; justify-content: space-between; margin-bottom: 10px">
                <span id="forward">转发</span>
                <c:if test="${article.commentNum gt 0}" var="commented">
                  <span id="comment" onclick="handleCommentClick(${article.id})">评论&nbsp;${article.commentNum}</span>
                </c:if>
                <c:if test="${not commented}">
                  <span id="comment" onclick="handleCommentClick(${article.id})">评论${article.commentNum}</span>
                </c:if>
                <c:if test="${article.likeNum gt 0}" var="like">
                  <span id="like">点赞&nbsp;${article.likeNum}</span>
                </c:if>
                <c:if test="${not like}">
                  <span id="like">点赞</span>
                </c:if>
              </div>
              <div style="display: flex; flex-direction: row;margin-bottom: 10px;">
                <textarea id="content" type="text" rows="2" class="form-control" placeholder="来发表您的评论吧！"></textarea>
                <button class="cg nz ok" id="publish-comment">评论 </button>
              </div>

              <ul class="bow afa">
                <c:if test="${empty commentVOList}">
                  <li class="rv">暂时没有评论！</li>
                </c:if>
                <c:if test="${not empty commentVOList}">
                  <c:forEach items="${commentVOList}" var="commentVO">
                    <!-- 第一条评论 -->
                    <li class="rv">
                      <!-- 头像 -->
                      <div style="display: flex; flex-direction: column">
                        <img
                                data-action="zoom"
                                class="bos vb yb aff"
                                src="${commentVO.avatar}">
                        <c:if test="${commentVO.userId eq user.id}" var="currentUser">
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
                        <strong>${commentVO.username}</strong>
                          ${commentVO.content}
                        <!-- 评论时间 -->
                        <small class="acx axc">${commentVO.createTime}</small>
                      </div>
                    </li>
                  </c:forEach>
                </c:if>
              </ul>
            </div>
          </c:if>
        </li>
      </ul>
    </div>

  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
  $(function () {
    $('#publish-comment').on('click', function () {
      var content = $('#content').val();
      var id = '<%=request.getParameter("id")%>';
      var userId = '${user.id}';
      if (notBlank(userId)) {
        $.ajax({
          url: '/comment',
          method: 'POST',
          dataType: 'json',
          data: {
            userId: userId,
            content: content,
            entityType: 0,
            entityId: id
          },
          success: function (result) {
            if (result.code == 200) {
              alert('发表成功');
              $('#content').val('');
              window.location.href = '/detail?id=' + id;
            } else {
              alert('发表失败');
            }
          }
        })
      } else {
        alert("您还未登录！");
      }

    });
    $('#forward').on('click', function () {
      alert('转发');
    });
  })
</script>
</body>
</html>