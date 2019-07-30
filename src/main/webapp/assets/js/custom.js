$(function () {
  //切换导航栏
  $('.navbar-nav li a').each(function () {
    if ($($(this))[0].href == String(window.location))
      $(this).parent().addClass('active');
  });
});

    //回车搜索
function search(keyWord) {
      $.ajax({
        url: '/search',
        method: 'POST',
        data:{
          keyWord: keyWord,
        },
        success: function (result) {
          if (result.code == 200) {
            alert(result.message)
            //window.location.href = '/index';
          } else {
            alert(result.message);
          }
        }
      });
    }

//检查用户名是否为空
function checkAccount() {
  var account = $('#account').val();
  return notBlank(account);
}

//检测字符串是否为空
function notBlank(value) {
  if (value != null && value != '' && value != undefined) {
    return true;
  }
  return false;
}

//退出账号
function logout() {
  $.ajax({
    url: '/login',
    method: 'DELETE',
    success: function (result) {
      if (result.code == 200) {
        window.location.href = '/index';
      } else {
        alert('退出异常！');
      }
    }
  });
}

function handleCommentClick(id) {
  var href = '/detail?id=' + id;
  window.open(href, '_blank');
}

function like(id,userId) {
  var res= notBlank(userId);
  if (res) {
    $.ajax({
      url: '/like',
      method: 'POST',
      data: {
        method:'like',
        userId: userId,
        entityType: 0,
        entityId: id,
      },
      success:function (result) {
        if (result.code==200){
          alert("点赞成功！");
          window.location.href = '/attention';
        }
      }
    })
  }
  else {
    alert("请登录！");
    window.location.href='/login';
  }

}

function likeCancle(id,userId) {
  var res= notBlank(userId);
  console.log(userId);
  if (res) {
    $.ajax({
      url: '/like',
      method: 'POST',
      dataType:'json',
      data: {
        method: 'cancelLike',
        userId: userId,
        entityType: 0,
        entityId: id,
      },
      success:function (result) {
        if (result.code==200){
          alert("取消点赞成功！");
          window.location.href = '/attention';
        }
      }
    })
  }

}

function follow(articleUserId,userId) {
  var res= notBlank(userId);
  if (res) {
    $.ajax({
      url: '/follow',
      method: 'POST',
      data: {
        method:'follow',
        userId: userId,
        articleUserId: articleUserId,
      },
      success:function (result) {
        if (result.code==200){
          alert("关注成功！");
          window.location.href = '/attention';
        }
      }
    })
  }
  else {
    alert("请登录！");
    window.location.href='/login';
  }


}
function followCancle(articleUserId,userId) {
  var res= notBlank(userId);
  if (res) {
    $.ajax({
      url: '/follow',
      method: 'POST',
      data: {
        method: 'cancelFollow',
        userId: userId,
        articleUserId: articleUserId,
      },
      success:function (result) {
        if (result.code==200){
          alert("取消关注成功！");
          window.location.href = '/attention';
        }
      }
    })
  }

}

