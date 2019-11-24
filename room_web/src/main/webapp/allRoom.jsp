<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>会议室</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <th>会议室编号</th>
        <th>价格</th>
    </tr>
    <c:forEach items="${rooms}" var="room">

        <tr>
            <td>${room.id}</td>
            <td>${room.price}</td>
            <td><a href="${pageContext.request.contextPath}/order/add?rid=${room.id}">预定</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
