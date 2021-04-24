<%--
  Created by IntelliJ IDEA.
  User: AmirMasoud
  Date: 4/19/2021
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <tr>
            <th width='130'>from Date</th>
            <th width='130'>to Date</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/createLeve/${employe.id}">
                <td><input type='date' required id='fromDate' name='fromDate'></td>
                <td><input type='date' required id='toDate' name='toDate'></td>
                <td><input type='submit' value='ثبت'></td>
            </form>
        </tr>
        </tbody>
    </table>i
    .
</div>
<p>${status}</p>
</body>
</html>
