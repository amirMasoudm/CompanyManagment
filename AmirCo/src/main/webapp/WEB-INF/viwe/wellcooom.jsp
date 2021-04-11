<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 3/15/2021
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <script type="text/javascript" src="../assets/jquery.min.js"></script>
    <script type="text/javascript" src="../assets/bootstrap.min.js"></script>
</head>
<body>
<H1>company managment</H1>
<div>
    <div>
        <input type="submit" value="تعریف نقش" id="category" onclick="category()">
        <input type="submit" value="لیست کارمندان" id="status" onclick="employeList()">
        <input type="submit" value="تعریف کاربرجدید" onclick="employe()">
        <input type="submit" value="اصلاح کاربر" onclick="findEmploye()">
    </div>
    <div id="empdive"></div>
    <p id="p1"></p>

</div>
</body>
<script>
    function category() {
        $("p").html("<input type='text' id='persianName'name='persianName'value='name'>" +
            "<input type='text' id='codeF' name='code'value='code'>" +
            "<input type='submit' onclick='categoryElement()'>")
    }

    function categoryElement() {
        var categoryVO = {
            "persianName": $("#persianName").val()
            , "code": $("#code").val(),
        }
        console.log("DD" + categoryVO)
        $.ajax({
                type: 'POST',
                contentType: "application/json",
                url: "/CEC/createCategoryElement.do",
                data: JSON.stringify(categoryVO),
                success: function (data) {
                    alert(data)
                },
            }
        )
    }

    function employe() {
        $("p").html("<dive>" +
            "<input type='text'id='name' name='name'value='نام'>" +
            "<input type='text'id='family' name='family'value='نام خانوادگی'>" +
            "<input type='text' id='managerId' name='managerId'value='کد مدیر'> " +
            "<input type='text' id='roleId' name='roleId'value='کد نقش'>" +
            "<input type='submit' value='ثبت' onclick='createEmploye()'>" +
            "</dive>" + "<br>" +
            "درصورتی که مدیر مستقیم ندارد مقدار 0 رابرایش وارد کنید"
        )
    }

    function createEmploye() {
        var EmployeVO = {
            "name": $("#name").val(),
            "family": $("#family").val(),
            "managerId": $("#managerId").val(),
            "roleId": $("#roleId").val(),
        }
        console.log("DD" + EmployeVO)
        $.ajax({
                type: 'POST',
                contentType: "application/json",
                url: "/creatEmploye",
                data: JSON.stringify(EmployeVO),
                success: function (data) {
                    alert(data)
                },
            }
        )
    }

    function findEmploye() {
        $("p").html("<dive>" +
            "<input type='text'id='empId' value='id'>" +
            "<input type='submit' value='جستجو کاربر' onclick='editEmploye()'>" +
            "</dive>")
    }

    function editEmploye() {
        var id = $("#empId").val();
        $.ajax({
                type: 'POST',
                url: '/findEmployee',
                data: {id: id},
                success: function (data) {
                    showEmpoye(data)
                }
            }
        )
    }

    function showEmpoye(data) {
        var eqdd = JSON.stringify(data);
        var managerID;
        if (data.manager != null) {
            managerID = JSON.stringify(data.manager.id);
        } else managerID = "manager";
        $("p").html("<form>" +
            "<input type='number' id='id' value='" + data.id + "' readonly>id" +
            "<input type='number' id='version' value='" + data.c_version + "' readonly> version" +
            "<input type='text' id='name'value='" + data.c_name + "'>name" +
            "<input type='text' id='family'value='" + data.c_family + "'>family" +
            "<input type='text' id='roleId'value='" + JSON.stringify(data.c_role.id) + "'>role id" +
            "<input type='text' id='managerId'value='" + managerID + "'>manager id" +
            "<input type='submit' id='updateEmp' value='ثبت ویرایش' onclick='updateEmploye()'>" +
            "</form>")
    }

    function updateEmploye() {
        var employeVO = {
            "name": $("#name").val(),
            "family": $("#family").val(),
            "managerId": $("#managerId").val(),
            "roleId": $("#roleId").val(),
            "version": $("#version").val(),
            "id": $("#id").val(),
        };
        $.ajax({
                type: 'POST',
                contentType: "application/json",
                url: "/updateEmploye",
                data: JSON.stringify(employeVO),
                success: function (data) {
                    console.log(data),
                        alert(data)
                },
            }
        )
    }

    function employeList() {
        $.ajax({
                type: 'POST',
                contentType: "application/json",
                url: "/employeList",
                success: function (data) {
                    showList(data)
                },
            }
        )
    }

    function showList(data) {
        $("p").html(
            "<table class='table'>" +
            "<th>" +
            "<th width='150'>id</th>" +
            "<th width='150'>name</th>" +
            "<th width='150'>family</th>" +
            "<th width='150'>role</th>" +
            "<th width='150'>manager</th>" +
            "</thead>" +
            "</table>" +
            "<div id='divee'>");
        var manager;
        $.each(data, function (k, v) {

            if (v.manager == null) {
                manager = "manager";
            } else manager = v.manager.c_name;

            $("#divee").append("<tr>" +
                "<td><input type='text' class='form-control' id='id' value='" + v.id + "'readonly></td>" +
                "<td><input type='text' id='id' class='form-control' value='" + v.c_name + "'readonly></td>" +
                "<td><input type='text' id='id' class='form-control' value='" + v.c_family + "'readonly></td>" +
                "<td><input type='text' id='id' class='form-control' value='" + v.c_role.c_persianName + "'readonly></td>" +
                "<td><input type='text' id='id' class='form-control' value='" + manager + "'readonly></td>" +
                "</tr>")
        });
    }
</script>

</html>
