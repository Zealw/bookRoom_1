<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/30
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>处理结果信息</title>
</head>
<c:if test="${result.result}">
    <body style="background: url('${pageContext.request.contextPath}/img/success.jpg'); background-size: 100%">
    <h1>${result.message}</h1>
    <form action="${pageContext.request.contextPath}/order/pay" method="post">
        <table border="1">
            <tr>
                <th>订单编号</th>
                <th>会议室编号</th>
                <th>下单时间</th>
                <th>会议室租借开始</th>
                <th>会议室租借结束</th>
                <th>付款</th>
            </tr>
                <tr>
                    <td><input type="text" name="code" value="${order.code}"></td>
                    <td><input type="text" name="rid" value="${order.rid}"></td>
                    <td><input type="text" value="<fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日HH时mm分ss秒" />"></td>
                    <td><input type="text" value="<fmt:formatDate value="${order.rBegin}" pattern="yyyy年MM月dd日HH时mm分ss秒" />"></td>
                    <input type="hidden" name="createTime" value="${order.createTime}">
                    <input type="hidden" name="rBegin" value="${order.rBegin}">
                    <input type="hidden" name="rEnd" value="${order.rEnd}">
                    <td><input type="text" value="<fmt:formatDate value="${order.rBegin}" pattern="yyyy年MM月dd日HH时mm分ss秒" />"></td>
                    <td><input type="submit" value="付款"></td>
                </tr>
        </table>
    </form>
    </body>
</c:if>
<c:if test="${!result.result}">
    <body style="background: url('${pageContext.request.contextPath}/img/index/fail.jpg');background-size: 100%;">
    <h1>${result.message}</h1>

    </body>
</c:if>
</html>
