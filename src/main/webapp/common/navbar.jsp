<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 主导航栏 -->
<nav class="ck pt adq py tk app-navbar">
  <a class="e" href="/index">
    sharebook
  </a>

  <div class="collapse f" id="navbarResponsive">
    <!-- 左侧导航栏 -->
    <ul id="nav" class="navbar-nav ahq">
      <li class="pi">
        <a class="pg" href="/index">首页</a>
      </li>
      <li class="pi">
        <a class="pg" href="/attention">关注</a>
      </li>
      <li class="pi">
        <a class="pg" href="/hots">摸鱼热榜</a>
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
    <%-- 已登录 --%>
    <c:if test="${sessionScope.get(\"login\") != null}" var="hasLogin">
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
        <li class="pi"><a class="pg" href="/profile">个人信息</a></li>
        <li class="pi"><a id="logout" class="pg" href="javascript:void(0)" onclick="logout()">退出登录</a></li>
      </ul>
    </c:if>
    <%-- 未登录 --%>
    <c:if test="${not hasLogin}">
      <!-- 未登录的样式 -->
      <ul class="nav navbar-nav">
        <li class="pi"><a class="pg" href="/register">注册</a></li>
        <li class="pi"><a class="pg" href="/login">登录</a></li>
      </ul>
    </c:if>
  </div>
</nav>
