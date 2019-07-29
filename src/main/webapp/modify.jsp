<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>修改密码</title>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="./common/nav.jsp"></jsp:include>
<div class="do axz">
  <div class="ayb">
    <form class="ahr avz j">
      <h1 class="l afv">修改密码</h1>
      <div class="mu">
        <input id="userName" class="form-control" placeholder="账号"/>
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
            id="rePassword"
            type="password"
            class="form-control"
            placeholder="重复密码"
        />
      </div>

      <div class="mu afh">
        <input
            id="newPassword"
            type="password"
            class="form-control"
            placeholder="新密码"
        />
      </div>

      <div class="afv">
        <button class="cg ns" type="button" id="updatePwd-button">修改密码</button>
      </div>

      <footer class="bqx">
        <a href="/index" class="axc">回到主页</a>
      </footer>
    </form>
  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
  $(function () {
    $('#userName').blur(function () {
      var userName = $('#userName').val();
      var res1 = notBlank(userName);
      showErrorMessage(res1, '账户不能为空！');
    });

    $('#password').blur(function () {
      var password = $('#password').val();
      var res2 = notBlank(password);
      showErrorMessage(res2, '密码不能为空！');
    });

    $('#rePassword').blur(function () {
      var res3 = checkPassword();
      showErrorMessage(res3, '重复密码输入有误！');
    });

    $('#newPassword').blur(function () {
      var newPassword = $('#newPassword').val();
      var res4 = notBlank(newPassword);
      showErrorMessage(res4, '请输入新密码！');
    })

    $('#updatePwd-button').on('click', function () {
      var userName = $('#userName').val();
      var password = $('#password').val();
      var rePassword = $('#rePassword').val();
      var newPassword = $('#newPassword').val();
      $.ajax({
        url: '/forget',
        method: 'POST',
        dataType: 'json',
        data: {
          password: password,
          userName: userName,
          newPassword: newPassword,
        },
        success: function (result) {
          if (result.code == 200) {
            alert('修改密码成功,1秒后跳到登录页面！');
            setTimeout(function () {
              window.location.href = '/login';
            }, 1000);
          } else {
            alert('修改密码失败');
          }
        }
      })
    })
  });

  function checkPassword() {
    var password = $('#password').val();
    var repeatPassword = $('#rePassword').val();
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
      $('#updatePwd-button').attr('disabled', 'disabled');
    } else {
      $('#error-message').hide();
      $('#updatePwd-button').removeAttr('disabled');
    }
  }
</script>
</body>
</html>