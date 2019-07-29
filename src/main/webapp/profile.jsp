<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>个人简介</title>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body class="bob">

<jsp:include page="./common/navbar.jsp"></jsp:include>

<div class="boq" style="background-image: url(./assets/img/iceland.jpg);">
  <div class="by">
    <div class="bor">
      <img class="us bos" src="./assets/img/avatar-dhg.png">
      <h3 class="bou">${user.username}</h3>
      <p class="bot">
        ${user.introduction}
      </p>
    </div>
  </div>

  <nav class="bov">
    <ul class="nav ph xm">
      <li class="pi">
        <a class="pg active" href="/profile">主页</a>
      </li>
      <li class="pi">
        <a class="pg" href="/my">微博</a>
      </li>
      <li class="pi">
        <a class="pg" href="#">相册</a>
      </li>
    </ul>
  </nav>
</div>

<div class="do axz">
  <div class="ayb">
    <form class="ahr avz j">

      <div class="mu afh">
        <span style="position: relative;left: -170px;top: 28px;">用户名</span>
        <input
            type="text"
            name="username"
            value="${user.username}"
            class="form-control"
            id="name"
      />
      </div>

      <div class="mu afh">
        <span style="position: relative;left: -170px;top: 28px;">手机号</span>
        <input
            id="phone"
            type="text"
            class="form-control"
            value="${user.phone}"
        />
      </div>

      <div class="mu afh">
        <span style="position: relative;left: -170px;top: 28px;">邮箱</span>
        <input
            id="email"
            type="email"
            class="form-control"
            value="${user.email}"
        />
      </div>

      <div class="mu afh">
        <span style="position: relative;left: -170px;top: 28px;">性别</span>
        <c:if test="${user.sex eq '0'}">
          <input type="text" name="sex" id="sex" value="女" class="form-control"/>
        </c:if>
        <c:if test="${user.sex eq '1'}">
          <input type="text" name="sex" id="sex" value="男" class="form-control"/>
        </c:if>
        <c:if test="${user.sex eq '2'}">
          <input type="text" name="sex" id="sex" value="其他" class="form-control"/>
        </c:if>
      </div>

      <div class="mu afh">
        <span style="position: relative;left: -170px;top: 28px;">生日</span>
        <input
            id="birth"
            type="date"
            class="form-control"
            value=""
        />
      </div>

      <div class="mu afh">
        <span style="position: relative;left: -170px;top: 28px;">地区</span>
        <input
            type="text"
            name="location"
            value="${user.location}"
            class="form-control"
            id="location"
        />
      </div>
      <div id="error-message" class="mu afh" style="display: none">
        <span style="color: #c9302c"></span>
      </div>

      <div class="afv">
        <button type="button" id="modify-button" class="cg nq">修改</button>
      </div>

    </form>
  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
  $(function () {

    $('#name').blur(function () {
      var name = $('#name').val();
      var result = notBlank(name);
      showErrorMessage(result, '用户名不能为空');
    });

    $('#modify-button').on('click', function () {
      var name = $('#name').val();
      var phone = $('#phone').val();
      var email = $('#email').val();
      var sex = $('#sex').val();
      var birth = $('#birth').val();
      var location = $('#location').val();
      if (sex == '女') {
        sex = 0;
      } else if (sex == '男') {
        sex = 1;
      } else {
        sex = 2;
      }

      $.ajax({
        url: '/profile',
        method: 'POST',
        dataType: 'json',
        data: {
          name: name,
          phone: phone,
          email: email,
          sex: sex,
          birth: birth,
          location: location,
        },
        success: function (result) {
          if (result.code == 200) {
            alert('修改成功！');
            window.location.href = "/profile"
          } else {
            alert('修改失败！');
          }
        },
        error: function (result) {
          console.log(result);
        }
      })
    });

    var birth = '${user.birth}';
    $('#birth').val(birth.substring(0, 10));
  });

  //根据结果是否展示错误信息
  function showErrorMessage(result, message) {
    if (!result) {
      $('#error-message span').text(message);
      $('#error-message').show();
      $('#modify-button').attr('disabled', 'disabled');
    } else {
      $('#error-message').hide();
      $('#modify-button').removeAttr('disabled');
    }
  }
</script>
</body>
</html>
