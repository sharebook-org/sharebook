<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="./common/nav.jsp"></jsp:include>
<div class="do axz">
  <div class="ayb">
    <form class="ahr avz j">
      <h1 class="l afv">登录</h1>
      <div class="mu">
        <input class="form-control" placeholder="账号" />
      </div>

      <div class="mu afh">
        <input
            type="password"
            class="form-control"
            placeholder="密码"
        />
      </div>

      <div class="afv">
        <button type="button" id="loginBtn" class="cg nq">登录</button>
        <button type="button" id="registerBtn" class="cg ns">注册</button>
      </div>

      <footer class="bqx">
        <a href="./forget.jsp" class="axc">忘记密码</a>
      </footer>
    </form>
  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
    $(function () {
        $('#registerBtn').on('click', function () {
            window.location.href = './register.jsp';
        });
    })
</script>
</body>
</html>

