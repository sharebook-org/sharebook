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
      <h1 class="l afv">注册</h1>
      <div class="mu">
        <input id="account" class="form-control" placeholder="账号"/>
      </div>

      <div class="mu afh">
        <input
            id="password"
            type="password"
            class="form-control"
            placeholder="密码"
        />
      </div>

      <div class="mu afh">
        <input
            id="repeat-password"
            type="password"
            class="form-control"
            placeholder="重复密码"
        />
      </div>
      <div id="error-message" class="mu afh" style="display: none">
        <span style="color: #c9302c"></span>
      </div>

      <div class="afv">
        <button id="register-button" class="cg ns" type="button">注册</button>
      </div>

      <footer class="bqx">
        <a href="./login.jsp" class="axc">回到登录</a>
      </footer>
    </form>
  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
  $(function () {
    $('#account').blur(function () {
      console.log('account-input blur');
      var result = checkAccount();
      showErrorMessage(result, '用户名不能为空！');
    });

    $('#repeat-password').blur(function () {
      console.log('repeat-password blur');
      var result = checkPassword();
      showErrorMessage(result, '两次输入的密码不同！');
    });
  });

  function checkPassword() {
    console.log('check password');
    var password = $('#password').val();
    var repeatPassword = $('#repeat-password').val();
    if (password == repeatPassword) {
      return true;
    }
    return false;
  }
  //根据结果是否展示错误信息
  function showErrorMessage(result, message) {
    if (!result) {
      $('#error-message span').text(message);
      $('#error-message').show();
      $('#register-button').attr('disabled', 'disabled');
    } else {
      $('#error-message').hide();
      $('#register-button').removeAttr('disabled');
    }
  }
</script>
</body>
</html>

