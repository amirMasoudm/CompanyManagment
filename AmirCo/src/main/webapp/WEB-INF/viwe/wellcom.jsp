<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/14/2021
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <script type="text/javascript" src="../assets/jquery.min.js"></script>
    <script type="text/javascript" src="../assets/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../assets/bootstrap.min.css">

    <title>Title</title>
</head>
<body>
<td><a class="btn btn-info" href="<c:url value='/swichToEmployeManagment'/>">داشبورد ادمین</a></td>
<td><input type="submit" onclick="findEmploye()" value="پنل کاربری"></td>
<p></p>
</body>
<script type="application/javascript"></script>

<script>
    function findEmploye() {
        $("p").html("<dive><form action='/findEmployee' method='post'> " +
            "<input type='text'id='name' required name='name'>نام" +
            "<input type='submit' value='جستجو کاربر'>" +
            "</form></dive>");
    }
</script>
</html>
