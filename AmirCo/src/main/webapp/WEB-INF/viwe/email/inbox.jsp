<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/22/2021
  Time: 3:57 AM
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
    <link rel="stylesheet" href="../assets/bootstrap.min.css">

    <title>Title</title>
</head>
<body>

<div id="${email.c_activation}">

    <table class='table'>
        <th width='150'>sender</th>
        <th width='150'>subject</th>

        </thead>
        <tbody>
        <c:forEach var="listValue" items="${inbox}">
            <tr>
                <form action="/openEmaile/${listValue.id}" method="post">
                    <td><input class="form-control" type="text" value=${listValue.c_sender.c_name}></td>
                    <td><input class="form-control" type="text" value=${listValue.c_subject}></td>
                    <td><input class="form-control" type="submit" value="مشاهده"></td>
                </form>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
<script>

    $(function () {

        $("#${email.c_activation}")
            .html("<form class='form-control enctype='multipart/form-data'  method='post'>" +
                "<tr><td>sender<input class='form-control' type='text' id='employeName' name='employeName' readonly value='${email.c_sender.c_name}'></td>" +
                "<td>subject<input class='form-control' type='text' id='subject' name='subject' value='${email.c_subject}'></td>" +
                "<div><textarea class='form-control' id='content' name='content'  cols='50' rows='15'>${email.c_content}</textarea><div>" +
                "<c:if test="${attachments.get(0).c_attachmentFile!=null}">" +
                "<c:forEach var="val" items="${attachments}">" +
                "<td><a href='<c:url value='/downloadFile/${val.id}'/>'>${val.docName}</a></td>" +
                "</c:forEach></c:if>" +
                "</tr></form>");

    })
</script>
</html>
