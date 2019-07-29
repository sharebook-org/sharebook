<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>我关注的</title>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body class="bob">
<div class="bon" id="app-growl"></div>

<jsp:include page="./common/navbar.jsp"></jsp:include>

<!-- 左侧个人信息 -->
<div class="by aha ahl">
  <div class="dp">

    <div class="fj">

      <div class="pz bpi afo">
        <div class="qf" style="background-image: url(assets/img/iceland.jpg);"></div>
        <div class="qa avz">
          <a href="/profile">
            <img class="bpj" src="assets/img/avatar-dhg.png">
          </a>

          <h6 class="qb">
            <a class="boa" href="/profile">${user.username}</a>
          </h6>

          <p class="afo">${user.introduction}</p>

          <ul class="bpk">
            <li class="bpl">
              <a href="#userModal" class="boa" data-toggle="modal">
                关注的人
                <h6 class="aej">12M</h6>
              </a>
            </li>

            <li class="bpl">
              <a href="#userModal" class="boa" data-toggle="modal">
                粉丝
                <h6 class="aej">1</h6>
              </a>
            </li>
          </ul>
        </div>
      </div>

      <div class="pz vp vy afo">
        <div class="qa">
          <h6 class="afh">基本资料
            <small>· <a href="./profile.jsp">编辑</a></small>
          </h6>
          <ul class="dc axg">
            <li><span class="axc h bgz aff"></span>性别 :
              <c:if test="${user.sex==0}">女</c:if>
              <c:if test="${user.sex==1}">男</c:if>
              <c:if test="${user.sex==2}">其他</c:if>
            </li>
            <li><span class="axc h bgz aff"></span>生日 :${user.birth}</li>
            <li><span class="axc h bip aff"></span>地址 :${user.location}</li>
            <li><span class="axc h bjl aff"></span>注册时间 :<span id="createTime"></span></li>
          </ul>
        </div>
      </div>
    </div>

    <!-- 微博 -->
    <div class="fm">
      <ul class="ca bow box afo">
        <!-- 发表框 -->
        <li>
          <div style="display: flex; flex-direction: row;margin-bottom: 10px;">
            <textarea id="article" type="text" rows="2" class="form-control" placeholder="分享新鲜事"></textarea>
            <button class="cg nz ok" id="publish">带图<br>微博</button>
            <button class="cg nz ok" id="publish-button">发布</button>
          </div>
        </li>

        <!-- 微博主体 -->
        <li class="rv b agz">
          <!-- 头像 -->
          <div style="display: flex; flex-direction: column">
            <img
                data-action="zoom"
                class="bos vb yb aff"
                src="assets/img/avatar-dhg.png">
            <button class="cg nz ok" style="width: 60px;margin-top: 5px;">
              <span>关注</span>
            </button>
          </div>
          <div class="rw">
            <div class="bpb">
              <!-- 发表时间 -->
              <small class="acx axc"><%=request.getSession().getAttribute("createTime")%><%--4 min--%></small>
              <!-- 昵称 -->
              <div style="display: flex; ">
                <h6>Dave Gamache</h6>

              </div>
            </div>
            <!-- 微博内容 -->
            <p>
              <%=request.getSession().getAttribute("content")%>
              <%--              Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.--%>
            </p>
            <!-- 图片 -->
            <div class="boy">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
              <img style="width: 150px;height: 150px;" data-action="zoom" src="assets/img/unsplash_1.jpg">
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
          </div>
        </li>
      </ul>
    </div>

    <!-- 右侧推荐框 -->
    <div class="fj">
      <div class="pz afo d-none vy">
        <div class="qa">
          <h6 class="afh">Likes
            <small>· <a href="#">View All</a></small>
          </h6>
          <ul class="bow box">
            <li class="rv afa">
              <img
                  class="bos vb yb aff"
                  src="assets/img/avatar-fat.jpg">
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
                    src="assets/img/avatar-mdo.png">
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

      <!-- 照片 -->
      <div class="pz vp vy afo">
        <div class="qa">
          <h6 class="afh">照片</h6>
          <div data-grid="images" data-target-height="150">
            <div>
              <img data-width="640" data-height="640" data-action="zoom" src="assets/img/instagram_5.jpg">
            </div>

            <div>
              <img data-width="640" data-height="640" data-action="zoom" src="assets/img/instagram_6.jpg">
            </div>

            <div>
              <img data-width="640" data-height="640" data-action="zoom" src="assets/img/instagram_7.jpg">
            </div>

            <div>
              <img data-width="640" data-height="640" data-action="zoom" src="assets/img/instagram_8.jpg">
            </div>

            <div>
              <img data-width="640" data-height="640" data-action="zoom" src="assets/img/instagram_9.jpg">
            </div>

            <div>
              <img data-width="640" data-height="640" data-action="zoom" src="assets/img/instagram_10.jpg">
            </div>
          </div>
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
    var date = '${user.createTime}';
    $('#createTime').text(date.substring(0, date.length - 2));
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
            } else {
              alert('发表文章失败！');
            }
          }
        })
      }
    });
    $('#publish').on('click', function () {
      window.location.href = '/publish';
    })
  })
</script>
</body>
</html>


