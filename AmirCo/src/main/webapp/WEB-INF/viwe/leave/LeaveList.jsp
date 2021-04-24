<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/19/2021
  Time: 5:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script type="text/javascript" src="../assets/jquery.min.js"></script>
    <script type="text/javascript" src="../assets/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../assets/bootstrap.min.css">

    <title>Title</title>
</head>
<body>
<p>${status}</p>
<div>
    <table class='table'>
        <thead>
        <tr>
            <th width='130'>from Date</th>
            <th width='130'>to Date</th>
            <th width='130'>status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="listValue" items="${myLeaveList}">
            <tr>
                <form action="/deleteLeave/${listValue.id}">
                    <td><input class="form-control" type="date " value=${listValue.c_fromDate}></td>
                    <td><input class="form-control" type="date" value=${listValue.c_toDate}></td>
                    <td><input class="form-control" type="text" readonly value="<c:out value='${listValue.c_status.c_persianName}'/>"></td>
                    <td><input type="submit" value="حذف"></td>
                </form>
            </tr>
        </c:forEach></tbody>
    </table>

</div>
</body>
</html>
