<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>我的关注</title>
    <jsp:include page="./common/head.jsp"></jsp:include>
</head>

<body class="bob">

<jsp:include page="./common/navbar.jsp"></jsp:include>

<div class="by aha ahl">
    <div class="dp">
        <!-- 微博 -->
        <div class="fm" style="margin: 0 auto">
            <ul class="ca bow box afo">
                <!-- 微博主体 -->
                <li class="rv b agz">
                    <!-- 头像 -->
                    <img
                            class="bos vb yb aff"
                            src="assets/img/avatar-dhg.png">
                    <div class="rw">
                        <div class="bpb">
                            <!-- 发表时间 -->
                            <small class="acx axc"><%=request.getSession().getAttribute("createTime")%><%--4 min--%></small>
                            <!-- 昵称 -->
                            <h6>${user.username}</h6>
                        </div>
                        <!-- 微博内容 -->
                        <p>
                            <%=request.getSession().getAttribute("content")%>
                            <%--              Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.--%>
                        </p>
                        <!-- 图片 -->
                        <div class="boy" data-grid="images">
                            <div style="display: none">
                                <img data-action="zoom" data-width="1050" data-height="700" src="assets/img/unsplash_1.jpg">
                            </div>

                            <div style="display: none">
                                <img data-action="zoom" data-width="640" data-height="640" src="assets/img/instagram_1.jpg">
                            </div>

                            <div style="display: none">
                                <img data-action="zoom" data-width="640" data-height="640" src="assets/img/instagram_13.jpg">
                            </div>

                            <div style="display: none">
                                <img data-action="zoom" data-width="1048" data-height="700" src="assets/img/unsplash_2.jpg">
                            </div>
                        </div>

                        <ul class="bow afa">
                            <!-- 评论 -->
                            <li class="rv afh">
                                <img
                                        class="bos vb yb aff"
                                        src="assets/img/avatar-fat.jpg">
                                <div class="rw">
                                    <strong>Jacon Thornton: </strong>

                                    <%--                  Donec id elit non mi porta gravida at eget metus. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Donec ullamcorper nulla non metus auctor fringilla. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Sed posuere consectetur est at lobortis.--%>
                                </div>
                            </li>
                            <!-- 评论 -->
                            <li class="rv">
                                <img
                                        class="bos vb yb aff"
                                        src="assets/img/avatar-mdo.png">
                                <div class="rw">
                                    <strong>Mark Otto: </strong>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.
                                </div>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

    </div>
</div>
<jsp:include page="./common/script.jsp"></jsp:include>

</body>
</html>


