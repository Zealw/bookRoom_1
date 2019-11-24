<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>allOrder</title>
</head>
<body>
<table border="1">
    <tr>
        <th>订单编号</th>
        <th>会议室编号</th>
        <th>下单时间</th>
        <th>是否付款</th>
        <th>付款时间</th>
        <th>会议室租借开始</th>
        <th>会议室租借结束</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.code}</td>
            <td>${order.rid}</td>
            <td><fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日HH时mm分ss秒" /></td>
            <td>${order.payYoN}</td>
            <td><fmt:formatDate value="${order.payTime}" pattern="yyyy年MM月dd日HH时mm分ss秒" /></td>
            <td><fmt:formatDate value="${order.rBegin}" pattern="yyyy年MM月dd日HH时mm分ss秒" /></td>
            <td><fmt:formatDate value="${order.rEnd}" pattern="yyyy年MM月dd日HH时mm分ss秒" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
