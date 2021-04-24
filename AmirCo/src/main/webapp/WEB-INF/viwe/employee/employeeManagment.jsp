<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 3/15/2021
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../assets/jquery.min.js"></script>
    <script type="text/javascript" src="../assets/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../assets/bootstrap.min.css">

</head>
<body>
<H1 class="">employee managment</H1>
<div>

        <thead>
    <tr>
        <td><input type="submit" value="تعریف نقش" id="category" onclick="category()">
        <td><a class="btn btn-info" href="<c:url value='/employeList'/>">لیست کارمندان</a></td>
        <td><input type="submit" value="تعریف کاربرجدید" onclick="employe()"></td>
        <td><input class="btn btn-info" type="submit" value="اصلاح کاربر" onclick="updateEmploye()"></td>
    </tr>
        </thead>
</div>
<div id="empdive"></div>
<p id="p2"></p>

<p id="p1">${status}</p>


</body>
<script type="application/javascript"></script>
<script>
    function category() {
        $("#p2").append("<form action='/CEC/createCategoryElement.do' method='post'></td> " +
            "<tr><td><input class='text day-name-cell'  height='5' type='text' id='persianName'required name='persianName'></td>نام" +
            "<td><input class='text day-name-cell' width='150' type='text' id='code' name='code'></td>کد" +
            "<td><input class='btn-group-vertical' value='تایید' type='submit'></td></tr></form>");
    }

    function employe() {
        $("#p2").html("<dive><form action='creatEmploye' method='post'>" +
            "<tr> " +
            "<td><input type='text'id='name'  required name='name'>نام</td></br>" +
            "<td><input type='text'id='family' required name='family'>نام خانوادگی</td></br>" +
            "<td><input type='text' id='managerName' required name='managerName'> نام مدیر</td></br>" +
            "<td><input type='text' id='roleName'required name='roleName'>نام نقش</td></br>" +
            "<td><input type='submit' value='ثبت'></td>" +
            "</form> </dive>" + "<br>" +
            "درصورتی که مدیر مستقیم ندارد مقدار(مدیر) رابرایش وارد کنید"
        );
    }

    function updateEmploye() {
        $("p").html("<dive><form id='form' action='/findEmployee' onsubmit='validateForm()' method='post'> " +
            "نام:<input type='text'id='name' required name='name'>" +
            "<input type='submit' value='جستجو کاربر''>" +
            "</form></dive>");
    }


</script>

</html>
