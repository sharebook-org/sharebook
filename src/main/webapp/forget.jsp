<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>忘记密码</title>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="./common/nav.jsp"></jsp:include>
<div class="do axz">
  <div class="ayb">
    <form class="ahr avz j">
      <h1 class="l afv">忘记密码</h1>
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

      <div class="mu afh">
        <input
            type="password"
            class="form-control"
            placeholder="重复密码"
        />
      </div>

      <div class="afv">
        <button class="cg ns">注册</button>
      </div>

      <footer class="bqx">
        <a href="./login.jsp" class="axc">回到登录</a>
      </footer>
    </form>
  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
</body>
</html>