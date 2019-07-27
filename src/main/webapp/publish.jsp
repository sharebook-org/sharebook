<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>发表微博</title>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body class="bob">
<div class="bon" id="app-growl"></div>

<jsp:include page="./common/navbar.jsp"></jsp:include>

<!-- 左侧个人信息 -->
<div class="by aha ahl">
  <div class="dp">

    <div class="fj"></div>

    <div class="fm">
      <ul class="ca bow box afo">
        <li>
          <div style="display: flex; flex-direction: row;margin-bottom: 10px;">
            <textarea type="text" rows="4" class="form-control" placeholder="分享新鲜事"></textarea>
            <button class="cg nz ok" id="publish-button">发布</button>
          </div>
        </li>
        <li class="ca bow box afo">
          <form enctype="multipart/form-data">
            <input type="file" id="images" accept="image/*" multiple>
            <button type="button" id="upload">上传</button>
          </form>
        </li>

      </ul>
    </div>
  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
<script>
  var images;
  $(function () {
    //发送图片
    $('#upload').click(function () {
      var files = $('#images').prop('files');
      var formData = new FormData();
      for (var i = 0; i < files.length; i++) {
        formData.append('images', files[i]);
      }
      $.ajax({
        url: '/upload',
        method: 'POST',
        data: formData,
        dataType: 'json',
        cache: false,
        processData: false,
        contentType: false,
        success: function (result) {
          images = result.data;
          alert("上传成功！");
        }
      });
    });

    $('#publish-button').on('click', function () {
      console.log("images" + images);
      var article = $('#article').val();
      var res = notBlank(article);
      if (!res) {
        alert('文章内容不能为空!');
      } else {
        $.ajax({
          url: '/article',
          method: 'POST',
          data: {
            userId: ${user.id},
            article: article,
            images: images
          },
          success: function (result) {
            if (result.code == 200) {
              alert('发表文章成功！');
              window.location.href = '/index';
            } else {
              alert('发表文章失败！');
              window.location.href = '/publish';
            }
          }
        })
      }
    });


  });
</script>
</body>
</html>