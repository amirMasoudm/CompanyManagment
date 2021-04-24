<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/15/2021
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<html>
<head>
        <script type="text/javascript" src="../assets/jquery.min.js"></script>
        <script type="text/javascript" src="../assets/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../assets/bootstrap.min.css">

    <title>Title</title>
</head>
<body>
<div>
    <table class='table'>
        <thead>
        <th width='150'>name</th>
        <th width='150'>family</th>
        <th width='150'>from Date</th>
        <th width='150'>to Date</th>
        </thead>
        <tbody>
        <c:forEach var="listValue" items="${LeaveList}">
            <tr>
                <form action="/updateEmploye" method="post">
                    <td><input class="form-control" type="text" value="${listValue.c_employe.c_name}"></td>
                    <td><input class="form-control" type="text" value="${listValue.c_employe.c_family}"></td>
                    <td><input class="form-control" type="text" value="${listValue.c_fromDate}"></td>
                    <td><input class="form-control" type="text" value="${listValue.c_toDate}"></td>
                </form>

                <form action="/updateLeave/${listValue.id}">
                    <td> درحال بررسی <input type="radio" name="status" id="sataus" value="تایید شده"/></td>
                    <td> تایید نشده <input type="radio" name="status" value="تایید نشده"/></td>
                    <td > تایید شده <input class="radio-inline" type="radio" name="status" value="درحال بررسی"/></td>
                    <td><input type="submit" value="تغییر وضعیت"></td>
                </form>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script type="text/javascript">

</script>
</html>
