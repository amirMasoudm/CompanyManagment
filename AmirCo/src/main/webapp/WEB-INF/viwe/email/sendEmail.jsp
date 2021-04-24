<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/20/2021
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script type="text/javascript" src="../assets/jquery.min.js"></script>
    <script type="text/javascript" src="../assets/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../assets/bootstrap.min.css">

    <title>Title</title>

</head>
<dive >
<table >
    <thead  >انتخاب دریافت کننده
    <tr>
        <th> name</th>
        <th>family</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="listValue" items="${employeList}">
        <tr>
            <td><input readonly type="text" size="5"   value="<c:out value='${listValue.c_name}'/>"></td>
            <td><input readonly type="text" size="5" value="<c:out value='${listValue.c_family}'/>"></td>
            <td>
                <input class="form-control" type="submit" readonly value="add" onclick="getreciver('${listValue.c_name}')" )>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</dive>
<input type="submit" value="تایید دریافت کنندگان" onclick="sendEmail()">

    <P class='form-control' id="getListReciver">recivers:</P>

    <P id="getcontent"></P>
<p>${status}</p>
</body>
<script>
    var reciverNames = [];

    function removeReciver(name) {
        console.log(reciverNames)
        const index = removeReciver().indexOf(name);
        reciverNames.splice(index);
        console.log(reciverNames)
    }

    function getreciver(name) {
        console.log(name)
        reciverNames.push(name);
        $("#getListReciver").append("<input type='text' name='reciverNames' value='{" + name + "}'>");
    }

    function sendEmail() {
        $("#getcontent").html("<form class='form-control' action='/createEmail/{" + reciverNames + "}'enctype='multipart/form-data'  method='post'>" +
            "<tr><td>sender<input class='form-control' type='text' id='employeName' name='employeName' readonly value='${employeList.get(0).c_name}'></td>" +
            "<td>subject<input class='form-control' type='text' id='subject' name='subject' ></td>" +
            "<td>attachment<input class='form-control'type='file' value='file Upload' id='attachmentFile'g name='attachmentFile' ></td>" +
            "<div><textarea class='form-control' id='content' name='content' cols='50' rows='15'></textarea><div>" +
            "<td><input type='submit' value='send mail'></td></tr></form>");
    }


    function toSendEmail() {
        $("#p1").append("<div>" +
            "<form action='fg/' method='post'> " +
            "<tr><td><input type='text' id='subject'></td></tr>" +
            "<tr><td><textarea id='content' name='content' rows='8' cols='50'/></td></tr>" +
            "<tr><td><textarea id='content' name='content' rows='8' cols='50'/></td></tr>" +
            "<tr><td><input type='submit' onclick=''></td></tr>" +
            "" +
            "</form></div>")
    }
</script>
</html>
