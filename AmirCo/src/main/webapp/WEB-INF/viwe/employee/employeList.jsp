<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/15/2021
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">--%>
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



<div>
    <table class="table table-hover">
        <thead>
        <th>name</th>
        <th>family</th>
        <th>role</th>
        <th>manager</th>
        <th></th>
        <th></th>

        </thead>
        <tbody>
        <c:forEach var="listValue" items="${employeList}">
            <c:if test="${listValue.c_activation=='false'}">
                <tr>

                    <form action="/updateEmploye/${listValue.id}/${listValue.c_version}" method="post">
                        <td><input class="form-control" required type="text" name="name" value="<c:out value='${listValue.c_name}'/>"></td>
                        <td><input class="form-control" required type="text" name="family" value="<c:out value='${listValue.c_family}'/>"></td>
                        <td><input class="form-control" required type="text" name="roleName" value="<c:out value='${listValue.c_role.c_persianName}'/>"></td>
                        <td><input class="form-control" required type="text" name="managerName" value="<c:out value='${listValue.manager.c_name}'/>"></td>
                        <td><input type="submit" value="به روزرسانی"></td>
                        <td><a class="btn btn-info" href="<c:url value='/deleteEmploye/${listValue.id}/${listValue.c_version}' />">حذف</a></td>
                        <td><a class="btn btn-info" href="<c:url value='/deactive/${listValue.id}/${listValue.c_version}' />">غیرفعال</a></td>

                    </form>
                </tr>
            </c:if>
            <c:if test="${listValue.c_activation=='true'}">
                <tr>
                    <form action="/updateEmploye/${listValue.id}/${listValue.c_version}" method="post">
                        <td><input class="text-danger" type="text" name="name" value="<c:out value='${listValue.c_name}'/>"></td>
                        <td><input class="text-danger" class="text-danger" type="text"name="family" value="<c:out value='${listValue.c_family}'/>"></td>
                        <td><input class="text-danger" type="text" name="roleName" value="<c:out value='${listValue.c_role.c_persianName}'/>"></td>
                        <td><input class="text-danger" type="text"  name="managerName" value="<c:out value='${listValue.manager.c_name}'/>"></td>
                        <td><input class="text-danger" type="submit" value="به روزرسانی"></td>
                        <td><a class="btn btn-info" href="<c:url value='/deleteEmploye/${listValue.id}/${listValue.c_version}' />">حذف</a></td>
                        <td><a class="btn btn-info" href="<c:url value='/reactive/${listValue.c_version}/${listValue.id}'/>">فعال سازی</a></td>

                    </form>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
<p>${status}</p>
<%--<p>${employeList.get(2).c_role.c_persianName}</p>--%>

</body>
<script>
    <%--$(function () {--%>
    <%--    console.log(${employeList.get(2).c_role.c_persianName})--%>
    <%--});--%>
    <%--$("#${listValue.c_activation}").$(function () {--%>
    <%--    $("form input:text").css({--%>
    <%--        background: "yellow",--%>
    <%--        // border: "3px red solid"--%>
    <%--    }),--%>
    <%--        $("form input:submit").css("background-color", "gray"// border: "3px red solid"--%>
    <%--        );--%>
    <%--})--%>
    // })
</script>
</html>