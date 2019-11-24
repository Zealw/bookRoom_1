<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>下单</title>
</head>
<body>
会议室编号:
<input type="text" name="rid" value="${rid}">
<br>
已预定时间段：
<br>
<c:forEach items="${orders}" var="order">
    <fmt:formatDate value="${order.rBegin}" pattern="yyyy年MM月dd日HH时mm分ss秒" />
    --
    <fmt:formatDate value="${order.rEnd}" pattern="yyyy年MM月dd日HH时mm分ss秒" />
    <br>
</c:forEach>

<form action="${pageContext.request.contextPath}/order/myOrder" method="post">
    <input type="hidden" name="rid" value="${rid}">
    <br>
    预定时间段：
    <input type="text" name="rBegin">
    至
    <input type="text" name="rEnd" >
    <br>
    <input type="submit" name="" id="" value="下单">
</form>
</body>
</html>
