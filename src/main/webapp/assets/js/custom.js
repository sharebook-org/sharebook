$(function () {
  //切换导航栏
  $('.navbar-nav li a').each(function () {
    if ($($(this))[0].href == String(window.location))
      $(this).parent().addClass('active');
  });
});

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

