<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 主导航栏 -->
<nav class="ck pt adq py tk app-navbar">
  <a class="e" href="./index.jsp">
    sharebook
  </a>

  <div class="collapse f" id="navbarResponsive">
    <!-- 左侧导航栏 -->
    <ul class="navbar-nav ahq">
      <li id="index" class="pi">
        <a class="pg" href="./index.jsp">首页</a>
      </li>
      <li id="attention" class="pi">
        <a class="pg" href="./attention.jsp">关注</a>
      </li>
    </ul>

    <!-- 搜索框 -->
    <form class="nn acx d-none vt">
      <input
          class="form-control"
          type="text"
          data-action="grow"
          placeholder="搜索"
      />
    </form>

    <!-- 未登录的样式 -->
    <ul class="nav navbar-nav">
      <li class="pi"><a class="pg" href="./register.jsp">注册</a></li>
      <li class="pi"><a class="pg" href="./login.jsp">登录</a></li>
    </ul>
    <!-- 登录后的样式 -->
    <ul id="#js-popoverContent" class="nav navbar-nav acx aek d-none vt">
      <!-- 登录的头像 -->
      <li class="pi afb">
        <button class="cg bpo bpp boi" data-toggle="popover">
          <img class="us" src="assets/img/avatar-dhg.png">
        </button>
      </li>
    </ul>
    <ul class="nav navbar-nav d-none" id="js-popoverContent">
      <li class="pi"><a class="pg" href="./profile.jsp">个人信息</a></li>
      <li class="pi"><a class="pg" href="./index.jsp">退出登录</a></li>
    </ul>
  </div>
</nav>
