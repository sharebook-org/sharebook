<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>登录</title>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="./common/nav.jsp"></jsp:include>
<div class="do axz">
  <div class="ayb">
    <form class="ahr avz j">
      <h1 class="l afv">登录</h1>
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

      <div id="error-message" class="mu afh" style="display: none">
        <span style="color: #c9302c"></span>
      </div>

      <div class="afv">
        <button type="button" id="login-button" class="cg nq">登录</button>
        <button type="button" id="register-button" class="cg ns">注册</button>
      </div>

      <footer class="bqx">
        <a href="/forget" class="axc">忘记密码</a>
      </footer>
    </form>
  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
  $(function () {
    $('#register-button').on('click', function () {
      window.location.href = '/register';
    });

    $('#account').blur(function () {
      var result = checkAccount();
      showErrorMessage(result, '用户名不能为空！');
    });

    $('#password').blur(function () {
      var result = checkUserPassword();
      console.log(result);
      showErrorMessage(result, '密码不能为空!');
    });

    //登录
    $('#login-button').on('click', function () {
      var username = $('#account').val();
      var password = $('#password').val();
      console.log('login')
      $.ajax({
        url: '/login',
        method: 'POST',
        dataType: 'json',
        data: {
          username: username,
          password: password,
        },
        success: function (result) {
          console.log('login result' + result)
          if (result.code == 200) {
            window.location.href = '/index';
          } else {
            alert('用户名或密码错误！');
          }
        },
        error: function (result) {
          console.log(result);
        }
      })
    })
  });

  function checkUserPassword() {
    var password = $('#password').val();
    return notBlank(password);
  }
  //根据结果是否展示错误信息
  function showErrorMessage(result, message) {
    if (!result) {
      $('#error-message span').text(message);
      $('#error-message').show();
      $('#login-button').attr('disabled', 'disabled');
    } else {
      $('#error-message').hide();
      $('#login-button').removeAttr('disabled');
    }
  }

</script>
</body>
</html>

