<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Person Page</title>
</head>
<body>


    <h3>${test}</h3>

    <table border="2">
        <tr>
            <td>Id</td>
            <td>Nama</td>
            <td>Alamat</td>
        </tr>

        <c:forEach items="${data}" var="it">
            <tr>
                <td>${it.id}</td>
                <td>${it.nama}</td>
                <td>${it.alamat}</td>
            </tr>
        </c:forEach>

    </table>

    <a href="/arief/person/insert">Form insert Person</a>

</body>
</html>
