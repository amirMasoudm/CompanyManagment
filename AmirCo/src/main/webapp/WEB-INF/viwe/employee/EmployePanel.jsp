<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/14/2021
  Time: 1:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="../assets/jquery.min.js"></script>
    <script type="text/javascript" src="../assets/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../assets/bootstrap.min.css">

    <title>Title</title>
</head>
<body>

<div id="${employeList.get(0).manager.c_name}">
<c:if test="${employeList.get(0).manager.c_name=='مدیر'}">
    <td><a class="btn btn-info" href="<c:url value='/managerLeaveRequest/${employeList.get(0).id}'/>">بررسی درخواست پرسنل</a></td>
</c:if>
    <td><a class="btn btn-info" href="<c:url value='/switchToEmailPanel/${employeList.get(0).id}'/>">پیام ها</a></td>
    <td><input type="submit" value="اصلاح اطلاعات کاربری" onclick="updateEmploye()"></td>
    <td><a class="btn btn-info" href="<c:url value='/switchToCrateLeave/${employeList.get(0).id}'/>">ثبت درخواست مرخصی</a></td>
    <td><a class="btn btn-info" href="<c:url value='/LeaveList/${employeList.get(0).id}'/>">لیست درخواست های مرخصی</a></td>
</div>
<p>${status}</p>
<p id="p1"></p>
</body>
<script>
    function leave() {
        console.log("gg")
        $("#p1").append("<dive><form action='createLeve/${employeList.get(0).id}' method='post'> " +
            "<input type='date'id='fromDate' name='fromDate'>از تارخ" +
            "<input type='date'id='toDate' name='toDate'>تا تارخ" +
            "<input type='submit' value='ثبت'>" +
            "</form> </dive>" + "</br>"
        );
    }

    function updateEmploye() {
        $("#p1").html("<form action='/findEmployee' method='post'> " +
            "<input type='text'id='name' name='name' value='${employeList.get(0).c_name}' readonly>" +
            "<input type='submit' value='جستجو کاربر''>" +
            "</form>");
    }

</script>
</html>
