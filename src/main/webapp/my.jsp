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
        <li class="rv b agz">
          <!-- 头像 -->
          <div style="display: flex; flex-direction: column">
            <img
                class="bos vb yb aff"
                src="assets/img/avatar-dhg.png">
            <button class="cg nz ok" style="width: 60px;margin-top: 5px;">
              <span class="h ayi">关注</span>
            </button>
          </div>
          <div class="rw">
            <div class="bpb">
              <!-- 发表时间 -->
              <small class="acx axc"><%=request.getSession().getAttribute("createTime")%><%--4 min--%></small>
              <!-- 昵称 -->
              <h6>${user.username}</h6>
            </div>
            <!-- 微博内容 -->
            <p>
              <%=request.getSession().getAttribute("content")%>
            </p>
            <!-- 图片 -->
            <div class="boy">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
            </div>

            <div style="display: flex; flex-direction: row; justify-content: space-between; margin-bottom: 10px">
              <span id="forward">转发</span>
              <c:if test="${commentNum gt 0}" var="comment">
                <span id="comment">评论&nbsp;${commentNum}</span>
              </c:if>
              <c:if test="${not comment}">
                <span id="comment">评论</span>
              </c:if>
              <c:if test="${likeNum gt 0}" var="like">
                <span id="like">点赞&nbsp;${likeNum}</span>
              </c:if>
              <c:if test="${not like}">
                <span id="like">点赞</span>
              </c:if>
            </div>
            <div style="display: flex; flex-direction: row;margin-bottom: 10px;">
              <textarea type="text" rows="2" class="form-control" placeholder="来发表您的评论吧！"></textarea>
              <button class="cg nz ok" id="publish-comment">评论</button>
            </div>

            <ul class="bow afa">

              <!-- 第一条评论 -->
              <li class="rv">
                <!-- 头像 -->
                <div style="display: flex; flex-direction: column">
                  <img
                      data-action="zoom"
                      class="bos vb yb aff"
                      src="assets/img/avatar-mdo.png">
                  <button class="cg nz ok" style="width: 40px;margin-top: 5px;">
                    <span>关注</span>
                  </button>
                </div>
                <div class="rw">
                  <strong>${user.username} </strong>
                  这里是评论啊。。。Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dapibus, tellus ac cursus
                  commodo, tortor mauris condimentum nibh, ut fermxxxxxxentum massa jssssssssssssssssssssusto sit amet
                  risus.
                  <!-- 评论时间 -->
                  <small class="acx axc">${createTime}
                </div>
              </li>

            </ul>
          </div>
        </li>
      </ul>
    </div>

  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
  $(function () {
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


