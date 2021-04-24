<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/22/2021
  Time: 3:44 AM
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
<tr><a class="btn btn-info" style="background-color: sienna" href="<c:url value='/switchTodendMail/${employe.id}'/>">ارسال پیام</a></tr></br>
<tr><a class="btn btn-info" style="background-color: sienna" href="<c:url value='/inbox/${employe.id}'/>">صندوق پیام</a></tr>

</body>
</html>
