<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>热榜</title>
  <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body class="bob">

<jsp:include page="./common/navbar.jsp"></jsp:include>

<div class="by aha ahl">
  <div class="dp">
    <!-- 热榜数据 -->
    <div class="fj">
      <div class="pz vp vy afo">
        <!-- 排行榜 -->
        <div class="qa">
          <h6 class="afh">微博热搜</h6>
          <ul class="dc axg">
            <c:if test="${!empty weiboHots}">
              <c:forEach items="${weiboHots}" var="weibo">
                <li><a href="${weibo.url}" target="_blank">${weibo.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${empty weiboHots}">
              <li>暂时没有数据啦！</li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>

    <%-- 知乎 --%>
    <div class="fj">
      <div class="pz vp vy afo">
        <!-- 排行榜 -->
        <div class="qa">
          <h6 class="afh">知乎热搜</h6>
          <ul class="dc axg">
            <c:if test="${!empty zhihuHots}">
              <c:forEach items="${zhihuHots}" var="zhihu">
                <li><a href="${zhihu.url}" target="_blank">${zhihu.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${empty hasZhihuHots}">
              <li>暂时没有数据啦！</li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>

    <%-- 虎扑 --%>
    <div class="fj">
      <div class="pz vp vy afo">
        <!-- 排行榜 -->
        <div class="qa">
          <h6 class="afh">虎扑热搜</h6>
          <ul class="dc axg">
            <c:if test="${!empty hupuHots}">
              <c:forEach items="${hupuHots}" var="hupu">
                <li><a href="${hupu.url}" target="_blank">${hupu.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${empty hasHupuHots}">
              <li>暂时没有数据啦！</li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>

    <%-- 天涯 --%>
    <div class="fj">
      <div class="pz vp vy afo">
        <!-- 排行榜 -->
        <div class="qa">
          <h6 class="afh">天涯热搜</h6>
          <ul class="dc axg">
            <c:if test="${!empty tianyaHots}">
              <c:forEach items="${tianyaHots}" var="tianya">
                <li><a href="${tianya.url}" target="_blank">${tianya.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${empty tianyaHots}">
              <li>暂时没有数据啦！</li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>

  </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>
</body>
</html>