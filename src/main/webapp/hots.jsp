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
          <h6 class="afh">
            热搜
            <small>· <a href="#">查看其他热榜</a></small>
          </h6>
          <ul class="dc axg">
            <c:if test="${hots != null || hots.size() > 0}" var="hasHots">
              <c:forEach items="${hots}" var="hot">
                <li><a href="${hot.url}" target="_blank">${hot.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${not hasHots}">
              <li>暂时没有数据啦！</li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>

    <!-- 热榜数据 -->
    <div class="fj">
      <div class="pz vp vy afo">
        <!-- 排行榜 -->
        <div class="qa">
          <h6 class="afh">
            热搜
            <small>· <a href="#">查看其他热榜</a></small>
          </h6>
          <ul class="dc axg">
            <c:if test="${hots != null || hots.size() > 0}" var="hasHots">
              <c:forEach items="${hots}" var="hot">
                <li><a href="${hot.url}" target="_blank">${hot.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${not hasHots}">
              <li>暂时没有数据啦！</li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>

    <!-- 热榜数据 -->
    <div class="fj">
      <div class="pz vp vy afo">
        <!-- 排行榜 -->
        <div class="qa">
          <h6 class="afh">
            热搜
            <small>· <a href="#">查看其他热榜</a></small>
          </h6>
          <ul class="dc axg">
            <c:if test="${hots != null || hots.size() > 0}" var="hasHots">
              <c:forEach items="${hots}" var="hot">
                <li><a href="${hot.url}" target="_blank">${hot.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${not hasHots}">
              <li>暂时没有数据啦！</li>
            </c:if>
          </ul>
        </div>
      </div>
    </div>

    <!-- 热榜数据 -->
    <div class="fj">
      <div class="pz vp vy afo">
        <!-- 排行榜 -->
        <div class="qa">
          <h6 class="afh">
            热搜
            <small>· <a href="#">查看其他热榜</a></small>
          </h6>
          <ul class="dc axg">
            <c:if test="${hots != null || hots.size() > 0}" var="hasHots">
              <c:forEach items="${hots}" var="hot">
                <li><a href="${hot.url}" target="_blank">${hot.title}</a></li>
              </c:forEach>
            </c:if>
            <c:if test="${not hasHots}">
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