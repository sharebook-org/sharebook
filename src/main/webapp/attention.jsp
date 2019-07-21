<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>我的关注</title>
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
          <a href="./profile.jsp">
            <img class="bpj" src="assets/img/avatar-dhg.png">
          </a>

          <h6 class="qb">
            <a class="boa" href="./profile.jsp">Dave Gamache</a>
          </h6>

          <p class="afo">I wish i was a little bit taller, wish i was a baller, wish i had a girl… also.</p>

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
          <h6 class="afh">个人简介<small>· <a href="./profile.jsp">编辑</a></small></h6>
          <ul class="dc axg">
            <li><span class="axc h bgz aff"></span>居住地 <a href="#">Oh, Canada</a>
            <li><span class="axc h bip aff"></span>毕业于 <a href="#">Obama</a>
            <li><span class="axc h bjl aff"></span>QQ <a href="#">Github</a>
            <li><span class="axc h bit aff"></span>简介 <a href="#">San Francisco, CA</a>
          </ul>
        </div>
      </div>
    </div>

    <!-- 微博 -->
    <div class="fm">
      <ul class="ca bow box afo">
        <!-- 发表框 -->
        <li class="rv b agz">
          <div class="input-group">
            <textarea type="text" class="form-control" placeholder="Message"></textarea>
            <!-- 上传图片按钮和发表按钮 -->
            <div class="bpt">
              <button type="button" class="cg ns yf" data-toggle="modal" data-target="#exampleModal">
                <span class="h azo"></span>
              </button>
              <button type="button" class="cg ns yf">
                <span class="h bir"></span>
              </button>
            </div>
          </div>
        </li>

        <!-- 微博主体 -->
        <li class="rv b agz">
          <!-- 头像 -->
          <img
              class="bos vb yb aff"
              src="assets/img/avatar-dhg.png">
          <div class="rw">
            <div class="bpb">
              <!-- 发表时间 -->
              <small class="acx axc">4 min</small>
              <!-- 昵称 -->
              <h6>Dave Gamache</h6>
            </div>
            <!-- 微博内容 -->
            <p>
              Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            </p>
            <!-- 图片 -->
            <div class="boy" data-grid="images">
              <div style="display: none">
                <img data-action="zoom" data-width="1050" data-height="700" src="assets/img/unsplash_1.jpg">
              </div>

              <div style="display: none">
                <img data-action="zoom" data-width="640" data-height="640" src="assets/img/instagram_1.jpg">
              </div>

              <div style="display: none">
                <img data-action="zoom" data-width="640" data-height="640" src="assets/img/instagram_13.jpg">
              </div>

              <div style="display: none">
                <img data-action="zoom" data-width="1048" data-height="700" src="assets/img/unsplash_2.jpg">
              </div>
            </div>

            <ul class="bow afa">
              <!-- 评论 -->
              <li class="rv afh">
                <img
                    class="bos vb yb aff"
                    src="assets/img/avatar-fat.jpg">
                <div class="rw">
                  <strong>Jacon Thornton: </strong>
                  Donec id elit non mi porta gravida at eget metus. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Donec ullamcorper nulla non metus auctor fringilla. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Sed posuere consectetur est at lobortis.
                </div>
              </li>
              <!-- 评论 -->
              <li class="rv">
                <img
                    class="bos vb yb aff"
                    src="assets/img/avatar-mdo.png">
                <div class="rw">
                  <strong>Mark Otto: </strong>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.
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
          <h6 class="afh">Likes <small>· <a href="#">View All</a></small></h6>
          <ul class="bow box">
            <li class="rv afa">
              <img
                  class="bos vb yb aff"
                  src="assets/img/avatar-fat.jpg">
              <div class="rw">
                <strong>Jacob Thornton</strong> @fat
                <div class="bpa">
                  <button class="cg nz ok">
                    <span class="h ayi"></span> Follow</button>
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
                    <span class="h ayi"></span> Follow</button>
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
</body>
</html>


