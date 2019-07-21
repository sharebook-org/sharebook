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
            <small>· <a href="#">查看其他热榜</a></small>
          </h6>
          <ul class="dc axg">
            <c:if test="${hots != null || hots.size() > 0}" var="hasHots">
              <c:forEach items="${hots}" var="hot">
                <li><a href="${hot.url}" target="_blank">${hot.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${not hasHots}">
              <li>暂时没有数据啦！</li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>

    <!-- 微博列表 -->
    <div class="fm">
      <ul class="ca bow box afo">
        <!-- 微博主体 -->
        <li class="rv b agz">
          <!-- 头像 -->
          <img class="bos vb yb aff" src="assets/img/avatar-dhg.png" />
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
            <div class="boy" data-grid="images">
              <div style="display: none">
                <img
                    data-action="zoom"
                    data-width="1050"
                    data-height="700"
                    src="assets/img/unsplash_1.jpg"
                />
              </div>

              <div style="display: none">
                <img
                    data-action="zoom"
                    data-width="640"
                    data-height="640"
                    src="assets/img/instagram_1.jpg"
                />
              </div>

              <div style="display: none">
                <img
                    data-action="zoom"
                    data-width="640"
                    data-height="640"
                    src="assets/img/instagram_13.jpg"
                />
              </div>

              <div style="display: none">
                <img
                    data-action="zoom"
                    data-width="1048"
                    data-height="700"
                    src="assets/img/unsplash_2.jpg"
                />
              </div>
            </div>

            <ul class="bow afa">
              <!-- 评论 -->
              <li class="rv afh">
                <img
                    class="bos vb yb aff"
                    src="assets/img/avatar-fat.jpg"
                />
                <div class="rw">
                  <strong>Jacon Thornton: </strong>
                  Donec id elit non mi porta gravida at eget metus. Vivamus
                  sagittis lacus vel augue laoreet rutrum faucibus dolor
                  auctor. Donec ullamcorper nulla non metus auctor
                  fringilla. Praesent commodo cursus magna, vel scelerisque
                  nisl consectetur et. Sed posuere consectetur est at
                  lobortis.
                </div>
              </li>
              <!-- 评论 -->
              <li class="rv">
                <img
                    class="bos vb yb aff"
                    src="assets/img/avatar-mdo.png"
                />
                <div class="rw">
                  <strong>Mark Otto: </strong>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  Fusce dapibus, tellus ac cursus commodo, tortor mauris
                  condimentum nibh, ut fermentum massa justo sit amet risus.
                </div>
              </li>
            </ul>
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
</body>
</html>

