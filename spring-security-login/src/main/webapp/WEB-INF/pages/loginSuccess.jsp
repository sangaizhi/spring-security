<%--
  Created by IntelliJ IDEA.
  User: sangaizhi
  Date: 2017/7/5
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Success</title>
</head>
<body>
登录<span style="color:#008000">成功</span>后的跳转页面
<p><a href="<c:url value="/logout"/> ">logout</a> </p>
<p><a href="<c:url value="/myLogout"/> ">My Logout</a> </p>
</body>
</html>
