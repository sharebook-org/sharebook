<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>验证邮箱</title>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="./common/nav.jsp"></jsp:include>
<div class="do axz">
  <div class="ayb">
    <form class="ahr avz j">
      <h2 class="l afv">验证邮箱</h2>

      <div class="mu afh">
        <input
            type="email"
            class="form-control"
            placeholder="邮箱"
            readonly
        />
      </div>

      <div class="mu afh" style="display: flex; ">
        <input class="form-control" type="text" placeholder="请输入验证码"/>
        <button class="cg nz ok" type="button" style="margin-left: 5px">获取</button>
      </div>

      <div class="afv">
        <button class="cg nq">确认</button>
      </div>

      <footer class="bqx">
        <a href="/register" class="axc">回到注册</a>
      </footer>
    </form>
  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
</body>
</html>