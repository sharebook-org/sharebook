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
      <h2>登录</h2>
      <div class="mu">
        <input id="account" class="form-control" placeholder="邮箱/手机号"/>
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
        <a href="/forget" class="axc">找回密码</a>
        <a href="/modify" class="axc">修改密码</a>
        <span style="cursor:pointer" id="check" class="axc">激活账户</span>
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
      showErrorMessage(result, '账户名不能为空！');
    });

    $('#password').blur(function () {
      var result = checkUserPassword();
      showErrorMessage(result, '密码不能为空!');
    });

    //登录
    $('#login-button').on('click', function () {
      var account = $('#account').val();
      var password = $('#password').val();
      console.log('login');
      $.ajax({
        url: '/login',
        method: 'POST',
        dataType: 'json',
        data: {
          account: account,
          password: password,
        },
        success: function (result) {
          if (result.code == 200) {
            window.location.href = '/index';
          } else if (result.code == 404) {
            alert(result.message);
          } else {
            alert('用户名或密码错误！');
          }
        }
      })
    });

    //激活账户
    $('#check').on('click',function () {
      var account=$('#account').val();
      window.location.href='/next?email='+account;
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

