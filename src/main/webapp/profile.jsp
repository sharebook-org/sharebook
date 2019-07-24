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
        <a class="pg active" href="#">主页</a>
      </li>
      <li class="pi">
        <a class="pg" href="#">微博</a>
      </li>
      <li class="pi">
        <a class="pg" href="#">相册</a>
      </li>
    </ul>
  </nav>
</div>

<div class="by afl" data-grid="images">

  <p>用户名：<input type="text" name="username" value="${user.username}" id="name"></p>

  <p> 性别：
    <c:if test="${user.sex==0}">
      <input type="text" name="sex" id="sex" value="女"/>
    </c:if>
    <c:if test="${user.sex==1}">
      <input type="text" name="sex" id="sex" value="男"/>
    </c:if>
    <c:if test="${user.sex==2}">
      <input type="text" name="sex" id="sex" value="其他"/>
    </c:if>
  </p>

  <p> 生日：<input type="text" name="birth" value="${user.birth}" id="birth"></p>
  <%-- <select>
       <option>月</option>
       <option>1</option>
   </select>
   <select>
       <option>日</option>
       <option>12</option>
   </select>--%>

  <p>地址：<input type="text" name="location" value="${user.location}" id="location"></p>

  <p>
    <button type="button" id="modify-button">修改</button>
  </p>

</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
  $(function () {

    $('#modify-button').on('click', function () {
      var name = $('#name').val();
      var sex = $('#sex').val();
      var birth = $('#birth').val();
      var location = $('#location').val();
      var birth = $('#birth').val();
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
    })
  });
</script>
</body>
</html>
