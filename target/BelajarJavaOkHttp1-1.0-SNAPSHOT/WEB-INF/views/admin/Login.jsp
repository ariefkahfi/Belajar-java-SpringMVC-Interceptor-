<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page For Admin</title>
</head>
<body>


    <h4>${pesan}</h4>

    <spring:form modelAttribute="admin" action="/arief/admin/login" method="POST">
        <table>
            <tr>
                <td>Kode</td>
                <td><spring:input path="kode" id="kode"/></td>
                <td><spring:errors path="kode"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><spring:password path="password" id="password"/></td>
                <td><spring:errors path="password"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login"/></td>
            </tr>
        </table>
    </spring:form>

    <a href="/arief/admin/login">Hello</a>

</body>



</html>
