$(function () {
  //切换导航栏
  $('.navbar-nav li a').each(function () {
    console.log($($(this))[0]);
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
    success: function () {
      window.location.href = '/index';
    }
  })
}
