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
              <small class="acx axc">4 min</small>
              <!-- 昵称 -->
              <h6>Dave Gamache</h6>
            </div>
            <!-- 微博内容 -->
            <p>
              Aenean lacinia bibendum nulla sed consectetur. Vestibulum id
              ligula porta felis euismod semper. Morbi leo risus, porta ac
              consectetur ac, vestibulum at eros. Cras justo odio, dapibus
              ac facilisis in, egestas eget quam. Vestibulum id ligula porta
              felis euismod semper. Cum sociis natoque penatibus et magnis
              dis parturient montes, nascetur ridiculus mus.
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
                <span id="comment" onclick="handleCommentClick(id)">评论&nbsp;${commentNum}</span>
              </c:if>
              <c:if test="${not comment}">
                <span id="comment" onclick="handleCommentClick(id)">评论</span>
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
          <h6 class="afh">
            Likes <small>· <a href="#">View All</a></small>
          </h6>
          <ul class="bow box">
            <li class="rv afa">
              <img class="bos vb yb aff" src="assets/img/avatar-fat.jpg" />
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
  })

  function handleCommentClick(id) {
    var href = '/detail?id=' + id;
    window.open(href, '_blank');
  };
</script>
</body>
</html>

